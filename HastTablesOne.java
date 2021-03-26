package javaAlgorithms;

import java.util.Random;

class Item {
    private int data;

    public Item (int data) {
       this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTable {
    private Item [] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable (int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display () {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i].getKey());
            } else {
                System.out.println("***");
            }
        }
    }

    public int hashFunc (int key) {
        return (key % arrSize);
    }

    public void insert (Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete (int key) {
        int hashVal = hashFunc(key);
        while (hashArr [hashVal] != null){
            if (hashArr[hashVal].getKey() == key){
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find (int key) {
        int hashVal = hashFunc(key);
        while (hashArr [hashVal] != null) {
            if (hashArr[hashVal].getKey() == key){
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    //увеличение хэш-таблицы
    private int getPrime (int min) {
        for (int i = min+1; true; i++){
            if (isPrime(i));
                return i;
        }
    }
    private boolean isPrime (int n){
        for (int j = 2; (j*j <= n); j++)
            if (n % j == 0)
                return false;
        return true;
    }
}


public class HastTablesOne {
    public static void hashFunc2 (int k, int ize) {
        System.out.println(k % ize);
    }

    public static void main(String[] args) {
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hTable = new HashTable(size);
        Random rand = new Random();

        for (int j = 0; j < 15; j++){
            aKey = rand.nextInt(1000);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Item(999));
        hTable.insert(new Item(203));

        hTable.display();

        hashFunc2(999,66);
        System.out.println(hTable.find(999).getKey());

        hTable.delete(203);

        hTable.display();

    }

}
