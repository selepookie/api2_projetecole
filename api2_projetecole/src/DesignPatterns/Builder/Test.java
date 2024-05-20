package DesignPatterns.Builder;

public class Test {
    public static void main(String[] args) {
        try {
            Classe cl1 = new Classe.ClasseBuilder().
                    setId_classe(6).
                    setSigle("2IB").
                    setAnnee(2023).
                    setSpecialite("Informatique").
                    setNbreEleves(50).
                    build();
            System.out.println(cl1);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
        try {
            Classe cl2 = new Classe.ClasseBuilder().
                    setId_classe(8).
                    setSigle("2AB").
                    setNbreEleves(60).
                    build();
            System.out.println(cl2);
        } catch (Exception e) {
            System.out.println("erreur "+e);
        }
    }

}
