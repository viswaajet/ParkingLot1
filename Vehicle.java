
import java.util.*;

class Vehicle{
    // public enum VehicleTypes
    // {
    //     HATCHBACK,
    //     SUV,
    //     TWOWHEELER
    // }
    // public enum VehicleSize
    // {
    //     SMALL,
    //     MEDIUM,
    //     LARGE
    // }
    //int parkinglots = 3; 
    public static HashMap<String,String> hatchback = new HashMap<String,String>();
    public static HashMap<String,String> suv = new HashMap<String,String>();
    public static HashMap<String,String> twowheeler = new HashMap<String,String>();
  
    public static int SMALL_CAPACITY = 20;
    public static int MEDIUM_CAPACITY = 10;
    public static int LARGE_CAPACITY = 5;

    public static int HATCHBACK_RATECARD = 10;
    public static int SUV_RATECARD = 20;
    public static int TWOWHEELER_RATECARD = 5;

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the VehicleType");
        String vehicletype = sc.next();
        String vehicleSize = sc.next();
        String vehicleNo = sc.next();
        String datetime = sc.next();
        Boolean checkFreeOrNot = Check(vehicletype,vehicleSize,vehicleNo,datetime);
        if(!checkFreeOrNot){
            System.out.print("Parking Space Not Available");
        }
        else{
            System.out.print("Parking Available");
        }
        String noofHours = removeVehicle(vehicleNo,vehicletype);
    
       
        sc.close();
    }
    public static String removeVehicle(String vehicleNo, String vehicleType){
        String noofHours = "";
        if(vehicleType.equalsIgnoreCase("Hatchback")){
            noofHours = hatchback.get(vehicleNo);
            hatchback.remove(vehicleNo);
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            noofHours= hatchback.get(vehicleNo);
            hatchback.remove(vehicleNo);
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            noofHours = hatchback.get(vehicleNo);
            hatchback.remove(vehicleNo);
        }
        return noofHours;
    }

    public static Boolean Check(String vehicleType, String vehicleSize, String vehicleNo,String datetime ){
        Boolean vacancy = true;
        if(vehicleType.equalsIgnoreCase("Hatchback")){
            if(hatchback.size() == LARGE_CAPACITY ){
                vacancy = false;
            }
            else{
                hatchback.put(vehicleNo,datetime);
            }

        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            if(suv.size() == SMALL_CAPACITY)
            {
                vacancy = false;
            }
            else{
                suv.put(vehicleNo,datetime);
            }
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            if(twowheeler.size() == MEDIUM_CAPACITY ){
                vacancy = false;
            }
            else{
                twowheeler.put(vehicleNo,datetime);
            }
        }
        else {
            vacancy = false;
        }
        return vacancy;
    } 
   
  

}