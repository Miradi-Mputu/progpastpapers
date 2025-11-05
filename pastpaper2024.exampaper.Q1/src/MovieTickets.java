public class MovieTickets implements IMovieTickets{
public int[][] movietickets= {{3000,1500,1700},{3500,1200,1600}};
public String[] movies={"Napoleon","Oppenhiemer"};

public void printSales(){
    System.out.println("MOVIE TICKET SALES REPORT - 2024");
    System.out.println("------------------------------------");
    System.out.printf("%25s%10s%12s\n","JAN","FEB","MAR");
    for (int i =0;i< movies.length;i++){
        System.out.printf("%-15s%10d%10d%12d\n",movies[i],movietickets[i][0],movietickets[i][1],movietickets[i][2]," \n");
    }

    String maxMovie ="";
    int mostwatched=0;
    int[] total = new int[movies.length];
    for (int i =0;i<movies.length;i++){
        total[i]=movietickets[i][0]+movietickets[i][1]+movietickets[i][2];
        if (total[i]>mostwatched){
            mostwatched=total[i];
        }
        maxMovie=movies[i];
    }

    for (int i=0;i<movies.length;i++){
        System.out.printf("%-10s%5s%10d\n","The total movie sales for ",movies[i],total[i]);
    }
    System.out.println("\nTop performing movie:"+maxMovie);
}

    @Override
    public int TotalMovieSales(int[] movieTicketSales) {
        return 0;
    }

    @Override
    public String TopMovie(String[] movies, int[] totalSales) {
        return "";
    }
}
