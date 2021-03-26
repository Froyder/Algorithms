package javaAlgorithms;

import java.util.Random;

class Items {
    private int data;

    public Items (int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }
}

class HashTables {
    private Items [] hashArr;
    private int arrSize;
    private Items nonItem;

    public HashTables (int size) {
        this.arrSize = size;
        hashArr = new Items[arrSize];
        nonItem = new Items(-1);
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

    //двойное хэширование
    public int hashFunc (int key) {
        return (key % arrSize);
    }
    public int hashFuncDouble (int key) {
        return (5 - key % 5);
    }

    public void insert (Items item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
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

    public Items delete (int key) {
        int hashVal = hashFunc(key);
        while (hashArr [hashVal] != null){
            if (hashArr[hashVal].getKey() == key){
                Items temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Items find (int key) {
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



}

public class HashTableDouble {

    public static void hashFunc2 (int k, int ize) {
        System.out.println(k % ize);
    }

    public static void main(String[] args) {
        Items aDataItem;
        int aKey;
        int size = 66;

        HashTables hTable = new HashTables(size);
        Random rand = new Random();

        for (int j = 0; j < 15; j++){
            aKey = rand.nextInt(999);
            aDataItem = new Items(aKey);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Items(999));
        hTable.insert(new Items(203));

        hTable.display();

        hashFunc2(999,66);
        System.out.println(hTable.find(999).getKey());

        hTable.delete(203);

        System.out.println("Повторный прогон");
        hTable.display();

    }

}
