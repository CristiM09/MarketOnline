import javax.swing.*;

public class AccesPersoane {
    private static AccesPersoane instance;
    private final String[][] acces = {
            {"Raul", "1234"},
            {"Cristi", "1234"},
    };

    public String[][] getPersoane(){
        return this.acces;
    }
    public void stergetext(JTextField t, JTextField p){
        t.setText("");
        p.setText("");
    }
    public static AccesPersoane getInstance(){
        if(null == instance){
            instance = new AccesPersoane();
        }
        return instance;
    }
    public void verificaAcces(String nume, String parola, JFrame frame){
        for (int i = 0; i < this.getPersoane().length; i++) {
            if(this.getPersoane()[i][0].equals(nume) && this.getPersoane()[i][1].equals(parola)){
                frame.setContentPane(new Shop().rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                break;
            }
            if(i == this.getPersoane().length-1){
                JOptionPane.showConfirmDialog(
                        null,
                        "Nume sau Parola incorecte!",
                        "Atentie",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
            }
        }
    }
}
