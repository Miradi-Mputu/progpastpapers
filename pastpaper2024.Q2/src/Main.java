import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         String VehicleType;
         String City;
         int AccidentTotal;
        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter accident vehicle type:");
VehicleType= scanner.next();
        System.out.println("Enter city of accident:");
City= scanner.next();
        System.out.println("Enter total accidents for :");
AccidentTotal= scanner.nextInt();

RoadAccidentReport roadAccidentReport=new RoadAccidentReport( VehicleType, City, AccidentTotal);
   roadAccidentReport.printAccidentReport();
    }
}