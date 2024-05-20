package DesignPatterns.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * classe métier de gestion d'une classe
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Classe {
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i = 1;

    /**
     * id unique de la classe
     */
    protected int id_classe;
    /**
     * sigle de la classe
     */
    protected String sigle;
    /**
     * année en cours
     */
    protected int annee;
    /**
     * spécialité de la classe
     */
    protected String specialite;
    /**
     * nombre d'élèves
     */
    protected int nbreEleves;
    /**
     * liste d'infos relatives à la classe
     */
    protected List<Infos> infos = new ArrayList<>();

    // private classebuilder
    private Classe(ClasseBuilder cb) {
        this.id_classe = cb.id_classe;
        this.sigle = cb.sigle;
        this.annee = cb.annee;
        this.specialite = cb.specialite;
        this.nbreEleves = cb.nbreEleves;
    }


    /**
     * getter id_classe
     * @return identifiant de la classe
     */
    public int getId_classe() {
        return id_classe;
    }

    /**
     * getter sigle
     * @return sigle actuel de la classe
     */
    public String getSigle() {
        return sigle;
    }

    /**
     * getter annee
     * @return année en cours
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * getter specialite
     * @return specialité de la classe
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * getter nbreEleves
     * @return nombre d'élèves de la classe
     *
     */
    public int getNbreEleves() {
        return nbreEleves;
    }

    /**
     * getter Infos
     * @return les infos de la classe
     */
    public List<Infos> getInfos() {
        return infos;
    }

    public static class ClasseBuilder{
        protected int id_classe;
        protected String sigle;
        protected int annee;
        protected String specialite;
        protected int nbreEleves;
        public ClasseBuilder setId_classe(int id_classe){
            this.id_classe = id_classe;
            return this;
        }

        public ClasseBuilder setSigle(String sigle){
            this.sigle = sigle;
            return this;
        }

        public ClasseBuilder setAnnee(int annee){
            this.annee = annee;
            return this;
        }

        public ClasseBuilder setSpecialite(String specialite){
            this.specialite=specialite;
            return this;
        }

        public ClasseBuilder setNbreEleves(int nbreEleves){
            this.nbreEleves=nbreEleves;
            return this;
        }

        public Classe build() throws Exception {
            if (sigle == null || annee == 0) {
                throw new Exception("Informations de construction incomplètes");
            }
            return new Classe(this);
        }

    }


    /**
     * affichage de toutes les informations de la classe
     * @return toutes les infos relatives à la classe
     */
    @Override
    public String toString() {
        return "Classe{" +
                "id_classe=" + id_classe +
                ", sigle='" + sigle + '\'' +
                ", annee=" + annee +
                ", specialite='" + specialite + '\'' +
                ", nbreEleves=" + nbreEleves +
                ", infos=" + infos +
                '}';
    }

}
