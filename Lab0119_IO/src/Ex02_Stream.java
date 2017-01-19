import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class Ex02_Stream {

	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc=null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		byte[] temp = new byte[10];
		System.out.println("temp before : " + Arrays.toString(temp));
		
		input.read(temp, 0, temp.length); //temp write
		System.out.println("temp after : " + Arrays.toString(temp));
		
		output.write(temp, 5, 5); //temp read
		outSrc = output.toByteArray();
		System.out.println("ourSrc : " + Arrays.toString(outSrc));
	}

}





