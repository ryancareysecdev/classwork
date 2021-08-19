
public class Main {

    public static void main(String[] args) throws Exception {
        cachePoisoning();
        System.out.println();
        manInTheMiddle();
        System.out.println();
        stoppedInTheMiddle();
    }

    public static void manInTheMiddle() {
        UserPC victimJack = new UserPC("Jack Dirt", "22.76.193.230", "2A:E6:3D:FA:CE:56");
        UserPC victimJill = new UserPC("Jill Hurt", "35.89.191.155", "5D:A6:DB:9A:E8:9C");
        UserPC mITM = new UserPC("Bad Guy", "76.65.32.123", "9D:5E:6D:7A:8B:3C");
        System.out.println("Jack: send over your key.");
        victimJack.sendMessage(victimJill.getIpAddress(), "Send over your key.");
        victimJill.sendMessage(victimJack.getIpAddress(), victimJill.userCipher.getPubKey().toString());
        mITM.interceptMessage(victimJill, mITM);
        System.out.println("Intercepted by Man in the Middle.");
        System.out.println("The attacker's key is sent instead.");
        mITM.sendMessage(victimJack.getIpAddress(), mITM.userCipher.getPubKey().toString());
        mITM.userCipher.setCipherText(victimJack.userCipher.encryptRSA("Jack's Secret data", mITM.userCipher.getPubKey()));
        System.out.println("Now jack has the wrong key, and uses it. His secrets are revealed to our man in the middle: \n" + mITM.userCipher.decryptRSA(mITM.userCipher.getCipherText()));
        System.out.println("The attacker logs his data, and sends false data to the intended recipient.");
        System.out.println("Jill: what's your key, Jack?");
        victimJill.sendMessage(victimJack.getIpAddress(), victimJill.userCipher.getPubKey().toString());
        mITM.interceptMessage(victimJill, mITM);
        System.out.println("Intercepted by Man in the Middle.");
        System.out.println("The attacker's key is sent instead.");
        mITM.sendMessage(victimJill.getIpAddress(), mITM.userCipher.getPubKey().toString());
        mITM.userCipher.setCipherText(victimJill.userCipher.encryptRSA("Jill's Secret data", mITM.userCipher.getPubKey()));
        System.out.println("Now jill also has the wrong key, and uses it. Her secrets are revealed to our man in the middle: \n" + mITM.userCipher.decryptRSA(mITM.userCipher.getCipherText()));
        System.out.println("The attacker now has the data of both parties.");
    }

    public static void stoppedInTheMiddle() throws Exception {
        DNSServer attackedServer = new DNSServer("21.231.76.12");
        attackedServer.fillDNS();
        UserPC regularDude = new UserPC("Joe Dirt", "22.76.193.230", "2A:E6:3D:FA:CE:56");
        UserPC blackHatDude = new UserPC("John Hurt", "35.89.191.155", "5D:A6:DB:9A:E8:9C");
        System.out.println("Hacker checks target: " + blackHatDude.requestSecDNS(attackedServer, "C"));
        attackedServer.gotCacheHacked("C", blackHatDude.getIpAddress());
        System.out.println("Hacker has altered the dns record they checked.");
        System.out.println("The regular user employs signature checking to see if the DNS record is authentic: " + regularDude.verifyDNSZoneSig(attackedServer,"C"));

    }

    public static void cachePoisoning() throws Exception {
        DNSServer attackedServer = new DNSServer("21.231.76.12");
        attackedServer.fillDNS();
        UserPC regularDude = new UserPC("Joe Dirt", "22.76.193.230", "2A:E6:3D:FA:CE:56");
        UserPC blackHatDude = new UserPC("John Hurt", "35.89.191.155", "5D:A6:DB:9A:E8:9C");
        System.out.println("Hacker checks target: " + blackHatDude.requestSecDNS(attackedServer, "C"));
        attackedServer.gotCacheHacked("C", blackHatDude.getIpAddress());
        System.out.println("Hacker has altered the dns record they checked.");
        System.out.println("The regular user gets this IP address now instead: " + regularDude.requestDNS(attackedServer, "C"));
    }
}
