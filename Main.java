import java.util.*;
public class Main{
    public static void main(String args[]){
        TaxiManager TaxiManager = new TaxiManager();
        List<Taxi> taxis = TaxiManager.createTaxis(4);

        Scanner scanner  = new Scanner(System.in);
        int id = 1;

        while(true){
            System.out.println("0 - > Book Taxi");
            System.out.println("1 - > Print Details");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                {
                    int customeID = id;
                    System.out.println("Enter pickup point");
                    char pickupPoint = scanner.next().charAt(0);
                    System.out.println("Enter drop point");
                    char dropPoint = scanner.next().charAt(0);
                    System.out.println("Enter pickup time");
                    int pickupTime = scanner.nextInt();
                    
                    if(pickupPoint<'A'||dropPoint>'F'||pickupPoint>'F'||dropPoint<'A'){
                        System.out.println("Enter Valid Points. Exitting...");
                        return ;
                    }

                    //check the free taxis
                    List<Taxi> freeTaxis = TaxiManager.getFreeTaxis(taxis,pickupPoint,pickupTime);

                    if(freeTaxis.size()==0){
                        System.out.println("No Free Taxis. Exitting...");
                        return;
                    }

                    Collections.sort(freeTaxis,(a,b)->a.amountEarned - b.amountEarned);

                    //get free taxi nearest to us
                    Booking.bookTaxi(id,pickupPoint,dropPoint,pickupTime,freeTaxis);
                    id++;
                    break;

                }    
                case 1:
                {
                    for(Taxi t:taxis){
                        t.printTaxiDetails();
                    }
                    for(Taxi t:taxis){
                        t.printDetails();
                    }
                    break;

                }
            
                default:
                    break;
            }
        }
    }
}