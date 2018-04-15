package com.donytar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        serializeTest("temp.t");
    }

    private static void deserializeTest(String path) throws IOException {
        ListRand listRand = new ListRand();
        listRand.deserialize(new FileInputStream(path));

        printListRand(listRand);
    }

    private static void serializeTest(String path) throws IOException {
        ListRand listRand = new ListRand();
        List<ListNode> list = new ArrayList<>();

        for (String str : Arrays.asList("1", "2", "3", "4", "5")){
            list.add(listRand.add(str));
        }

        ListNode node = listRand.head;
        Random random = new Random();
        do {
            node.rand = list.get(random.nextInt(list.size() - 1));
            node = node.next;
        } while (node != null);

        printListRand(listRand);

        listRand.serialize(new FileOutputStream(path));
    }

    private static void printListRand(ListRand list) {
        ListNode node = list.head;
        do {
            System.out.println(node.data + " : " + node.rand.data);
            node = node.next;
        } while (node != null);
    }
}
