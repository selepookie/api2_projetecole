package DesignPatterns.Builder;

import java.util.Date;

/**
 * classe métier de gestion d'un enseignant
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Enseignant {
    /**
     * identifiant unique de l'enseignant
     */
    protected int id_enseignant;
    /**
     * matricule de l'enseignant
     */
    protected String matricule;
    /**
     * nom de l'enseignant
     */
    protected String nom;
    /**
     * prénom de l'enseignant
     */
    protected String prenom;
    /**
     * numéro de téléphone de l'enseignant
     */
    protected String tel;
    /**
     * charge sem de l'enseignant
     */
    protected int chargeSem;
    /**
     * salaire mensuel de l'enseignant
     */
    protected double salaireMensu;
    /**
     * date d'engagement de l'enseignant
     */
    protected Date dateEngag;
    /**
     * constructeur par défaut
     */
    private Enseignant(EnseignantBuilder cb){
        this.id_enseignant = cb.id_enseignant;
        this.matricule = cb.matricule;
        this.nom = cb.nom;
        this.prenom = cb.prenom;
        this.tel = cb.tel;
        this.chargeSem = cb.chargeSem;
        this.salaireMensu = cb.salaireMensu;
        this.dateEngag = cb.dateengag;
    }


    /**
     * getter id_enseignant
     * @return identifiant unique de l'enseignant
     */
    public int getId_enseignant() {
        return id_enseignant;
    }

    /**
     * getter matricule
     * @return matricule actuel
     */
    public String getMatricule() {
        return matricule;
    }
    /**
     * getter nom
     * @return nom actuel de l'enseignant
     */
    public String getNom() {
        return nom;
    }

    /**
     * getter prénom
     * @return prénom actuel de l'enseignant
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * getter tel
     * @return telephone actuel de l'enseignant
     */
    public String getTel() {
        return tel;
    }
    /**
     * getter chargeSem
     * @return chargesem actuelle
     */
    public int getChargeSem() {
        return chargeSem;
    }
    /**
     * getter salaireMensu
     * @return salaire mensuel actuel
     */
    public double getSalaireMensu() {
        return salaireMensu;
    }

    /**
     * getter dateEngag
     * @return date d'engagement
     */
    public Date getDateEngag() {
        return dateEngag;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enseignant other = (Enseignant) obj;
        if (this.id_enseignant != other.id_enseignant) {
            return false;
        }
        return true;
    }

    public static class EnseignantBuilder{
        protected int id_enseignant;
        protected String matricule;
        protected String nom;
        protected String prenom;
        protected String tel;
        protected int chargeSem;
        protected double salaireMensu;
        protected Date dateengag;

        public EnseignantBuilder setId_enseignant(int id_enseignant) {
            this.id_enseignant = id_enseignant;
            return this;
        }

        public EnseignantBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }
        public EnseignantBuilder setNom(String nom) {
            this.nom = nom;
            return this;
        }

        public EnseignantBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public EnseignantBuilder setCp(String tel) {
            this.tel = tel;
            return this;
        }

        public EnseignantBuilder setChargesem(int chargeSem) {
            this.chargeSem = chargeSem;
            return this;
        }

        public EnseignantBuilder setRue(double salaireMensu) {
            this.salaireMensu = salaireMensu;
            return this;
        }

        public EnseignantBuilder setNum(Date dateengag) {
            this.dateengag = dateengag;
            return this;
        }


        public Enseignant build() throws Exception{
            if(id_enseignant<=0 || matricule==null || nom==null || prenom==null ) throw new Exception("informations de construction incomplètes");
            return new Enseignant(this);
        }
    }


}
