package org.example.guessing;

import com.google.gson.Gson;

import java.util.logging.Logger;

public class GuessingGame {

    private final static Logger logger = Logger.getLogger(GuessingGame.class.getName());

    private static final Gson gson = new Gson();

    private final Node root;

    private Node current;

    public GuessingGame(Node node) {
        root = node;
    }

    public Node ok() {
        return current = root;
    }

    public Node yes() {
        return current = current.getNext();
    }

    public Node no() {
        return current = current.getOther();
    }

    public Node addNode(Node no, String name, String characteristic) {
        return root.findNodeByName(no.getName())
                .map(baseNode -> updateNode(baseNode, buildCharacteristicNode(no, name, characteristic)))
                .orElse(null);
    }

    private Node updateNode(Node baseNode, Node characteristicNode) {
        baseNode.setName(characteristicNode.getName());
        baseNode.setNext(characteristicNode.getNext());
        baseNode.setOther(characteristicNode.getOther());
        logger.info("Update Node " + gson.toJson(root));
        return baseNode;
    }

    private Node buildCharacteristicNode(Node node, String name, String characteristic) {
        return Node.builder().name(characteristic).next(buildNextNode(name)).other(buildOtherNode(node)).build();
    }

    private Node buildOtherNode(Node node) {
        return Node.builder().next(node.getNext()).name(node.getName()).build();
    }

    private Node buildNextNode(String name) {
        return Node.builder().name(name).build();
    }

 }
