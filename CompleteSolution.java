import java.text.*;
import java.util.*;


// Assuming parking lot for many days 

public class CompleteSolution {
    public static HashMap<String,List<String>> hatchback = new HashMap<String,List<String>>();
    public static HashMap<String,List<String>> suv = new HashMap<String,List<String>>();
    public static HashMap<String,List<String>> twowheeler = new HashMap<String,List<String>>();

  
    public static int SMALL_CAPACITY = 20;
    public static int MEDIUM_CAPACITY = 10;
    public static int LARGE_CAPACITY = 5;

    public static int HATCHBACK_RATECARD = 10;
    public static int SUV_RATECARD = 20;
    public static int TWOWHEELER_RATECARD = 5;

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the VehicleType");
        String vehicletype = sc.next();
        System.out.println("Enter the vehicle size");
        String vehicleSize = sc.next();
        System.out.println("Enter the vehicle No");
        String vehicleNo = sc.next();
        System.out.println("Enter your name");
        String name = sc.next();
        Date currentdate = new Date();
        Boolean leaving = false;
        Boolean searching = true;
        Boolean checkFreeOrNot = Check(vehicletype);
        if(!checkFreeOrNot){
            System.out.print("Parking Spot is not Available");
        }
        else
        {
            System.out.print("Parking Spots is Available");
            InsertDetails(vehicleNo,vehicleSize,vehicletype,currentdate,name);

        }

        if(leaving){
            Date date = new Date();
            long noofHours = removeVehicle(vehicleNo,date,vehicletype);
            long ratecard = Calculate(noofHours,vehicletype);
            System.out.println("You have to pay" + ratecard);
        }
        if(searching){
            SearchVehicleHistory(vehicleNo,vehicletype);
        }
        sc.close();
    }
    public static void InsertDetails(String vehicleNo,String vehicleSize,String vehicleType,Date currentdate,String name){
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        List<String> personaldetails = new ArrayList<String>();
        personaldetails.add(df.format(currentdate));
        personaldetails.add(vehicleSize);
        personaldetails.add(vehicleType);  
        personaldetails.add(name);
        personaldetails.add(vehicleNo);
        if(vehicleType.equalsIgnoreCase("Hatchback")){
           hatchback.put(vehicleNo,personaldetails);
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            suv.put(vehicleNo,personaldetails);
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            twowheeler.put(vehicleNo,personaldetails);  
        }

    }

    public static long Calculate(long noofHours,String vehicleType){
        long rate = 0;
        if(vehicleType.equalsIgnoreCase("Hatchback")){
           rate = (long)HATCHBACK_RATECARD * noofHours;
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            rate = (long)SUV_RATECARD * noofHours;
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            rate = (long)TWOWHEELER_RATECARD * noofHours;
        }
        return rate;
    }
    public static void SearchVehicleHistory(String vehicleno,String vehicleType){
        List<String> details = new ArrayList<String>();
        if(vehicleType.equalsIgnoreCase("Hatchback")){
            details = hatchback.get(vehicleno);
            System.out.print(details);
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            details = hatchback.get(vehicleno);
            System.out.print(details);
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            details = hatchback.get(vehicleno);
            System.out.print(details);
        }

    }
    public static long removeVehicle(String vehicleNo, Date date,String vehicleType){
        try{
        long noofHours = 0;
        Date initialParkingTime = date;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        List<String> personalDetails = new ArrayList<String>();
        if(vehicleType.equalsIgnoreCase("Hatchback")){
            personalDetails = hatchback.get(vehicleNo);
            initialParkingTime = df.parse(personalDetails.get(0));

            hatchback.remove(vehicleNo);
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            personalDetails = suv.get(vehicleNo);
            initialParkingTime = df.parse(personalDetails.get(0));
            suv.remove(vehicleNo);
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            personalDetails = twowheeler.get(vehicleNo);
            initialParkingTime = df.parse(personalDetails.get(0));
            twowheeler.remove(vehicleNo);
        }
        noofHours = date.getTime() - initialParkingTime.getTime();
        return noofHours;
        }
        catch(Exception e){
            return 0;
        }
    }

    public static Boolean Check(String vehicleType){
        Boolean vacancy = true;
        if(vehicleType.equalsIgnoreCase("Hatchback")){
            if(hatchback.size() == LARGE_CAPACITY ){
                vacancy = false;
            }
        }
        else if(vehicleType.equalsIgnoreCase("SUV")){
            if(suv.size() == SMALL_CAPACITY)
            {
                vacancy = false;
            }
        }
        else if(vehicleType.equalsIgnoreCase("TWOWHEELER")){
            if(twowheeler.size() == MEDIUM_CAPACITY ){
                vacancy = false;
            }   
        }
        return vacancy;
    } 
}