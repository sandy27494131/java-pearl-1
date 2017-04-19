package com.robert.dsal.hash;


public class HashTableImpl implements Hashtable {
    public static final int INIT_SIZE = 1024;

    private HashNode[] data;

    public HashTableImpl() {
        this.data = new HashNode[INIT_SIZE];
    }

    public void put(String key, String value) {
        int hash = key.hashCode();
        if (hash < 0)
            hash = -hash;
        HashNode tmp = new HashNode();
        tmp.key = key;
        tmp.value = value;
        if (this.data[hash % INIT_SIZE] == null) {
            this.data[hash % INIT_SIZE] = tmp;
        } else {
            tmp.next = this.data[hash % INIT_SIZE];
            this.data[hash % INIT_SIZE] = tmp;
        }
    }

    public String get(String key) {
        int hash = key.hashCode();
        if (hash < 0)
            hash = -hash;
        HashNode tmp = this.data[hash % INIT_SIZE];
        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return tmp.value;
    }

    public void print() {
        System.out.print("HashTable: ");
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != null) {
                System.out.print("@" + i + ":");
                HashNode tmp = this.data[i];
                while (tmp != null) {
                    if (tmp.next != null)
                        System.out.print(tmp.key + "&" + tmp.value + ",");
                    else
                        System.out.print(tmp.key + "&" + tmp.value);
                    tmp = tmp.next;
                }
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
