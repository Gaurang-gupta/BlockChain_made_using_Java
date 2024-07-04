import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();

        System.out.println("Mining block 1...");
        ArrayList<String> transactions1 = new ArrayList<>();
        transactions1.add("Alice pays Bob 10 BTC");
        Block block1 = new Block(1, new Date().getTime(), transactions1, blockchain.getLatestBlock().hash);
        blockchain.addBlock(block1);

        System.out.println("Mining block 2...");
        ArrayList<String> transactions2 = new ArrayList<>();
        transactions2.add("Bob pays Charlie 5 BTC");
        Block block2 = new Block(2, new Date().getTime(), transactions2, blockchain.getLatestBlock().hash);
        blockchain.addBlock(block2);

        System.out.println("Blockchain is valid: " + blockchain.isChainValid());

        System.out.println("Blockchain: ");
        for (Block block : blockchain.chain) {
            System.out.println("Index: " + block.index);
            System.out.println("Timestamp: " + block.timestamp);
            System.out.println("Transactions: " + block.transactions);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("Hash: " + block.hash);
            System.out.println();
        }
    }
}
