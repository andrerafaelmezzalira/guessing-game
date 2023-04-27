package org.example.guessing;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Node {

    private String name;

    private Node next;

    private Node other;

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
