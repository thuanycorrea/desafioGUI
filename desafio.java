import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class desafio {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Gestão de Poupança");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null); // Layout manual

        // Painel esquerdo (formulário)
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBackground(new Color(128, 128, 129));
        formPanel.setBounds(550, 0, 790, 999);

        // Labels
        JLabel jurosLabel = new JLabel("Juros ao mes %:");
        jurosLabel.setForeground(Color.WHITE);
        jurosLabel.setBounds(140, 340, 300, 20);
        formPanel.add(jurosLabel);

        JLabel anosLabel = new JLabel("Numero de anos:");
        anosLabel.setForeground(Color.WHITE);
        anosLabel.setBounds(140, 370, 210, 20);
        formPanel.add(anosLabel);

        JLabel depositoLabel = new JLabel("Deposito mensal R$:");
        depositoLabel.setForeground(Color.WHITE);
        depositoLabel.setBounds(140, 405, 210, 20);
        formPanel.add(depositoLabel);

        JLabel totalLabel = new JLabel("Total poupado R$:");
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setBounds(140, 445, 210, 20);
        formPanel.add(totalLabel);

        // Campos de texto
        JTextField jurosField = new JTextField();
        jurosField.setBounds(320, 330, 220, 30);
        formPanel.add(jurosField);

        JTextField anosField = new JTextField();
        anosField.setBounds(320, 365, 220, 30);
        formPanel.add(anosField);

        JTextField depositoField = new JTextField();
        depositoField.setBounds(320, 400, 220, 30);
        formPanel.add(depositoField);

        JTextField totalField = new JTextField();
        totalField.setBounds(320, 435, 220, 30);
        totalField.setEditable(false);
        formPanel.add(totalField);

        // Botão OK
        JButton okButton = new JButton("Calcular");
        okButton.setBounds(270, 540, 235, 30);
        formPanel.add(okButton);

        // Ação do botão
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double jurosMensal = Double.parseDouble(jurosField.getText()) / 100;
                    int anos = Integer.parseInt(anosField.getText());
                    double depositoMensal = Double.parseDouble(depositoField.getText());
                    double capitalInicial = 0; // Se não houver campo para capital inicial, consideramos zero

                    int numMeses = anos * 12;
                    double montanteFinal = capitalInicial * Math.pow(1 + jurosMensal, numMeses) +
                            depositoMensal * ((Math.pow(1 + jurosMensal, numMeses) - 1) / jurosMensal);

                    totalField.setText(String.format("R$ %.2f", montanteFinal));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos.");
                }
            }
        });

        // Adiciona o painel de formulário ao frame
        frame.add(formPanel);

        frame.setVisible(true);
    }
}
