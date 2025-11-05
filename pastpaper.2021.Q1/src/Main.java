//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
String[] deliveries={"DELIVERIES 2018","DELIVERIS2019","DELIVERIES2020"};
 int[][] numbers={{128,135,139},{155,129,175},{129,130,185}};

 System.out.println("****************");
 System.out.println("DELIVERIES REPORT");
 System.out.println("****************");
 System.out.printf("%20s%10s%10s\n","JAN","FEB","MAR");

    for(int i=0; i< deliveries.length;i++){
        System.out.printf("%-20s%s%10s%10s\n",deliveries[i],numbers[i][0],numbers[i][1],numbers[i][2]);
    }
        System.out.println("****************");
        System.out.println("DELIVERIES STATISTICS");
        System.out.println("****************");

        int min =numbers[0][0];
        int max=numbers[0][0];
        int sum =0;
        for(int i=0; i< deliveries.length;i++){
            for (int x=0;x<numbers[i].length;x++){
                sum+=numbers[i][x];
              if (numbers[i][x]<min){min=numbers[i][x];}
                if (numbers[i][x]>max){max =numbers[i][x];}

            }
        }

        System.out.println("Total Deliveries:"+sum);
    System.out.println("Max Deliveries:"+max);
        System.out.println("Min Deliveries:"+min);



    }
}