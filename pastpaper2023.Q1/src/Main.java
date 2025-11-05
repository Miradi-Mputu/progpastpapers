//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
   String []estateagent ={"Joa Bloggs","Jane Doe"};
   String [][]sales={{"R800 000","R1 500 000","R2 000 000"},{"R700 000","R1 200 000","R1 600 000"}};
int[][] numbers={{800000,1500000,2000000},{700000,1200000,1600000}};

   System.out.println("ESTATE AGENTS SALES REPORT");
        System.out.printf("%20s%15s%19s\n","JAN","FEB","MAR");
        System.out.println("---------------------------------------------------------");

        for (int i =0;i< estateagent.length;i++){
            System.out.printf("%-10s%11s%15s%19s\n",estateagent[i],sales[i][0],sales[i][1],sales[i][2]);
        }



        int [] totalJD = new int[estateagent.length];
int highest=0; String bestagent = "";
int total;double commissionJB;

        for (int i=0;i< estateagent.length;i++){
         totalJD[i]=numbers[i][0]+numbers[i][1]+numbers[i][2];
            total=totalJD[i];
            System.out.println("\n Total property sales for "+estateagent[i]+"= R"+total);


        }
        for (int i=0;i< estateagent.length;i++){
            commissionJB=(numbers[i][0]+numbers[i][1]+numbers[i][2])*0.2;
            System.out.println("\n Total commission for "+estateagent[i]+"= R"+commissionJB);


        }
        for (int i=0;i< estateagent.length;i++){
            if (totalJD[i]>highest){
                highest=totalJD[i];
            }
            bestagent=estateagent[i]; 
        }
        System.out.println("Top performing estate agent "+bestagent);
    }
}