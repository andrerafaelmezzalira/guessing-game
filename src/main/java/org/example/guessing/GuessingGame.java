package org.example.guessing;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;
import static org.example.guessing.Node.buildNode;
import static org.example.guessing.utils.GsonUtils.toJson;

public class GuessingGame {

    private final static Logger logger = getLogger(GuessingGame.class.getName());

    private final Node root;

    private Node current;

    public GuessingGame(Node node) {
        root = node;
    }

    public Node ok() {
        return current = root;
    }

    public Node yes() {
        if (current == null) {
            return ok();
        }
        return current = current.getNext();
    }

    public Node no() {
        if (current == null) {
            return ok();
        }
        return current = current.getOther();
    }

    public Node addNode(Node otherNode, String name, String characteristic) {
        otherNode.setNext(buildNode(name));
        otherNode.setOther(buildNode(otherNode.getName()));
        otherNode.setName(characteristic);
        logger.info("Update Node " + toJson(root));
        return otherNode;
    }
}
