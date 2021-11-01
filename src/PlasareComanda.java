import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlasareComanda {
    public JPanel comandaRoot;
    private JTextField textNume;
    private JTextField textAdresa;
    private JTextField textTelefon;
    private JButton btnGenereazaFactura;
    private JTextArea textFacutura;
    private JButton btnplaseazaComanda;
    private JButton btnSterge;


    public PlasareComanda() {
        btnGenereazaFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nume= String.format(textNume.getText());
                String adresa= String.format(textAdresa.getText());
                String telefon= String.format(textTelefon.getText());
                textFacutura.append("\t Factura\n***********************************************\n"+ "Nume Prenume: " +nume+"\nAdresa: "+adresa+"\nTelefon: "+telefon+"\n***********************************************\n***********************************************");

            }
        });
        btnplaseazaComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(
                        null,
                        "Comanda a fost plasata cu succes!",
                        "Notificare",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnSterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNume.setText(null);
                textAdresa.setText("");
                textTelefon.setText("");
                textFacutura.setText("");

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Factura");
        frame.setContentPane(new PlasareComanda().comandaRoot);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
