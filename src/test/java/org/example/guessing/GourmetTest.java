package org.example.guessing;

import org.example.guessing.exception.ValueUniqueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GourmetTest {

    private static final GuessingGame game = new GuessingGame(Node.of("massa", "lasanha", "bolo de chocolate"));

    @Test
    public void itShouldTesting28Scenario() throws ValueUniqueException {

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
          panqueca
          panqueca gostoso mas lasanha nao
         */

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("lasanha", node.getName());
        Node nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "panqueca", "gostoso");
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
        nodeNull = game.addNode(node, "bolo de laranja", "Saudável");
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
        assertEquals(node.getName(), "panqueca");
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
        assertEquals("panqueca", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "macarronada", "desconsertante");
        assertEquals("desconsertante", nodeNull.getName());

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
        assertEquals(node.getName(), "bolo de laranja");
        node = game.yes();
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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals("lasanha", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "escondidinho de carne", "rapido");
        assertEquals("rapido", nodeNull.getName());

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
        assertEquals("bolo de laranja", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "peixe", "leve");
        assertEquals("leve", nodeNull.getName());


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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals(node.getName(), "gorduroso");
        node = game.no();
        assertEquals(node.getName(), "irresistivel");
        node = game.yes();
        assertEquals(node.getName(), "pudim de leite");
        node = game.yes();
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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals("gorduroso", node.getName());
        node = game.yes();
        assertEquals("costela assada", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "picanha", "mais crua");
        assertEquals("mais crua", nodeNull.getName());

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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.no();
        assertEquals(node.getName(), "gorduroso");
        node = game.yes();
        assertEquals(node.getName(), "mais crua");
        node = game.yes();
        assertEquals(node.getName(), "picanha");
        node = game.yes();
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


        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals("leve", node.getName());
        node = game.no();
        assertEquals("bolo de laranja", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "tainha", "fora de serie");
        assertEquals("fora de serie", nodeNull.getName());

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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals("leve", node.getName());
        node = game.no();
        assertEquals("fora de serie", node.getName());
        node = game.yes();
        assertEquals("tainha", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "salmao", "saboroso");
        assertEquals("saboroso", nodeNull.getName());

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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals("leve", node.getName());
        node = game.yes();
        assertEquals("peixe", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "frango", "cheiroso");
        assertEquals("cheiroso", nodeNull.getName());

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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.no();
        assertEquals("Saudável", node.getName());
        node = game.yes();
        assertEquals(node.getName(), "leve");
        node = game.yes();
        assertEquals(node.getName(), "cheiroso");
        node = game.yes();
        assertEquals(node.getName(), "frango");
        node = game.yes();
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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals("rapido", node.getName());
        node = game.no();
        assertEquals("lasanha", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "empadao", "nutritivo");
        assertEquals("nutritivo", nodeNull.getName());


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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals(node.getName(), "desconsertante");
        node = game.yes();
        assertEquals(node.getName(), "macarronada");
        node = game.yes();
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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals("rapido", node.getName());
        node = game.no();
        assertEquals("nutritivo", node.getName());
        node = game.yes();
        assertEquals("empadao", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "dobradinha", "nojento");
        assertEquals("nojento", nodeNull.getName());

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


        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals("desconsertante", node.getName());
        node = game.yes();
        assertEquals("macarronada", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "pastel", "banhento");
        assertEquals("banhento", nodeNull.getName());


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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals("rapido", node.getName());
        node = game.yes();
        assertEquals("escondidinho de carne", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "feijoada", "pesado");
        assertEquals("pesado", nodeNull.getName());


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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals(node.getName(), "desconsertante");
        node = game.no();
        assertEquals(node.getName(), "panqueca");
        node = game.yes();
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

        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.no();
        assertEquals(node.getName(), "rapido");
        node = game.yes();
        assertEquals(node.getName(), "pesado");
        node = game.yes();
        assertEquals(node.getName(), "feijoada");
        node = game.yes();
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


        node = game.ok();
        assertEquals("massa", node.getName());
        node = game.yes();
        assertEquals("gostoso", node.getName());
        node = game.yes();
        assertEquals("desconsertante", node.getName());
        node = game.no();
        assertEquals("panqueca", node.getName());
        nodeNull = game.no();
        assertNull(nodeNull);
        nodeNull = game.addNode(node, "cueca virada", "doce");
        assertEquals("doce", nodeNull.getName());

    }
}
