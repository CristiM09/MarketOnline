import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel loginPanel;
    private JTextField parolaUtilizator;
    private JTextField numeUtilizator;
    private JButton access;
    private JButton cancel;
    private static final JFrame frame = new JFrame();
    private final AccesPersoane log = AccesPersoane.getInstance();
    public Login() {
        access.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.verificaAcces(numeUtilizator.getText(), parolaUtilizator.getText(), frame);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.stergetext(numeUtilizator, parolaUtilizator);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Object[] options = { "OK", "CANCEL" };
                    int sterge= JOptionPane.showOptionDialog(null, "Sunteti siguri ca vreti sa iesiti?", "Notificare",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]);
                    if (sterge == JOptionPane.YES_NO_OPTION) {
                       System.exit(0);
                    }
                }

        });
    }

    public static void main(String[] args) {
        frame.setContentPane(new Login().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(300,300);
    }
}
