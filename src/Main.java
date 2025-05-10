import DataStructures.MyHashTable;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            String name = "Student" + rand.nextInt(10000);
            int id = rand.nextInt(10000);
            MyTestingClass key = new MyTestingClass(name, id);
            Student value = new Student(name, id);

            table.put(key, value);
        }

        table.printBucketSizes();

        // result is
//        Bucket 0 size: 918
//        Bucket 1 size: 912
//        Bucket 2 size: 906
//        Bucket 3 size: 946
//        Bucket 4 size: 942
//        Bucket 5 size: 893
//        Bucket 6 size: 896
//        Bucket 7 size: 907
//        Bucket 8 size: 895
//        Bucket 9 size: 876
//        Bucket 10 size: 909
        // pretty good imo

    }
}