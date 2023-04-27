package org.example.guessing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

import static java.util.Optional.empty;

@Builder
@Getter
@Setter
public class Node {

    private String name;

    private Node next;

    private Node other;

    public Optional<Node> findNodeByName(String name) {
        if (name.equals(this.name)) {
            return Optional.of(this);
        } else if (next != null) {
            Optional<Node> nextResult = next.findNodeByName(name);
            if (nextResult.isPresent()) {
                return nextResult;
            }
        }
        if (other != null) {
            return other.findNodeByName(name);
        }
        return empty();
    }

    public static Node of(String root, String next, String other) {
        return Node.builder()
                .name(root)
                .next(buildNode(next))
                .other(buildNode(other))
                .build();
    }
    public static Node buildNode(String name) {
        return Node.builder()
                .name(name)
                .build();
    }
}
