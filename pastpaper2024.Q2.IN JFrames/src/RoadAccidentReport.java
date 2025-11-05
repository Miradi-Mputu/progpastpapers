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
    String fileName ="userACCIDENTS_input.txt";

    public void savetothefile(){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write("ACCIDENT REPORT\n"+"**********************************\n"+
                    "VEHICLE TYPE: "+getAccidentVehicleType()+"\n"+
                    "CITY: " +getCity()+"\n"+" ACCIDENT TOTAL: " +getAccidentTotal()+"\n");
        } catch (Exception e) {
            System.out.println("Error writing to file:" + e.getMessage());
        }
    }

    //the purpose of this method is to read from the data given and to display it in the file
    public void readfromfile(){
        try(BufferedReader reader = new BufferedReader(new FileReader("userACCIDENTS_input.txt"))){
            String read;
            while ((read=reader.readLine())!=null){
                System.out.println(read);
            }System.out.println("\nData has been read successfully from userACCIDENTS_input.txt\n");
        } catch (IOException e) {
            System.out.println("Error reading from file:" + e.getMessage());
        }
    }
}
