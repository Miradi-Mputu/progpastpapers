import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RoadAccidentReport extends RoadAccidents{
    public RoadAccidentReport(String VehicleType, String City, int AccidentTotal) {
        super(VehicleType, City, AccidentTotal);
    }

    public String printAccidentReport(){
        System.out.println("VEHICLE ACCIDENT REPORT");
        System.out.println("************************");
        System.out.println("VEHICLE TYPE: "+getAccidentVehicleType());
        System.out.println("CITY: " +getCity());
        System.out.println(" ACCIDENT TOTAL: " +getAccidentTotal());
        System.out.println("************************");

return getCity()+getVehicleType()+getAccidentTotal();
    }


    @Override
    public String getAccidentVehicleType() {
        return VehicleType;
    }

    @Override
    public int getAccidentTotal() {
        return AccidentTotal;
    }
   
}
