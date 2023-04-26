package org.example.guessing;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NodeTest {

    @Test
    public void itShouldReturnNodeWhenFindByName() {
        Node root = Node.of("root", "next", "other");
        Optional<Node> optionalNode = root.findNodeByName("root");
        assertTrue(optionalNode.isPresent());
        assertEquals(root, optionalNode.get());
    }

    @Test
    public void itShouldReturnNodeWhenFindByNextName() {
        Node root = Node.of("root", "next", "other");
        Optional<Node> optionalNode = root.findNodeByName("next");
        assertTrue(optionalNode.isPresent());
        assertEquals(root.getNext(), optionalNode.get());
    }

    @Test
    public void itShouldReturnNodeWhenFindByOtherName() {
        Node root = Node.of("root", "next", "other");
        Optional<Node> optionalNode = root.findNodeByName("other");
        assertTrue(optionalNode.isPresent());
        assertEquals(root.getOther(), optionalNode.get());
    }

    @Test
    public void itShouldReturnEmptyWhenFindByName() {
        Node root = Node.of("root", "next", "other");
        Optional<Node> optionalNode = root.findNodeByName("name");
        assertFalse(optionalNode.isPresent());
        assertEquals(empty(), optionalNode);
    }
}
