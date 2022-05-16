package praktikum7;

import java.util.Scanner;

public class Student extends Person{
	
	int SPP,SKS,Modul;
	String nim,name,address;
	
	Scanner sc = new Scanner (System.in);
	
	public hitungPembayaran() { 
		
	System.out.println("Masukkan SPP : ");
	SPP = sc.nextInt();
	System.out.println("Masukkan SKS : ");
	SKS = sc.nextInt();
	System.out.println("Masukkan Modul : ");
	Modul = sc.nextInt();
	}
	
	
	public Student() {
		System.out.println("Masukkan Nama : ");
		name = sc.nextLine();
		System.out.println("Masukkan NIM : ");
		nim = sc.nextLine();
		System.out.println("Masukkan Alamat : ");
		address = sc.nextLine();
	}
	
	public String getNim()
	{
		return nim;
	}
	
	@Override
	public void identity()
	{
		System.out.println("NIM: "+getNim());
		System.out.println("Nama: "+super.name);
		System.out.println("Alamat: "+super.address);
	}
	public void job()
	{
		System.out.println("Pekerjaan : Mahasiswa");
	}
	public String getName() {
		System.out.println("Student name: "+name);
		return name;
	}
		
}