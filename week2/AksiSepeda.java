package week2;

public class AksiSepeda {
	public static void main (String[] args ) {
		//membuat objek 
		Sepeda sepedaGunung = new Sepeda();
		
		//mengakses atribut dan method
		int jumlahRoda = sepedaGunung.jumlahRoda;
		int gearSepeda = sepedaGunung.gear;
		String jenisSepeda = sepedaGunung.jenis;
		String merkSepeda = sepedaGunung.merk;
		
		System.out.println(jenisSepeda+" bermerk "+merkSepeda+" memiliki jumlah roda "+jumlahRoda);
		System.out.println("Jumlah Gear "+gearSepeda);
		sepedaGunung.ngerem();
	}
}


