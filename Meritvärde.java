import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class Meritvärdev3 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        
        //Informerar användaren om vad programmet gör och uppmanar hen att börja.
        System.out.println("Välkommen till Adams meritvärdesuträknare!");
        System.out.println("Skriv in vilka kurser du har läst, hur mycket kurspoäng var och en bestod av och vilket betyg du fick i varje kurs.");
        System.out.println("Ett exempel på hur du skriver in en av dina kurser:");
        System.out.println("------------------------------");
        System.out.println("#1 Kursnamn: Engelska 6");
        System.out.println("Kurspoäng: 100");
        System.out.println("Betyg: C");
        System.out.println("------------------------------");
        System.out.println("Om du vill redigera tidigare kurser så kan du skriva \"tillbaka\" i kursnamnsfältet. Lycka till!");
        System.out.println();
        System.out.println("START");
        System.out.println("------------------------------");
        //////
        
        //Nödvändig deklaration av fält och variabler.
        String[] kursnamn = new String[50];
        String[] kurspoäng = new String[50];
        String[] betyg = new String[50];
        String svar;
        int x;
        int i;
        
        //Satsen som samlar in alla kurser, kurspoäng och betyg.
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
            svar = input.nextLine();
            
            if (svar.equals("tillbaka"))
            {
                x -= 2;
                System.out.println("------------------------------");
            }else
            {
                kursnamn[x] = svar;
                kurspoäng[x] = kurs(svar);
                
                if (kurspoäng[x].equals("1"))
                {
                    System.out.println("Kurspoäng: ");
                    kurspoäng[x] = input.nextLine();
                    System.out.println("Betyg: ");
                    betyg[x] = input.nextLine();
                    System.out.println("------------------------------");
                }else
                {
                    System.out.println("Kurspoäng: " + kurspoäng[x]);
                    System.out.println("Betyg: ");
                    betyg[x] = input.nextLine();
                    System.out.println("------------------------------");
                }
            }
        }
        ///////
        
        //En funktion som låter användaren att visa alla kurser som hen lade in.
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
        ///////
        
        //Meritpoäng
        System.out.println("Ange meritpoäng (x,x):");
        double meritpoäng = input.nextDouble();
        ///////
        
        //Omvandling från String till double samt uträkningen
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
        } 
            poäng += kurspoängDoub[i]*betygDoub[i];
            totKurspoäng += kurspoängDoub[i];
        ////////    
        
        //Presentation av resultatet
        poäng = Math.round((poäng/totKurspoäng) + meritpoäng);
        System.out.println("Din poäng blev: ");
        System.out.println("    ________ ");
        System.out.println("   |        |");
        System.out.println("   | " + poäng + " |");
        System.out.println("   |________|");
        
    }
    
    //En funktion som underlättar inskrivningen av kurser. Kurser som Svenska 1,2,3 och Engelska 5,6,7 känner programmet igen och det fyller i kurspoängsfältet åt användaren.
    public static String kurs(String strTarget)
    {
        String strTargetFirst = strTarget;
        int y;
        
        for (y = 1; y<8; y++)
        {
            if (strTarget.equals("Svenska " + y))
            {
                strTarget = "100";
                break;
            }else if(strTarget.equals("Engelska " + (y+4)))
            {
                strTarget = "100";
                break;
            }else if(strTarget.equals("Matematik " + y))
            {
                strTarget = "100";
                break;
            }else if(strTarget.equals("Biologi " + y))
            {
                strTarget = "100";
                break;
            }else if(strTarget.equals("Fysik " + (y+1)))
            {
                strTarget = "100";
                break;
            }else if(strTarget.equals("Fysik 1"))
            {
                strTarget = "150";
                break;
            }else if(strTarget.equals("Kemi " + y))
            {
                strTarget = "100";
                break;
            }
            
        }
        if (strTargetFirst.equals(strTarget))
        {
            strTarget = "1";
        }
        return strTarget;
    }
             
}
    
