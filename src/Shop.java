import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Pachet.Produs;

public class Shop {
    public JPanel rootPanel;
    private JComboBox cboption;
    private JButton btnAdaugaCos;
    private JTextField txttotal;
    private JTextField txtqty;
    private JList listaAlimente;
    private JComboBox item;
    private JButton btnsterge;
    private JButton btnComanda;
    private JButton btnIesire;
    private static final JFrame frame = new JFrame();
    private final ArrayList<String> lista = new ArrayList<>();
    public static DefaultListModel modelLista = new DefaultListModel();


    public Shop() {
        btnAdaugaCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"DA", "Anuleaza"};
                int afisare = JOptionPane.showOptionDialog(null, "Sunteti sigur ca vreti sa adaugati in cos?", "Notificare",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, JOptionPane.CANCEL_OPTION);
                if (afisare == JOptionPane.YES_NO_OPTION) {

                    double qty;
                    String tip = (String) item.getSelectedItem();
                    qty = Double.parseDouble(txtqty.getText());
                    Produs prod_nou = new Produs(tip, qty);
                    if (cboption.getSelectedItem().equals("Grame")) {
                        prod_nou.setPret(10.0);
                    }

                    for (int i = 0; i < lista.size(); i++) {
                        modelLista.addElement(lista.get(i));
                    }
                    modelLista.addElement("Produs: " + prod_nou.getTip() + " Cantitate: " + qty + " " + cboption.getSelectedItem() + "  -  Pret: " + prod_nou.getPret() + "LEI");

                    txttotal.setText(Double.toString(prod_nou.getPret()));

                    listaAlimente.setModel(modelLista);


                }
            }
        });
        btnsterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "DA", "NU" };
               int sterge= JOptionPane.showOptionDialog(null, "Doriti sa stergeti lista?", "Notificare",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
               if (sterge == JOptionPane.YES_NO_OPTION) {
                   modelLista.clear();
               }
            }

        });
        btnComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new PlasareComanda().comandaRoot);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setSize(600,400);
            }
        });
        btnIesire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Iesire");
                if(JOptionPane.showConfirmDialog(frame,"Sunteti sigur sa vreti sa iesiti?","Informatie",
                        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
                    System.exit(0);

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Magazin Carne");
        frame.setContentPane(new Shop().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
