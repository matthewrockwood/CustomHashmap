package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        MyHashTable hashMap = new MyHashTable();

        String filepath = "C:\\Users\\matth\\OneDrive\\Desktop\\HashTable\\src\\main\\java\\org\\example\\houses.txt";
        File file = new File(filepath);
        Scanner scnr = new Scanner(file);

        while(scnr.hasNext()){
            String owner= scnr.nextLine();
            int value = Integer.parseInt(scnr.nextLine());
            House house = new House(owner,value);
            hashMap.add(house);
        }
        hashMap.show();
        MyHashTable deepCopyConstructor = new MyHashTable(hashMap);
        deepCopyConstructor.show();
        MyHashTable deepCopyMethod = new MyHashTable(hashMap.deepCopy());
        deepCopyMethod.show();
        System.out.println(hashMap.find("Steven Price"));
        System.out.println(hashMap.find("Steven Pr2ice"));
    }
}