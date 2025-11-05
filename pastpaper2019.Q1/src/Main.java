//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
String []vehicletype={"SUV","COUPE","SEDAN","VAN"};
int [][] number={{25,15,35},{25,55,35},{11,20,45},{17,27,25}};

System.out.println("*****************************");
        System.out.println("VEHCILE SALES REPORT");
        System.out.println("*****************************");
        System.out.printf("%15s%11s%11s\n","JAN","FEB","MAR");
for (int i=0;i< vehicletype.length;i++){
    System.out.printf("-%5s%10d%8d%9d\n",vehicletype[i],number[i][0],number[i][1],number[i][2]);
}
        System.out.println("*****************************");
        System.out.println("VEHCILE TOTAL SALES ");
        System.out.println("*****************************");
int[] total=new int[vehicletype.length];
String car = "";

for (int i=0; i< vehicletype.length;i++){
    total[i]=number[i][0]+number[i][1]+number[i][2];
    if (total[i]<100){
        System.out.println("(Silver Star)");
    } else if (total[i]>100) {
        System.out.println("(Gold Star)");

    }
    car= vehicletype[i];
    System.out.printf("%-10s%10d\n",vehicletype[i],total[i]);

}
System.out.println("*****************************");
    }
}