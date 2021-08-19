import java.security.PublicKey;
import java.security.Signature;
import java.util.ArrayList;
import java.util.Random;

public class DNSServer {
    private ArrayList<String> dnsEntries = new ArrayList<>();
    private Random ipGenerator = new Random();
    private String serverIP;
    private String ipStringBuilder = "";
    private String dnsResponse;
    private Signature dnsZoneSigner;
    private byte[] dnsZoneSig;
    private char plainTextUrl = 'A';
    public CipherAssistant serverCipher = new CipherAssistant();

    public DNSServer(String serverIP) throws Exception {
        this.serverIP = serverIP;
        this.dnsZoneSigner = Signature.getInstance("NONEwithRSA");
    }

    public void fillDNS() {
        for (int i = 0; i < 21; i++) {
            ipStringBuilder = "";
            for (int a = 0; a < 4; a++) {
                ipStringBuilder = ipStringBuilder + ipGenerator.nextInt(255) + " ";
            }
            ipStringBuilder = ipStringBuilder.trim();
            ipStringBuilder = ipStringBuilder.replaceAll(" ", ".");
            ipStringBuilder = ipStringBuilder + " " + plainTextUrl;
            plainTextUrl++;
            System.out.println(ipStringBuilder);
            dnsEntries.add(ipStringBuilder);
        }
    }

    public String giveDnsResponse(String lookingFor) {
        for (String dnsTuple : dnsEntries) {
            if (dnsTuple.contains(lookingFor)) {
                dnsResponse = dnsTuple;
                return dnsResponse;
            }
        }
        return null;
    }

    public String giveSignedDnsResponse(String lookingFor) throws Exception {
        for (String dnsTuple : dnsEntries) {
            if (dnsTuple.contains(lookingFor)) {
                dnsResponse = dnsTuple;
                dnsZoneSigner.initSign(serverCipher.newKeys.getPrivate());
                dnsZoneSigner.update(dnsResponse.getBytes());
                dnsZoneSig = dnsZoneSigner.sign();
                return dnsResponse;
            }
        }
        return null;
    }

    public byte[] getDnsZoneSig() {
        return  dnsZoneSig;
    }

    public Signature getDnsZoneSigner() {
        return dnsZoneSigner;
    }

    public byte[] giveSecDnsResponse(String lookingFor, PublicKey pubKey) {
        for (String dnsTuple : dnsEntries) {
            if (dnsTuple.contains(lookingFor)) {
                dnsResponse = dnsTuple;
                try {
                    return serverCipher.encryptRSA(dnsResponse, pubKey);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void gotCacheHacked(String recordToReplace, String newIP) {
        for (String dnsEntry : dnsEntries) {
            if (dnsEntry.contains(recordToReplace))
                dnsEntries.set(dnsEntries.indexOf(dnsEntry), newIP + " " + recordToReplace);
        }
    }

    public String getServerIP() {
        return this.serverIP;
    }
}
