package org.example.guessing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GourmetTest {

    private static final GuessingGame guessingGame = new GuessingGame(Node.of("massa", "lasanha", "bolo de chocolate"));

    @Test
    public void itShouldTesting28Scenario() {

        /*
          Cenario 1
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é lasanha?
          Sim
          Acertei de novo!
         */

        Node node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("lasanha", node.getName());
        node = guessingGame.yes();
        assertNull(node);

        /*
          Cenario 2
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Sim
          O prato que voce pensou é lasanha?
          Nao
          Qual prato voce pensou?
          panqueca
          panqueca gostoso mas lasanha nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("lasanha", node.getName());
        Node otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "panqueca", "gostoso");
        assertEquals("gostoso", otherNode.getName());

        /*
          Cenario 3
          Pense em um prato que gosta
          O prato que voce pensou é massa?
          Não
          O prato que voce pensou é bolo de chocolate?
          Sim
          Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("bolo de chocolate", node.getName());
        node = guessingGame.yes();
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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("bolo de chocolate", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "bolo de laranja", "Saudável");
        assertEquals("Saudável", otherNode.getName());

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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals(node.getName(), "panqueca");
        node = guessingGame.yes();
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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals("panqueca", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "macarronada", "desconsertante");
        assertEquals("desconsertante", otherNode.getName());

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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals(node.getName(), "lasanha");
        node = guessingGame.yes();
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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals(node.getName(), "bolo de laranja");
        node = guessingGame.yes();
        assertNull(node);

        /*
         Cenario 9
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Nao
         O prato que voce pensou é Lasanha?
         Nao
         Qual prato voce pensou?
         escondidinho de carne
         escondidinho de carne é mais rapido mas panqueca nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals("lasanha", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "escondidinho de carne", "rapido");
        assertEquals("rapido", otherNode.getName());

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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals("bolo de laranja", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "peixe", "leve");
        assertEquals("leve", otherNode.getName());


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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals(node.getName(), "bolo de chocolate");
        node = guessingGame.yes();
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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals("bolo de chocolate", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "costela assada", "gorduroso");
        assertEquals("gorduroso", otherNode.getName());

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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals("gorduroso", node.getName());
        node = guessingGame.no();
        assertEquals("bolo de chocolate", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "pudim de leite", "irresistivel");
        assertEquals("irresistivel", otherNode.getName());

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

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals(node.getName(), "gorduroso");
        node = guessingGame.no();
        assertEquals(node.getName(), "irresistivel");
        node = guessingGame.yes();
        assertEquals(node.getName(), "pudim de leite");
        node = guessingGame.yes();
        assertNull(node);


        /*
         Cenario 15
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Nao
         O prato que voce pensou é gorduroso?
         Sim
         O prato que voce pensou é costela assada?
         Nao
         Qual prato voce pensou?
         picanha
         picanha é mais crua mas costela assada nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals("gorduroso", node.getName());
        node = guessingGame.yes();
        assertEquals("costela assada", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "picanha", "mais crua");
        assertEquals("mais crua", otherNode.getName());

        /*
         Cenario 16
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Nao
         O prato que voce pensou é gorduroso?
         Sim
         O prato que voce pensou é mais crua?
         Sim
         O prato que voce pensou é picanha?
         Sim
         Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.no();
        assertEquals(node.getName(), "gorduroso");
        node = guessingGame.yes();
        assertEquals(node.getName(), "mais crua");
        node = guessingGame.yes();
        assertEquals(node.getName(), "picanha");
        node = guessingGame.yes();
        assertNull(node);


        /*
         Cenario 17
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Sim
         O prato que voce pensou é leve?
         Nao
         O prato que voce pensou é bolo de laranja?
         Nao
         Qual prato voce pensou?
         tainha
         tainha é fora de serie mas bolo de laranja nao
         */


        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals("leve", node.getName());
        node = guessingGame.no();
        assertEquals("bolo de laranja", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "tainha", "fora de serie");
        assertEquals("fora de serie", otherNode.getName());

        /*
         Cenario 18
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Sim
         O prato que voce pensou é leve?
         Nao
         O prato que voce pensou é fora de serie?
         Sim
         O prato que voce pensou é tainha?
         Nao
         Qual prato voce pensou?
         salmao
         salmao é mais saboroso mas tainha nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals("leve", node.getName());
        node = guessingGame.no();
        assertEquals("fora de serie", node.getName());
        node = guessingGame.yes();
        assertEquals("tainha", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "salmao", "saboroso");
        assertEquals("saboroso", otherNode.getName());

        /*
         Cenario 19
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Sim
         O prato que voce pensou é leve?
         Sim
         O prato que voce pensou é peixe?
         Nao
         Qual prato voce pensou?
         frango
         frango é mais cheiroso mas peixe nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals("leve", node.getName());
        node = guessingGame.yes();
        assertEquals("peixe", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "frango", "cheiroso");
        assertEquals("cheiroso", otherNode.getName());

        /*
         Cenario 20
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Nao
         O prato que voce pensou é saudavel?
         Sim
         O prato que voce pensou é leve?
         Sim
         O prato que voce pensou é cheiroso?
         Sim
         O prato que voce pensou é frango?
         Sim
         Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.no();
        assertEquals("Saudável", node.getName());
        node = guessingGame.yes();
        assertEquals(node.getName(), "leve");
        node = guessingGame.yes();
        assertEquals(node.getName(), "cheiroso");
        node = guessingGame.yes();
        assertEquals(node.getName(), "frango");
        node = guessingGame.yes();
        assertNull(node);

        /*
         Cenario 21
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Nao
         O prato que voce pensou é rapido?
         Nao
         O prato que voce pensou é Lasanha?
         nao
         Qual prato voce pensou?
         empadao
         empadao é mais nutritivo mas lasanha nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals("rapido", node.getName());
        node = guessingGame.no();
        assertEquals("lasanha", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "empadao", "nutritivo");
        assertEquals("nutritivo", otherNode.getName());


        /*
         Cenario 22
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Sim
         O prato que voce pensou é desconsertante?
         Sim
         O prato que voce pensou é macarronada?
         Sim
         Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals(node.getName(), "desconsertante");
        node = guessingGame.yes();
        assertEquals(node.getName(), "macarronada");
        node = guessingGame.yes();
        assertNull(node);

        /*
         Cenario 23
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Nao
         O prato que voce pensou é rapido?
         Nao
         O prato que voce pensou é nutritivo?
         Sim
         O prato que voce pensou é empadao?
         Nao
         Qual prato voce pensou?
         dobradinha
         dobradinha é mais nojento mas empadao nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals("rapido", node.getName());
        node = guessingGame.no();
        assertEquals("nutritivo", node.getName());
        node = guessingGame.yes();
        assertEquals("empadao", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "dobradinha", "nojento");
        assertEquals("nojento", otherNode.getName());

        /*
         Cenario 24
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Sim
         O prato que voce pensou é desconsertante?
         Sim
         O prato que voce pensou é macarronada?
         Nao
         Qual prato voce pensou?
         pastel
         pastel é mais banhento mas macarrao nao
         */


        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals("desconsertante", node.getName());
        node = guessingGame.yes();
        assertEquals("macarronada", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "pastel", "banhento");
        assertEquals("banhento", otherNode.getName());


        /*
         Cenario 25
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Nao
         O prato que voce pensou é rapido?
         Sim
         O prato que voce pensou é escondidinho de carne?
         Nao
         Qual prato voce pensou?
         feijoada
         feijoada é mais pesado mas escondidinho de carne nao
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals("rapido", node.getName());
        node = guessingGame.yes();
        assertEquals("escondidinho de carne", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "feijoada", "pesado");
        assertEquals("pesado", otherNode.getName());


        /*
         Cenario 26
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Sim
         O prato que voce pensou é desconsertante?
         Nao
         O prato que voce pensou é panqueca?
         Sim
         Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals(node.getName(), "desconsertante");
        node = guessingGame.no();
        assertEquals(node.getName(), "panqueca");
        node = guessingGame.yes();
        assertNull(node);

        /*
         Cenario 27
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         nao
         O prato que voce pensou é rapido?
         Sim
         O prato que voce pensou é pesado?
         Sim
         O prato que voce pensou é feijoada?
         Sim
         Acertei de novo!
         */

        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.no();
        assertEquals(node.getName(), "rapido");
        node = guessingGame.yes();
        assertEquals(node.getName(), "pesado");
        node = guessingGame.yes();
        assertEquals(node.getName(), "feijoada");
        node = guessingGame.yes();
        assertNull(node);

        /*
         Cenario 28
         Pense em um prato que gosta
         O prato que voce pensou é massa?
         Sim
         O prato que voce pensou é gostoso?
         Sim
         O prato que voce pensou é desconsertante?
         nao
         O prato que voce pensou é panqueca?
         nao
         Qual prato voce pensou?
         cueca virada
         cueca virada é mais doce mas panqueca nao
         */


        node = guessingGame.ok();
        assertEquals("massa", node.getName());
        node = guessingGame.yes();
        assertEquals("gostoso", node.getName());
        node = guessingGame.yes();
        assertEquals("desconsertante", node.getName());
        node = guessingGame.no();
        assertEquals("panqueca", node.getName());
        otherNode = guessingGame.no();
        assertNull(otherNode);
        otherNode = guessingGame.addNode(node, "cueca virada", "doce");
        assertEquals("doce", otherNode.getName());

    }
}
