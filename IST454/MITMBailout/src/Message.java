
public class Message extends UserPC {
    private String sourceIP;
    private String destinationIP;
    private String message;

    public Message(String destinationIP, String message) {
        this.sourceIP = super.getIpAddress();
        this.destinationIP = destinationIP;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public void setDestinationIP(String destinationIP) {
        this.destinationIP = destinationIP;
    }
}
