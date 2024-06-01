package DesignPatterns.Observer;


import java.time.LocalDate;

public class Test {
        public static void main(String[] args) {
            Classe c1 = new Classe(1,"C1",2022, "informatique",30);
            Classe c2 = new Classe(2,"C2",2024, "enseignement",40);

            Enseignant e1 = new Enseignant(1,"m1","druart", "antoine", "123456", 30,2000.00,  LocalDate.of(2024, 1, 1));
            Enseignant e2 = new Enseignant(2,"m2","cookie", "titi", "987654", 30,2000.00,  LocalDate.of(2024, 3, 12));

            c1.addObserver(e1);
            c2.addObserver(e2);

            c1.setNbreEleves(25);
            c2.setNbreEleves(35);
        }
}
