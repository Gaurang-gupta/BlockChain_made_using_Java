import java.util.ArrayList;
import java.util.Date;

public class Blockchain {
    public ArrayList<Block> chain;
    public int difficulty;

    public Blockchain() {
        chain = new ArrayList<Block>();
        chain.add(createGenesisBlock());
        difficulty = 4;
    }

    private Block createGenesisBlock() {
        return new Block(0, new Date().getTime(), new ArrayList<String>(), "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;
        newBlock.mineBlock(difficulty);
        chain.add(newBlock);
    }

    public boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for (int i = 1; i < chain.size(); i++) {
            currentBlock = chain.get(i);
            previousBlock = chain.get(i - 1);
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                return false;
            }
            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
            if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
                return false;
            }
        }
        return true;
    }
}
