package DesignPatterns.Builder;

/**
 * classe métier de gestion d'un cours
 * @author Selena D'Urbano
 * @version 1.0
 */
public class Cours {
    /**
     * compteur qui auto-incrémente l'identifiant
     */
    protected static int i=1;
    /**
     * identifiant unique du cours
     */
    protected int id_cours;
    /**
     * code du cours
     */
    protected String code;
    /**
     * intitule du cours
     */
    protected String intitule;
    /**
     * salle du cours
     */
    protected Salle salle;
    /**
     * constructeur par défaut
     */
    private Cours(CoursBuilder cb){
        this.id_cours = cb.id_cours;
        this.code = cb.code;
        this.intitule = cb.intitule;
        this.salle = cb.salle;
    }

    /*
     * getter code
     * @return code actuel du cours
     */
    public String getCode() {
        return code;
    }
    /**
     * setter du cours
     * @param code nouveau code du cours
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * getter intitule
     * @return intitule actuel du cours
     */
    public String getIntitule() {
        return intitule;
    }
    /**
     * setter intitule
     * @param intitule nouvel intitule du cours
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    /**
     * getter salle
     * @return salle actuelle
     */
    public Salle getSalle() {
        return salle;
    }
    /**
     * setter salle
     * @param salle nouvelle salle du cours
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    /**
     * getter id_cours
     * @return id actuel du cours
     */
    public int getId_cours() {
        return id_cours;
    }
    /**
     * setter id_cours
     * @param id_cours nouvel id du cours
     */
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    public static class CoursBuilder{
        /**
         * compteur qui auto-incrémente l'identifiant
         */
        protected static int i=1;
        /**
         * identifiant unique du cours
         */
        protected int id_cours;
        /**
         * code du cours
         */
        protected String code;
        /**
         * intitule du cours
         */
        protected String intitule;
        /**
         * salle du cours
         */
        protected Salle salle;

        public CoursBuilder setId_cours(int id_cours){
            this.id_cours = id_cours;
            return this;
        }

        public CoursBuilder setCode(String code){
            this.code = code;
            return this;
        }

        public CoursBuilder setIntitule(String intitule){
            this.intitule= intitule;
            return this;
        }

        public CoursBuilder setSalle(Salle salle){
            this.salle = salle;
            return this;
        }

        public Cours build() throws Exception{
            if(id_cours<=0 || code==null || intitule==null || salle==null) throw new Exception("informations de construction incomplètes");
            return new Cours(this);
        }
    }
}
