package praktikum4;

import java.util.Scanner;

public class MotherboardAksi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Motherboard.USB usb = new Motherboard.USB();
		usb.usb2 = input.nextInt();
		usb.usb3 = input.nextInt();
		System.out.println("Total Ports = " +usb.getTotalPorts());
	}

}
