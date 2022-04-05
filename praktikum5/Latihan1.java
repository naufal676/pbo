package praktikum5;

import java.util.Scanner;

public class Latihan1 {

	public static void main (String args[]){
		
		    int array[], i, n;
		    array = new int[6];
		    float rata, total=0;
		    Scanner scan = new Scanner(System.in);
		    System.out.print("Masukkan jumlah data : ");
		    n = scan.nextInt();
		    for(i = 1; i <= n; i++){
		      System.out.print("Masukan angka ke-"+ i +" : ");
		      array[i] = scan.nextInt();
		    }
		    
		    System.out.println("isi array");
	        for(i=1;i<array.length;i++)
	        {
	          System.out.println(array[i]);
		      total = total + array[i];
	        }
		    
		    System.out.println("Jumlah angka : " + total);
		  }
}
