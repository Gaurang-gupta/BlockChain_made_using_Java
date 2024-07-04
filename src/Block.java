import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.security.MessageDigest;

public class Block {
    public int index;
    public long timestamp;
    public List<String> transactions;
    public String previousHash;
    public String hash;
    public int nonce;

    public Block(int index, long timestamp, List<String> transactions, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String dataToHash = "" + this.index + this.timestamp + this.transactions + this.previousHash + this.nonce;
        MessageDigest digest;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public void mineBlock(int difficulty) {
        while (!hash.substring(0, difficulty).equals(new String(new char[difficulty]).replace('\0', '0'))) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
