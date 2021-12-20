//Demonstrate PrinteWriter
//Because no advantage is gained by using a PrintWriter, you should use System.out.print/println
import java.io.*;

public class PrinterWriterDemo {
	public static void main(String args[]){
		PrintWriter pw = new PrintWriter(System.out, true);

		pw.println("This is a string");
		int i = -7;
		pw.println(i);
		double d = 4.5e-7;
		pw.println(d);
	}
}