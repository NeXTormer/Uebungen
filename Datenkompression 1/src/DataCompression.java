import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataCompression {

	Scanner sc = new Scanner(System.in);
	String text;
	byte[] uncompressed;
	byte[] uncompressedShorter;
	String[] binaryUncompressed;
	String compressedSerial;
	
	FileReader fr;
	BufferedReader br;
	PrintWriter pr;

	public static void main(String[] args) throws IOException {
		new DataCompression().start();
	}

	public void start() throws IOException {
		fr = new FileReader("text.txt");
		br = new BufferedReader(fr);
		pr = new PrintWriter(new FileWriter("text2.txt", true));
		String ev;
		
		if(sc.nextInt() == 1) {
			try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
			    StringBuilder sb = new StringBuilder();
			    String line = br.readLine();

			    while (line != null) {
			        sb.append(line);
			        sb.append(System.lineSeparator());
			        line = br.readLine();
			    }
			    text = sb.toString();
			}
	
		} else {
			System.out.print("Text Eingeben: ");
			text = sc.next();
			
		}
				
		
		
		uncompressed = text.getBytes();
		//System.out.println(Arrays.toString(uncompressed));
		binaryUncompressed = new String[uncompressed.length];
		uncompressedShorter = new byte[uncompressed.length];

		for (int i = 0; i < uncompressed.length; i++) {
			if (uncompressed[i] == 32) {
				uncompressedShorter[i] = 0;
				continue;
			}
			uncompressedShorter[i] = (byte) (uncompressed[i] - 64);
		}
		for (int i = 0; i < uncompressed.length; i++) {
			binaryUncompressed[i] = Integer.toBinaryString((int) uncompressedShorter[i]);
		}

		//System.out.println(Arrays.toString(binaryUncompressed));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < binaryUncompressed.length; i++) {
			sb.append(binaryUncompressed[i].toString());
		}
		compressedSerial = sb.toString();

		System.out.println(compressedSerial);
		FileWriter flw = new FileWriter(new File("text2"));
		flw.write(compressedSerial);
		pr.print(compressedSerial);
		pr.flush();
		
		
	}

}
