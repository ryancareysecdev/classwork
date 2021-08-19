import javax.crypto.Cipher;
import java.security.*;

public class CipherAssistant {
    private String plainText;
    private byte[] cipherText;
    private Cipher rsaCipher;
    KeyPairGenerator getKeys;
    KeyPair newKeys;
    SecureRandom aSeed = new SecureRandom();

    public CipherAssistant() {
        try {
            getKeys = KeyPairGenerator.getInstance("RSA");
        } catch (Exception e) {
            System.out.println("That didn't work. CipherAssistant failed to initialize keypair.");
        }
        getKeys.initialize(1024, aSeed);
        this.newKeys = getKeys.generateKeyPair();
        try {
            rsaCipher = Cipher.getInstance("RSA");
        } catch (Exception e) {
            System.out.println("That didn't work. CipherAssistant failed to set rsaCipher.");
        }
    }

    public String decryptRSA(byte[] cypherText) {
        try {
            rsaCipher.init(Cipher.DECRYPT_MODE, this.getPrivKey());
            this.plainText = new String(rsaCipher.doFinal(cypherText));
            return getPlainText();
        } catch (Exception e) {
            return null;
        }
    }

    public byte[] encryptRSA(String plainText, PublicKey pubKey) {
        try {
            rsaCipher.init(Cipher.ENCRYPT_MODE, pubKey);
            this.cipherText = rsaCipher.doFinal(plainText.getBytes());
            return getCipherText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getPlainText() {
        return this.plainText;
    }

    public byte[] getCipherText() {
        return this.cipherText;
    }

    public void setCipherText(byte[] cipherText) {
        this.cipherText = cipherText;
    }

    private PrivateKey getPrivKey() {
        return this.newKeys.getPrivate();
    }

    public PublicKey getPubKey() {
        return this.newKeys.getPublic();
    }
}
