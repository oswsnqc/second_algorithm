package com.yisenjing.second26;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yisen on 3/28/16.
 */
public class ImplementLRUCache<K, V> {

    static class Node<K, V> {
        Node<K, V> prev;
        Node<K, V> next;
        K key;
        V value;
        Node(K key, V value) {
            this.value = value;
            this.key = key;
        }

        void update(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    private final int limit;
    private Node head;
    private Node tail;
    private Map<K, Node> map;

    public ImplementLRUCache(int limit) {
        this.limit = limit;
        this.map = new HashMap<K, Node>();
    }


    public void set(K key, V value) {
        Node<K, V> node = null;

        if (map.containsKey(key)) {
            node.value = value;
            remove(node);
        } else if (map.size() < limit) {
            node = new Node<K, V>(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    public V get(K key) {

        Node<K, V> node = map.get(key);

        if (node == null) {
            return null;
        }

        remove(node);
        append(node);
        return node.value;
    }


    private Node<K, V> remove(Node<K, V> node) {

        map.remove(node.key);

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == head) {
            head = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        }
        node.prev = node.next = null;
        return node;
    }


    private Node<K, V> append(Node<K, V> node) {
        map.put(node.key, node);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node;
    }
}
