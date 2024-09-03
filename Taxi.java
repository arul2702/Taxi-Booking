import java.util.*;
class Taxi {
    static int taxiCount=0;
     int id;
     char currentLocation;
     int amountEarned;
     int availableTime;
     boolean booked;
     List<String> trips;

    public Taxi() {
        taxiCount+=1;
        id=taxiCount;
        currentLocation = 'A';
        amountEarned = 0;
        availableTime = 0;
        booked = false;
        trips = new ArrayList<String>();
    }
    //called after taxi is booked to set the values.
    public void setDetails(boolean booked,char currentLocation,int availableTime,int amountEarned,String tripDetails){
        this.booked = booked;
        this.currentLocation=currentLocation;
        this.amountEarned = amountEarned;
        this.availableTime = availableTime;
        this.trips.add(tripDetails);
    }

    public void printDetails(){
        System.out.println("Taxi - "+this.id+" Total Earnings - "+this.amountEarned);
        System.out.println("TaxiID | BookingID | CustomerID | From | To | PickupTime | DropTime | Amount");
        for(String trip:trips){
            System.out.println(id+"             "+trip);
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }

    public void printTaxiDetails(){
        //print all details of a taxi
        System.out.println("Taxi - "+this.id+" Total Earnings - "+this.amountEarned+" Current Location - "+this.currentLocation+" Availble Time - "+this.availableTime);
    }
    
}
