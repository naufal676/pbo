package praktikum7;

public class InheritMain {
	
	public static void main(String[] args) {
//		Student mahasiswa  = new Student();
//		mahasiswa.identity();
//		mahasiswa.job();
		
		Person ref;
		Student studentObject = new Student();
		Student hitungPembayaranObject = new hitungPembayaran();
		Employee employeeObject = new Employee();
		
		ref = studentObject;
		ref = hitungPembayaranObject;
//		
		String temp = ref.getName();
		System.out.println(temp);
		
		ref = employeeObject;
		
		String temp1 = ref.getName();
		System.out.println(temp);
	}

}