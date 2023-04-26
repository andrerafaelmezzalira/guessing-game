package org.example.guessing;

import org.example.guessing.exception.ValueUniqueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void itShouldReturnValueUniqueExceptionWhenNameExistInCallAddNodeMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Exception exception = assertThrows(ValueUniqueException.class,
                () -> guessingGame.addNode(
                        Node.builder()
                                .build(),
                        "next",
                        "characteristic"));
        assertTrue(exception.getMessage().contains("next já existe, escolha outro nome"));
    }

    @Test
    public void itShouldReturnValueUniqueExceptionWhenCharacteristicExistInCallAddNodeMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Exception exception = assertThrows(ValueUniqueException.class,
                () -> guessingGame.addNode(
                        Node.builder()
                                .build(),
                        "name",
                        "other"));
        assertTrue(exception.getMessage().contains("other já existe, escolha outro nome"));
    }

    @Test
    public void itShouldReturnValueUniqueExceptionWhenCantFinedAnyNamesInCallAddNodeMethod() {
        Node root = Node.of("root", "next", "other");
        GuessingGame guessingGame = new GuessingGame(root);
        Exception exception = assertThrows(ValueUniqueException.class,
                () -> guessingGame.addNode(
                        Node.builder()
                                .name("name not found")
                                .build(),
                        "name",
                        "characteristic"));
        assertTrue(exception.getMessage().contains("Ops, ocorreu algum problema"));
    }

    @Test
    public void itShouldReturnNodeAddedWhenCallAddNodeMethod() throws ValueUniqueException {
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
