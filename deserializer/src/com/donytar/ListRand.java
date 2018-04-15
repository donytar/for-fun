package com.donytar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ListRand {
    public ListNode head;
    public ListNode tail;
    public int count; //I hope it is size or length

//    method for test
    ListNode add(String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
        count += 1;

        return node;
    }

    public void serialize(FileOutputStream s) throws IOException {
        String delimiter = ":";
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(s));
        ListNode node = head;
        do {
            bufferedWriter.write(node.data + delimiter + node.rand.data);
            bufferedWriter.newLine();
            node = node.next;
        } while (node != null);
        bufferedWriter.close();
    }

    public void deserialize(FileInputStream s) throws IOException {
        String delimiter = ":";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s));
        Map<String, ListNode> nodeDataMap = new TreeMap<>();
        List<String> codeList = new ArrayList<>();
        String nodeString;
        while((nodeString = bufferedReader.readLine()) != null) {
            String[] t1 = nodeString.split(delimiter);
            codeList.add(t1[1]);

            ListNode node = new ListNode();
            node.data = t1[0];
            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
            count += 1;

            nodeDataMap.put(t1[0], node);
        }

        ListNode node = head;
        int counter = 0;
        do {
            node.rand = nodeDataMap.get(codeList.get(counter++));
            node = node.next;
        } while (node != null);
    }
}
