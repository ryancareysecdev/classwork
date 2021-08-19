import java.security.Signature;
import java.util.ArrayList;

public class UserPC {
    public CipherAssistant userCipher = new CipherAssistant();
    private String name;
    private String ipAddress;
    private String mac;
    private String requestedIP;
    private Message message;
    private ArrayList<String> stolenData = new ArrayList<>();


    public UserPC() {
    }

    public UserPC(String name, String ipAddress, String mac) {
        this.name = name;
        this.setIpAddress(ipAddress);
        this.setMac(mac);
    }

    public String requestDNS(DNSServer testServer, String dnsRequest) {
        requestedIP = testServer.giveDnsResponse(dnsRequest);
        return requestedIP;
    }

    public String requestSecDNS(DNSServer testServer, String dnsRequest) {
        System.out.println("looking for: " + dnsRequest);
        userCipher.setCipherText(testServer.giveSecDnsResponse(dnsRequest, this.userCipher.getPubKey()));
        return userCipher.decryptRSA(userCipher.getCipherText());
    }

    public String verifyDNSZoneSig(DNSServer testServer, String lookingFor) throws Exception {
        System.out.println("looking for: " + lookingFor);
        String dnsRecord = testServer.giveSignedDnsResponse(lookingFor);
        testServer.getDnsZoneSigner().initVerify(testServer.serverCipher.getPubKey());
        testServer.getDnsZoneSigner().update(dnsRecord.getBytes());
        if (testServer.getDnsZoneSigner().verify(dnsRecord.getBytes())) {
            return dnsRecord;
        }
        else {
            return "The record is not authentic.";
        }
    }

    public void sendMessage(String destinationIP, String msg) {
        this.message = new Message(destinationIP, msg);
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void interceptMessage(UserPC victim, UserPC badGuy) {
        stolenData.add(victim.readMessage().getMessage());
        victim.message = new Message(badGuy.getIpAddress(), victim.readMessage().getMessage());
    }

    public Message readMessage() {
        return this.message;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getMac() {
        return mac;
    }
}
