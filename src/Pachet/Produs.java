package Pachet;

public class Produs {
    private String tip_produs;
    private double pret;

    public String getTip(){
        return tip_produs;
    }

    public double getPret(){
        return pret;
    }

    public double setPret(double i){
        this.pret = pret/i;
        return pret;
    }

    public Produs(String p, double cantitate){
        this.tip_produs = p;
        switch(tip_produs){
            case "Pui":
                pret = 25 * cantitate;
                break;
            case "Vita":
                pret = 30 * cantitate;
                break;
            case "Peste":
                pret = 21 * cantitate;
                break;
            case "Porc":
                pret = 20 * cantitate;
                break;
            case "Iepure":
                pret = 15 * cantitate;
                break;
        }
    }
}
