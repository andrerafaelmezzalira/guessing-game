package org.example.guessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    @Test
    public void itShouldReturnNodesEqualsWhenCallOkMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node ok = guessingGame.ok();
        assertEquals(root, ok);
    }

    @Test
    public void itShouldReturnNodesEqualsWhenNotCallOkMethodAndCallYesMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node yes = guessingGame.yes();
        assertEquals(root, yes);
    }

    @Test
    public void itShouldReturnNextNodeWhenCallYesMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node ok = guessingGame.ok();
        Node yes = guessingGame.yes();
        assertEquals(ok.getNext(), yes);
    }

    @Test
    public void itShouldReturnNodesEqualsWhenNotCallOkMethodAndCallNoMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node no = guessingGame.no();
        assertEquals(root, no);
    }

    @Test
    public void itShouldReturnOtherNodeWhenCallNoMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node ok = guessingGame.ok();
        Node no = guessingGame.no();
        assertEquals(ok.getOther(), no);
    }

    @Test
    public void itShouldReturnNodeAddedWhenCallAddNodeMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Node nodeAdded = guessingGame.addNode(
                Node.builder()
                        .name("other")
                        .build(),
                "name",
                "characteristic");
        assertEquals(nodeAdded.getName(), "characteristic");

        nodeAdded = guessingGame.addNode(
                Node.builder()
                        .name("next")
                        .build(),
                "other name",
                "other characteristic");
        assertEquals(nodeAdded.getName(), "other characteristic");
    }
}
