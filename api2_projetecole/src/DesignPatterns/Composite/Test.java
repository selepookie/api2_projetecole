package DesignPatterns.Composite;

public class Test {
    public static void main(String[] args) {

        Classe c1 = new Classe(1,"3b",2024, "informatique",30);
        Classe c2 = new Classe(2,"2a",2021, "droit",50);
        Classe c3 = new Classe(3,"1p", 2024, "info info",20);

        Section s1 = new Section(1, "info");
        Section s2 = new Section(2, "droit");
        Section general = new Section(3,"tout");

        s1.getElts().add(c1);
        s2.getElts().add(c2);
        s1.getElts().add(c3);

        general.getElts().add(c1);
        general.getElts().add(c2);
        general.getElts().add(c3);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(general);

    }

}
