class MyHashSet {
    private boolean[][] primaryArray;
    private int primaryArraySize;

    public MyHashSet() {
        this.primaryArraySize = 1000;
        this.primaryArray = new boolean[primaryArraySize][];
    }

    private int getFirstHash(int key) { //Time: O(1)
        return key % primaryArraySize;
    }

    private int getSecondHash(int key) { //Time: O(1)
        return key / primaryArraySize;
    }

    public void add(int key) { //Time: O(1)
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        if (primaryArray[firstHash] == null) {
            int secondArraySize = firstHash == 0 ? primaryArraySize + 1 : primaryArraySize;
            primaryArray[firstHash] = new boolean[secondArraySize];
        }
        primaryArray[firstHash][secondHash] = true;
    }

    public void remove(int key) { //Time: O(1)
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        if (primaryArray[firstHash] != null) {
            primaryArray[firstHash][secondHash] = false;
        }
    }

    public boolean contains(int key) { //Time: O(1)
        int firstHash = getFirstHash(key);
        int secondHash = getSecondHash(key);
        if (primaryArray[firstHash] != null) {
            return primaryArray[firstHash][secondHash];
        }
        return false;
    }
}