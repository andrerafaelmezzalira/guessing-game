package org.example.guessing.desktop;

import org.example.guessing.Node;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import static java.text.MessageFormat.format;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static org.example.guessing.utils.GuessingGameUtils.getGuessingGame;
import static org.example.guessing.utils.GuessingGameUtils.getResourceBundle;

public class MainDesktop {

    public static void main(String[] args) {
        JFrame frame = new JFrame(getResourceBundle().getString("guessing.program"));
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
        button.addActionListener(e -> ask(getGuessingGame().ok()));
        return button;
    }

    private static JLabel getLabel() {
        JLabel label = new JLabel(getResourceBundle().getString("guessing.welcome"));
        label.setBounds(45, 10, 275, 50);
        return label;
    }

    private static boolean isAnsweredYes(String name) {
        return showConfirmDialog(null,
                name + "?",
                getResourceBundle().getString("guessing.program"),
                YES_NO_OPTION) == 0;
    }

    private static void success() {
        showMessageDialog(
                null,
                getResourceBundle().getString("guessing.success"),
                getResourceBundle().getString("guessing.program"),
                INFORMATION_MESSAGE
        );
    }

    private static String askNewNode() {
        return showInputDialog(
                null,
                getResourceBundle().getString("guessing.failure"),
                getResourceBundle().getString("guessing.program"),
                QUESTION_MESSAGE
        );
    }

    private static String complete(String newName, String oldName) {
        return showInputDialog(
                null,
                format(getResourceBundle().getString("guessing.complete"), newName, oldName),
                getResourceBundle().getString("guessing.program"),
                QUESTION_MESSAGE
        );
    }

    private static void _showMessageDialog() {
        showMessageDialog(null, "Você deve preencher o campo.", "Erro", INFORMATION_MESSAGE);
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
        Node yes = getGuessingGame().yes();
        if (yes == null) {
            success();
        } else {
            ask(yes);
        }
    }

    private static void noToAsk(Node node) {
        Node no = getGuessingGame().no();
        if (no == null) {
            addNewNode(node);
        } else {
            ask(no);
        }
    }

    private static void addNewNode(Node node) {
        String name = askNewNode();
        if (name == null || name.isEmpty()) {
            _showMessageDialog();
            addNewNode(node);
        } else {
            askToComplete(node, name);
        }
    }

    private static void askToComplete(Node node, String name) {
        String characteristic = complete(name, node.getName());
        if (characteristic == null || characteristic.isEmpty()) {
            _showMessageDialog();
            askToComplete(node, name);
        } else {
            getGuessingGame().addNode(node, name, characteristic);
        }
    }
}
