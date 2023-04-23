package org.example.guessing.desktop;

import org.example.guessing.GuessingGame;
import org.example.guessing.Node;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ResourceBundle;

import static java.text.MessageFormat.format;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static org.example.guessing.utils.PropertyUtils.readProperties;

public class MainDesktop {

    private static final ResourceBundle resourceBundle = readProperties();

    private static final GuessingGame guessingGame = buildGuessingGame();

    public static void main(String[] args) {
        JFrame frame = new JFrame(resourceBundle.getString("guessing.program"));
        frame.add(getButton());
        frame.add(getLabel());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton getButton() {
        JButton button = new JButton("OK");
        button.setBounds(105, 60, 80, 30);
        button.addActionListener(e -> ask(guessingGame.ok()));
        return button;
    }

    private static JLabel getLabel() {
        JLabel label = new JLabel(resourceBundle.getString("guessing.welcome"));
        label.setBounds(45, 10, 275, 50);
        return label;
    }

    private static boolean isAnsweredYes(String name) {
        return showConfirmDialog(null,
                name + "?",
                resourceBundle.getString("guessing.program"),
                YES_NO_OPTION) == 0;
    }

    private static void success() {
        showMessageDialog(
                null,
                resourceBundle.getString("guessing.success"),
                resourceBundle.getString("guessing.program"),
                INFORMATION_MESSAGE
        );
    }

    private static String askNewNode() {
        return showInputDialog(
                null,
                resourceBundle.getString("guessing.failure"),
                resourceBundle.getString("guessing.program"),
                QUESTION_MESSAGE
        );
    }

    private static String complete(String newName, String oldName) {
        return showInputDialog(
                null,
                format(resourceBundle.getString("guessing.complete"), newName, oldName),
                resourceBundle.getString("guessing.program"),
                QUESTION_MESSAGE
        );
    }

    private static void ask(Node node) {
        boolean answeredYes = isAnsweredYes(node.getName());
        if (answeredYes) {
            yesToAsk();
        } else {
            noToAsk(node);
        }
    }

    private static void yesToAsk() {
        Node yes = guessingGame.yes();
        if (yes == null) {
            success();
        } else {
            ask(yes);
        }
    }

    private static void noToAsk(Node node) {
        Node no = guessingGame.no();
        if (no == null) {
            addNewNode(node);
        } else {
            ask(no);
        }
    }

    private static void addNewNode(Node node) {
        String name = askNewNode();
        String characteristic = complete(name, node.getName());
        guessingGame.addNode(node, name, characteristic);
    }

    private static GuessingGame buildGuessingGame() {
        String root = resourceBundle.getString("guessing.root");
        String next = resourceBundle.getString("guessing.next");
        String other = resourceBundle.getString("guessing.other");
        return new GuessingGame(Node.of(root, next, other));
    }
}