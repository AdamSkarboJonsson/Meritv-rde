import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Meritvärdev3 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Välkommen till Adams meritvärdesuträknare!");
        System.out.println("I detta program skriver du in vilka kurser du har läst, hur mycket kurspoäng var och en bestod av och vilket betyg du fick i varje kurs.");
        System.out.println("Ett exempel på hur du skriver in en av dina kurser:");
        System.out.println("------------------------------");
        System.out.println("#1 Kursnamn: Engelska 6");
        System.out.println("Kurspoäng: 100");
        System.out.println("Betyg: C");
        System.out.println("------------------------------");
        System.out.println("Lycka till!");
        System.out.println();
        System.out.println("START");
        System.out.println("------------------------------");
        
        String[] kursnamn = new String[50];
        String[] kurspoäng = new String[50];
        String[] betyg = new String[50];
        String svar;
        int x;
        int i;
        
        for (x = 1; x<49; x++)
        {
            if (x >= 25)
            {
                System.out.println("Du har lagt in 24 kurser eller fler och fortsätt bara om du har läst uttökat. Skriv \"klar\" om du är klar eller tryck enter om du vill fortsätta.");
                svar = input.nextLine();
                
                if (svar.equals("klar"))
                {
                    break;
                }
            }
            
            System.out.println("#" + x + " Kursnamn: ");
            kursnamn[x] = input.nextLine();

            System.out.println("Kurspoäng: ");
            kurspoäng[x] = input.nextLine();

            System.out.println("Betyg: ");
            betyg[x] = input.nextLine();
            System.out.println("------------------------------");
        }
        
        System.out.println("Skriv \"visa\" om du vill se alla kurser som du har lagt in. Tryck enter för att fortsätta.");
        svar = input.nextLine();

        if (svar.equals("visa"))
        {
            System.out.println("------------------------------");

            for(i = 1; i < x ; i++)
            {
                System.out.println("#" + i + " Kursnamn: " + kursnamn[i]);
                System.out.println("Kurspoäng: " + kurspoäng[i]);
                System.out.println("Betyg: " + betyg[i]);
                System.out.println("------------------------------");
            }
            System.out.println("Psst! Du kan scrolla upp och ner i kurslistan!");
        }

        System.out.println("Ange meritpoäng (x,x):");
        double meritpoäng = input.nextDouble();

        double[] kurspoängDoub = new double[x];
        double[] betygDoub = new double[x];
        double poäng = 0;
        double totKurspoäng = 0;
        
        for (i = 1; i < x; i++)
        {
            switch (betyg[i]) {
                case "A":
                    betyg[i]= "20";
                    break;
                case "B":
                    betyg[i]= "17.5";
                    break;
                case "C":
                    betyg[i]= "15";
                    break;
                case "D":
                    betyg[i]= "12.5";
                    break;
                case "E":
                    betyg[i]= "10";
                    break;
                case "F":
                    betyg[i]= "0";
                    break;
            }
            
            kurspoängDoub[i] = Double.parseDouble(kurspoäng[i]);
            betygDoub[i] = Double.parseDouble(betyg[i]);
            
            poäng += kurspoängDoub[i]*betygDoub[i];
            totKurspoäng += kurspoängDoub[i];
        }
        
        poäng = (poäng/totKurspoäng) + meritpoäng;
        System.out.println("Din poäng blev: ");
        System.out.println("   _______");
        System.out.println();
        System.out.println("   | " + poäng + " |");
        System.out.println("   _______");
    }
             
}
    
