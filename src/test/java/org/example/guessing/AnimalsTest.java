package org.example.guessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AnimalsTest {

    private static final GuessingGame guessingGame = new GuessingGame(Node.of("vive na água", "tubarão", "macaco"));
    private Node node;

    private Node previousNode;

    @Test
    public void itShouldGuessNodeLevelOne() {

        /*
         Cenário 1
         pense em um animal
         vive na água?
         sim
         tubarão
         sim
         Ganhei! Sou muito bom!
         */

        ok("pense em um animal");
        ask("vive na água?");
        yes();
        ask("tubarão?");
        yes();
        finish("Ganhei! Sou muito bom!");

        /*
         Cenário 2
         pense em um animal
         vive na água?
         nao
         Macaco?
         sim
         Ganhei! Sou muito bom!
         */

        ok("pense em um animal");
        ask("vive na água?");
        no();
        ask("macaco?");
        yes();
        finish("Ganhei! Sou muito bom!");

        /*
         Cenário 3
         pense em um animal
         vive na água?
         nao
         macaco
         nao
         Desisto, qual foi o animal que voce pensou?
         leao
         Complete. leao ruje mas macaco nao
         */

        ok("pense em um animal");
        ask("vive na água?");
        no();
        ask("macaco?");
        no("Desisto, qual foi o animal que voce pensou?");
        complete("Complete, {0} __________ mas {1} não", "leao", "ruje");

        /*
         Cenário 4
         pense em um animal
         vive na água?
         nao
         ruje?
         nao
         macaco
         sim
         Ganhei! Sou muito bom!
         */

        ok("pense em um animal");
        ask("vive na água?");
        no();
        ask("ruje?");
        no();
        ask("macaco?");
        yes();
        finish("Ganhei! Sou muito bom!");

        /*
         Cenário 5
         pense em um animal
         vive na água?
         sim
         tubarão?
         nao
         Desisto, qual foi o animal que voce pensou?
         leao
         Complete. peixe inofensivo mas tubarão nao
         */

        ok("pense em um animal");
        ask("vive na água?");
        yes();
        ask("tubarão?");
        no("Desisto, qual foi o animal que voce pensou?");
        complete("Complete, {0} __________ mas {1} não", "peixe", "inofensivo");

    }

    private void complete(@SuppressWarnings("SameParameterValue") String ignoredMessage, String name, String characteristic) {
        assertNull(node);
        node = guessingGame.addNode(previousNode, name, characteristic);
        assertEquals(characteristic, node.getName());
    }

    private void no(@SuppressWarnings("SameParameterValue") String ignoredMessage) {
        no();
    }

    private void no() {
        previousNode = node;
        node = guessingGame.no();
    }


    private void finish(@SuppressWarnings("SameParameterValue") String ignoredMessage) {
        assertNull(node);
    }

    private void yes() {
        node = guessingGame.yes();
    }

    private void ask(String message) {
        assertEquals(message, node.getName() + "?");
    }

    private void ok(@SuppressWarnings("SameParameterValue") String ignoredMessage) {
        node = guessingGame.ok();
    }
}
