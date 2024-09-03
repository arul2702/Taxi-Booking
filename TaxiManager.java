import java.util.ArrayList;
import java.util.List;

public class TaxiManager {
    

    public static List<Taxi> createTaxis(int n){
        List<Taxi> taxis = new ArrayList<>();
        for(int i=1;i<=n;i++){
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }

    public static List<Taxi> getFreeTaxis(List<Taxi> taxis,char pickupPoint,int pickupTime){
        List<Taxi> freeTaxis = new ArrayList<>();
        for(Taxi t : taxis){
            if(t.availableTime <= pickupTime && (Math.abs(t.currentLocation - '0' - (pickupPoint - '0')) <= pickupTime - t.availableTime)){
                freeTaxis.add(t);
            }
        }
        return freeTaxis;
    }
}
