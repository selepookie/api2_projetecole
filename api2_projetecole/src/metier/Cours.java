package metier;

public class Cours {
    protected String code;
    protected String intitule;

    protected Salle salle;

    public Cours(){}

    public Cours(String code, String intitule,Salle salle) {
        this.code = code;
        this.intitule = intitule;
        this.salle=salle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
