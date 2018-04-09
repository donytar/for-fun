package com.donytar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ListRand listRand = new ListRand();
//        List<String> stringList = new ArrayList<String>(Arrays.asList("1", "2", "3"));
        for (String str : Arrays.asList("1", "2", "3", "4", "5")){
            listRand.add(str);
        }

        ListNode node = listRand.head;
        do {
            System.out.println(node.data);
            node = node.next;
        } while (node != null);
    }
}
