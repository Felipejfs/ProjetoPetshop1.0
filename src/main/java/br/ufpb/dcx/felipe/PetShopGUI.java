package br.ufpb.dcx.felipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PetShopGUI extends JFrame {
    public JTextField nomeField;
    public JTextField especieField;
    public JTextField racaField;
    public JTextArea outputArea;
    public ArrayList<Animal> animais;

    public PetShopGUI() {
        animais = new ArrayList<>();

        setTitle("Sistema de Petshop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Espécie:"));
        especieField = new JTextField();
        inputPanel.add(especieField);
        inputPanel.add(new JLabel("Raça:"));
        racaField = new JTextField();
        inputPanel.add(racaField);
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new CadastrarListener());
        inputPanel.add(cadastrarButton);

        add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton listarButton = new JButton("Listar Animais");
        listarButton.addActionListener(new ListarListener());
        buttonPanel.add(listarButton);
        JButton pesquisarButton = new JButton("Pesquisar Animal");
        pesquisarButton.addActionListener(new PesquisarListener());
        buttonPanel.add(pesquisarButton);
        JButton removerButton = new JButton("Remover Animal");
        removerButton.addActionListener(new RemoverListener());
        buttonPanel.add(removerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class CadastrarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String especie = especieField.getText();
            String raca = racaField.getText();
            Animal animal = new Animal(nome, especie, raca);
            animais.add(animal);
            nomeField.setText("");
            especieField.setText("");
            racaField.setText("");
            JOptionPane.showMessageDialog(PetShopGUI.this, "Animal cadastrado com sucesso!");
        }
    }

    private class ListarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            outputArea.setText("");
            for (Animal animal : animais) {
                outputArea.append(animal.toString() + "\n");
            }
        }
    }

    private class PesquisarListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = JOptionPane.showInputDialog(PetShopGUI.this, "Digite o nome do animal:");
            boolean encontrado = false;
            for (Animal animal : animais) {
                if (animal.getNome().equalsIgnoreCase(nome)) {
                    outputArea.setText(animal.toString());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                JOptionPane.showMessageDialog(PetShopGUI.this, "Animal não encontrado.");
            }
        }
    }

    private class RemoverListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = JOptionPane.showInputDialog(PetShopGUI.this, "Digite o nome do animal a ser removido:");
            boolean removido = false;
            for (int i = 0; i < animais.size(); i++) {
                if (animais.get(i).getNome().equalsIgnoreCase(nome)) {
                    animais.remove(i);
                    removido = true;
                    break;
                }
            }
            if (removido) {
                JOptionPane.showMessageDialog(PetShopGUI.this, "Animal removido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(PetShopGUI.this, "Animal não encontrado.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetShopGUI();
            }
        });
    }
}


