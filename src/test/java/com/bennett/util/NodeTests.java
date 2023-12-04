package com.bennett.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NodeTests {

    Node testNode1 = new Node();
    Node testNode2 = new Node();
    Node testNode3 = new Node();

    @Test
    public void testAddLink(){
        testNode1.addLink(testNode2);
        testNode2.addLink(testNode3);
        testNode3.addLink(testNode3);

        ArrayList<Node> node1Links = testNode1.getLinks();
        System.out.println(node1Links);

        ArrayList<Node> node2Links = testNode2.getLinks();
        System.out.println(node2Links);

        ArrayList<Node> node3Links = testNode3.getLinks();
        System.out.println(node3Links);

        Assertions.assertFalse(node1Links.contains(testNode1));
        Assertions.assertTrue(node1Links.contains(testNode2));
        Assertions.assertFalse(node1Links.contains(testNode3));

        Assertions.assertTrue(node2Links.contains(testNode1));
        Assertions.assertFalse(node2Links.contains(testNode2));
        Assertions.assertTrue(node2Links.contains(testNode3));

        Assertions.assertFalse(node3Links.contains(testNode1));
        Assertions.assertTrue(node3Links.contains(testNode2));
        Assertions.assertTrue(node3Links.contains(testNode3));
    }

    @Test
    public void removeLinkTest(){
        testNode1.addLink(testNode2);
        testNode2.addLink(testNode3);
        testNode3.addLink(testNode3);

        ArrayList<Node> node1Links = testNode1.getLinks();
        ArrayList<Node> node2Links = testNode2.getLinks();
        ArrayList<Node> node3Links = testNode3.getLinks();

        Assertions.assertEquals(1, node1Links.size());

        testNode1.removeLink(testNode2);

        Assertions.assertFalse(node1Links.contains(testNode1));
        Assertions.assertFalse(node1Links.contains(testNode2));
        Assertions.assertFalse(node1Links.contains(testNode3));
        Assertions.assertEquals(0, node1Links.size());

        Assertions.assertFalse(node2Links.contains(testNode1));
        Assertions.assertFalse(node2Links.contains(testNode2));
        Assertions.assertTrue(node2Links.contains(testNode3));

        Assertions.assertFalse(node3Links.contains(testNode1));
        Assertions.assertTrue(node3Links.contains(testNode2));
        Assertions.assertTrue(node3Links.contains(testNode3));
    }
}
