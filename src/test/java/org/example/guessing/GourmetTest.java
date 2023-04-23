package org.example.guessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GourmetTest {

    private static final GuessingGame game = new GuessingGame(Node.of("massa", "lasanha", "bolo de chocolate"));

    @Test
    public void itShouldTesting32Scenario() {

        /*
          Cenario 1
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é lasanha?
          Sim
          Acertei de novo!
         */

        Node node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("lasanha", node.getName());
        node = game.yes();
        assertNull(node);

        /*
          Cenario 2
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é lasanha?
          Nao
          Qual prato voce pensou?
          Panqueca
          Panqueca gostoso mas lasanha nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("lasanha", node.getName());
        Node nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "Panqueca", "gostoso");
        assertEquals("gostoso", nodeNull.getName());

        /*
          Cenario 3
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Não
          O prato que voce pensou é bolo de chocolate?
          Sim
          Acertei de novo!
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("bolo de chocolate", node.getName());
        node = game.yes();
        assertNull(node);

        /*
          Cenario 4
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Não
          O prato que voce pensou é bolo de chocolate?
          Nao
          Qual prato voce pensou?
          bolo de laranja
          bolo de laranja é mais saudavel mas bolo de chocolate nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("bolo de chocolate", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "bolo de Laranja", "Saudável");
        assertEquals("Saudável", nodeNull.getName());

        /*
          Cenario 5
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é gostoso?
          Sim
          O prato que voce pensou é panqueca?
          Sim
          Acertei de novo!
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals(node.getName(), "Panqueca");
        node = game.yes();
        assertNull(node);


        /*
          Cenario 6
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é gostoso?
          Sim
          O prato que voce pensou é panqueca?
          Nao
          Qual prato voce pensou?
          macarronada
          macarronada é mais desconsertante mas panqueca nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals("Panqueca", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "Macarronada", "Desconsertante");
        assertEquals("Desconsertante", nodeNull.getName());

        /*
          Cenario 7
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é gostoso?
          Nao
          O prato que voce pensou é lasanha?
          Sim
          Acertei de novo!
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals(node.getName(), "lasanha");
        node = game.yes();
        assertNull(node);


        /*
          Cenario 8
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Sim
          O prato que voce pensou é bolo de laranja?
          Sim
          Acertei de novo!
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals(node.getName(), "bolo de Laranja");
        node = game.yes();
        assertNull(node);

        /*
          Cenario 10
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Sim
          O prato que voce pensou é bolo de laranja?
          Nao
          Qual prato voce pensou?
          peixe
          peixe é leve mas bolo de laranja nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals("bolo de Laranja", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "Peixe", "Leve");
        assertEquals("Leve", nodeNull.getName());


        /*
          Cenario 11
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Nao
          O prato que voce pensou é bolo de chocolate?
          Sim
          Acertei de novo!
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals(node.getName(), "bolo de chocolate");
        node = game.yes();
        assertNull(node);

        /*
          Cenario 12
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Nao
          O prato que voce pensou é bolo de chocolate?
          Nao
          Qual prato voce pensou?
          costela assada
          costela assada é gorduroso mas bolo de chocolate nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals("bolo de chocolate", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "costela assada", "gorduroso");
        assertEquals("gorduroso", nodeNull.getName());

        /*
          Cenario 13
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Nao
          O prato que voce pensou é gorduroso?
          Nao
          O prato que voce pensou é Bolo de chocolate?
          nao
          Qual prato voce pensou?
          pudim de leite
          pudim de leite é irresistivel mas bolo de chocolate nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals("gorduroso", node.getName());
        node = game.no();
        assertEquals("bolo de chocolate", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "pudim de leite", "irresistivel");
        assertEquals("irresistivel", nodeNull.getName());

        /*
          Cenario 14
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Nao
          O prato que voce pensou é saudavel?
          Nao
          O prato que voce pensou é gorduroso?
          Nao
          O prato que voce pensou é irresistivel?
          Sim
          Acertei de novo!
         */

//        node = game.ok();
//        assertEquals("massa", node.getName());
//        node = game.no();
//        assertEquals("Saudável", node.getName());
//        node = game.no();
//        assertEquals(node.getName(), "gorduroso");
//        node = game.no();
//        assertEquals(node.getName(), "irresistivel");
//        node = game.yes();
//        assertNull(node);

    }
}
