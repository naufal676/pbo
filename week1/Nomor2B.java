package week1;

import java.util.Scanner;

public class Nomor2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
        int a, t;
        double luas;
        
        System.out.print("Masukan Alas : ");
        a=input.nextInt();
        System.out.print("Masukan Tinggi : ");
        t=input.nextInt();
        
        luas=0.5*a*t;
        System.out.println("Luas Segitiga : "+luas);
	}

}
