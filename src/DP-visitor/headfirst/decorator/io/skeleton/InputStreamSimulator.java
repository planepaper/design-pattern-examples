package headfirst.decorator.io.skeleton;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamSimulator {

	public static void main(String[] args) {
		try {
			int c;
			Scanner scanInput = new Scanner(System.in);


			// The following code block should work after your extension			//
			// 1 using more decorators :

			String exampleString = "A12ZX a#";
			InputStream in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));

			System.out.println("Test String : " + exampleString);
			System.out.println("Lower + Shift offest 1 case");
			InputStream inputStream = new ShiftInputStream(new LowerCaseInputStream(new BufferedInputStream(in)), 1);
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			System.out.println();
			System.out.println();

			exampleString = "A12ZX a#";
			in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));
			System.out.println("Lower + Shift offest -4 case");
			// 2 even more !:
			inputStream = new ShiftInputStream(new ShiftInputStream(new LowerCaseInputStream(new BufferedInputStream(in))),-4);
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			System.out.println();
			System.out.println();

			exampleString = "A12ZX a#";
			in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));
			System.out.println("Lower + Shift offest -1 case");
			inputStream = new ShiftInputStream(in, -1) ;
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			System.out.println();
			System.out.println();

			exampleString = "A12ZX a#";
			in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));
			System.out.println("Lower + Shift offest 27 case");
			inputStream = new ShiftInputStream(in, 27) ;
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			System.out.println();
			System.out.println();

			exampleString = "A12ZX a#";
			in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));
			System.out.println("Lower + Shift offest -27 case");
			inputStream = new ShiftInputStream(in, -27) ;
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			exampleString = "A12ZX a#";
			in =  new ByteArrayInputStream(exampleString.getBytes("UTF-8"));
			System.out.println("Lower + Shift offest -1 -3 case");
			inputStream = new ShiftInputStream(new ShiftInputStream(new LowerCaseInputStream(new BufferedInputStream(in)), -1),-3);
			while ( (c = inputStream.read()) >= 0)
				System.out.print((char)c);

			System.out.println();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
