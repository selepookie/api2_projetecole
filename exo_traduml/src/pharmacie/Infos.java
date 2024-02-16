package pharmacie;

public class Infos {
    private int quantite;
    private Medicament medicament;

    public Infos(){}

    public Infos(int quantite, Medicament medicament){
        this.quantite = quantite;
        this.medicament = medicament;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}
