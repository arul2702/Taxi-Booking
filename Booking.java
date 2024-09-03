import java.util.*;
public class Booking {
    
    public static void bookTaxi(int customeID,char pickupPoint,char dropPoint,int pickupTime,List<Taxi> freeTaxis){
        int min = 999;
        int distanceBetweePickUpandDrop = 0;
        int earning = 0;
        int nextFreeTime = 0;
        char nextSpot = 'Z';
        Taxi bookedTaxi = null;
        String tripDetails="";

        for(Taxi t:freeTaxis){
            int distanceBetweenCustomerandTaxi = Math.abs((dropPoint-'0')-(pickupPoint-'0')) * 15;
            if(distanceBetweePickUpandDrop < min){
                bookedTaxi = t;
                distanceBetweePickUpandDrop = Math.abs((dropPoint-'0')-(pickupPoint-'0'))*15;
                nextFreeTime = pickupTime + distanceBetweePickUpandDrop/15;
                nextSpot = dropPoint;
                earning = (distanceBetweePickUpandDrop-5)*10 +100;
                tripDetails = customeID + "           " + customeID+"         "+pickupPoint+"     "+dropPoint+"      "+pickupTime+"          "+nextFreeTime+"        "+earning;
            }
        }
        bookedTaxi.setDetails(true, nextSpot, nextFreeTime, earning, tripDetails);
        System.out.println("Taxi "+bookedTaxi.id+" booked");
    }
}

