import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        String[]cities ={"Cape Town","Jozi","PE"};
        String[]Type={"Car","Motor Bike"};
        //we place the names of the arrays to act as a constant for the array
        //it simply represents the number of values in the array.
        //Array accident will hold the inputs of the user for the city and the accidents per city and vehicle
        //we could have placed 3 and 2 because there are two car types and 3 cities
        //int[][]accidents=new int[3][2];
        int[][]accidents=new int[cities.length][Type.length];
        //Loops through both arrays
        //the nested loop will do this , look at each city as a bus stop so we have three bus stops
        //at each bus stop it will ask two questions car and motorbike
        //this is why the type loop is inside the cities loop
        for (int i =0;i< cities.length;i++){
            for (int x=0;x<Type.length;x++){
                System.out.println("Enter the number of "+Type[x]+"Accidents for "+ cities[i]+":");
                accidents[i][x]= sc.nextInt();
            }
        }
//the int total array will represent what was placed in the accidents array
// we say cities because there are 3 cities and 2 inputs per city
        int []totals= new int[cities.length];
        //requested by the question for max accident and city with most accidents
        int maxAccidents=0;
        String maxCity="";
        for (int i =0;i<cities.length;i++){
            //here we say that total is equal to the two car type inputs
            totals[i]=accidents[i][0]+accidents[i][1];
            if (totals[i]>maxAccidents){
                maxAccidents=totals[i];
            }
            //the i in cities holds the value throughout the If statement
            //i represents both the greatest value and city
            maxCity=cities[i];
        }



        System.out.println(" ");
        System.out.println("ROAD ACCIDENTS REPORT");
        System.out.println(" ");
        System.out.printf("%18s%18s\n","CAR","Motor Bike");

        for (int i =0;i<cities.length;i++){
            System.out.printf("%-10s%18d%18d\n",cities[i],accidents[i][0],accidents[i][1]);
        }

        System.out.println(" ");
        System.out.println("ROAD ACCIDENT TOTALS FOR EACH CITY");
        System.out.println(" ");

        for (int i=0;i<cities.length;i++){
            System.out.printf("%-10s%10d\n",cities[i],totals[i]);
        }

        System.out.println("CITY WITH THE MOST VEHICLE ACCIDENTS:"+maxCity);
    }
}