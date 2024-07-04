# Features of the Blockchain:
1. Block Class: Represents each block in the blockchain.
2. Blockchain Class: Manages the chain of blocks.
3. Proof-of-Work: A simple proof-of-work algorithm.
4. Hashing: Using SHA-256 for block hashing.
5. Validation: Ensuring the integrity of the blockchain.
6. Transactions: Basic transaction handling within blocks.
7. Genesis Block: The first block in the blockchain.
8. Mining: The process of adding new blocks to the chain.


# Explanation of Features:
1. Block Class: Contains block attributes and methods to calculate hash and mine the block.
2. Blockchain Class: Manages the list of blocks and provides methods to add blocks and validate the chain.
3. Proof-of-Work: Implemented in the mineBlock method.
4. Hashing: SHA-256 is used to ensure data integrity.
5. Validation: isChainValid method checks the entire chain.
6. Transactions: Simple string-based transactions for demonstration.
7. Genesis Block: The first block is created with a fixed previous hash of "0".
8. Mining: New blocks are mined with a proof-of-work algorithm before being added to the chain.
