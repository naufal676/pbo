package praktikum4;

public class CPUAksi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU cpu = new CPU();
	    CPU.Processor processor = cpu.new Processor();
	    CPU.RAM ram = cpu.new RAM();
	    
	    System.out.println("Processor Cache = " + processor.getCache());
	    System.out.println("Ram Clock speed = " + ram.getClockSpeed());
	}

}
