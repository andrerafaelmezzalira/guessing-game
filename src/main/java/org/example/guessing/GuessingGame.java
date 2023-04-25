package org.example.guessing;

import org.example.guessing.exception.ValueUniqueException;

import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;
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

    public Node yes(){
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

    public Node addNode(Node no, String name, String characteristic) throws ValueUniqueException {
        validateUniqueName(name, characteristic);
        return root.findNodeByName(no.getName())
                .map(baseNode -> updateNode(baseNode, buildCharacteristicNode(no, name, characteristic)))
                .orElseThrow(() -> new ValueUniqueException("Ops, ocorreu algum problema"));
    }

    private void validateUniqueName(String name, String characteristic) throws ValueUniqueException {
        throwValidateUniqueException(name);
        throwValidateUniqueException(characteristic);
    }

    private void throwValidateUniqueException(String name) throws ValueUniqueException {
        String message = " já existe, escolha outro nome";
        if (root.findNodeByName(name).isPresent()) {
            throw new ValueUniqueException(name.concat(message));
        }
    }
    private Node updateNode(Node baseNode, Node characteristicNode) {
        baseNode.setName(characteristicNode.getName());
        baseNode.setNext(characteristicNode.getNext());
        baseNode.setOther(characteristicNode.getOther());
        logger.info("Update Node " + toJson(root));
        return baseNode;
    }

    private Node buildCharacteristicNode(Node node, String name, String characteristic) {
        return Node.builder()
                .name(characteristic)
                .next(buildNextNode(name))
                .other(buildOtherNode(node))
                .build();
    }

    private Node buildOtherNode(Node node) {
        return Node.builder()
                .next(node.getNext())
                .name(node.getName())
                .build();
    }

    private Node buildNextNode(String name) {
        return Node.builder()
                .name(name)
                .build();
    }
 }
