package com.donytar;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ListRand {
    public ListNode head;
    public ListNode tail;
    public int count;

//    public ListRand() {
//
//    }

    public void add(String str) {
        ListNode node = new ListNode(str);
        if (head == null) {
            head = node;
        } else {
            node.prev = tail;
            tail.next = node;
        }
        tail = node;
    }

    public void Serialize(FileOutputStream s) {

    }
    public void Deserialize(FileInputStream s) {

    }
}
