import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choix;
        do{
            System.out.println("Choisissez un jour de la semaine : \n1.Lundi\n2.Mardi\3.Mercredi" +
                    "\n4.Jeudi\n5.Vendredi\n6.Samedi\7.Dimanche");
            choix = sc.nextInt();
        }while(choix!=0);
    }

    public double tarif(Jours j){
        double tarif = 0;
        switch(j){
            case LU:
                System.out.println("Fermé le lundi");
                break;
            case MA: tarif=15.50;
                break;
            case ME: tarif=15.50;
                break;
            case JE : tarif=15.50;
                break;
            case VE : tarif=20.00;
                break;
            case SA : tarif=25.55;
                break;
            case DI : tarif=25.50;
                break;
        }
        return tarif;
    }
}