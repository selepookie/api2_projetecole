package DesignPatterns.Builder;

public class Infos {
    /**
     * id des informations
     */
    protected int id_infos;
    /**
     * nombre d'heures
     */
    protected int nbreHeures;
    /**
     * cours
     */
    protected Cours cours;
    /**
     * salle
     */
    protected Salle salle;
    /**
     * enseignant
     */
    protected Enseignant enseignant;

    private Infos(InfosBuilder cb){
        this.id_infos = cb.id_infos;
        this.nbreHeures = cb.nbreHeures;
        this.cours = cb.cours;
        this.salle = cb.salle;
        this.enseignant = cb.enseignant;
    }

    /**
     * getter id_infos
     * @return id des informations
     */
    public int getId_infos() {
        return id_infos;
    }
    /**
     * getter nbreHeures
     * @return nombre d'heures actuels
     */
    public int getNbreHeures() {
        return nbreHeures;
    }
    /**
     * getter cours
     * @return cours actuel
     */
    public Cours getCours() {
        return cours;
    }
    /**
     * getter salle
     * @return salle actuelle
     */
    public Salle getSalle() {
        return salle;
    }
    /**
     * getter enseignant
     * @return enseignant actuel
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }

    public static class InfosBuilder{
        protected int id_infos;
        protected int nbreHeures;
        protected Cours cours;
        protected Salle salle;
        protected Enseignant enseignant;


        public InfosBuilder setId_infos(int id_infos){
            this.id_infos = id_infos;
            return this;
        }

        public InfosBuilder setNbreheures(int nbreHeures){
            this.nbreHeures = nbreHeures;
            return this;
        }

        public InfosBuilder setCours(Cours cours){
            this.cours = cours;
            return this;
        }

        public InfosBuilder setEnseignant(Enseignant enseignant){
            this.enseignant=enseignant;
            return this;
        }

        public Infos build() throws Exception{
            if(id_infos<=0 || cours==null){
                throw new Exception("informations de construction incomplètes");
            }
            return new Infos(this);
        }
    }
}
