package week1;

import java.util.Scanner;

public class Nomor2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double k, r, phi = 3.14;
	    Scanner scan = new Scanner(System.in);
	    System.out.print("Masukkan panjang jari-jari lingkaran: ");
	    r = scan.nextDouble();
	    k = 2 * phi * r;
	    System.out.println("Keliling Lingkaran adalah " + String.format("%.2f", k));
	}

}
