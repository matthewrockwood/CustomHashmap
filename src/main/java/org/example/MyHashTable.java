package org.example;
/**This is a Class called MyHashTable, It is used to create a hashtable using arrays and linked lists*/
public class MyHashTable {
    private MyList[] buckets;
    private double totalItems;



    /**This method returns the bucket or the "Key" to be put in the Hashmap*/
    private int Hash(House house){
        int key = Math.abs(house.hashCode()); //transform method
        int bucketNum = key % buckets.length;
        return bucketNum;
    }
    /**Default Constructor for the Hashtable*/
    public MyHashTable(){
        buckets = new MyList[4];
        totalItems = 0;

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyList();
        }
    }
    /**Deep copy Constructor */
    MyHashTable(MyHashTable other){
        buckets = new MyList[other.buckets.length];
        for (int i = 0; i < buckets.length; i++) {
        //might have to check for null if this is not working later
            buckets[i] = other.buckets[i].deepCopy();
        }
    }
    /**Deep copy method using the deepcopy constructor*/
    public MyHashTable deepCopy() {
        return new MyHashTable(this);
    }
    /**Method that adds a item to the table. Also checks the load factor*/
    public void add(House house){
        int bucketNum = Hash(house);
        totalItems++;
        if(totalItems/buckets.length>0.75){
            resize();
            bucketNum = Hash(house);
        }
        buckets[bucketNum].add(house);
    }

    /**Resize method that also rehashes*/
    private void resize() {
        MyList[] newBuckets = new MyList[buckets.length*2];

        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new MyList();
        }
        for (int i = 0; i < buckets.length; i++) {
            MyList bucket = buckets[i];
            for (int j = 0; j < buckets[i].length; j++) {
                House house = bucket.get(j);
                int newbucketnum = Math.abs(house.hashCode()% newBuckets.length);
                newBuckets[newbucketnum].add(house);
            }

        }
        buckets = newBuckets;



    }
    /**Method that goes through the list and tries to find an item. If not found returns null*/
    public House find(String owner){
        for (int i = 0; i < buckets.length; i++) {
            MyList list = buckets[i];
            for (int j = 0; j < buckets[i].length; j++) {
                House house = buckets[i].get(j);
                if(house.getOwner().equals(owner)) return house;

            }
        }
        return null;
    }
    /**Method used to show the hashmap*/
    public void show(){
        for (int i = 0; i < buckets.length; i++) {
            MyList list = buckets[i];
            for (int j = 0; j < buckets[i].length; j++) {
                House house = buckets[i].get(j);
                System.out.println("House Owner: "+ house.getOwner()+ " House Value: "+ house.getValue());
            }

        }

    }

}
