import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

//Stream : 연결통로 (input , output) 빨대(Byte)
//Byte 데이터 > byte[]

//추상클래스
//input  , output
//구현
//대상
//File : File , File
//Memory : byteArray  , byteArray

//보조 (파일) > Buffer
//I/O작업시 DISK 성능향상
public class Ex01_Stream {
	public static void main(String[] args) {
		//byte(-128 ~0~127)
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		//[0] => 0
		//[9] => 9
		//length => 10
		
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;//read
		ByteArrayOutputStream output = null; //write
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();//
		
		
		//공식같은 로직
		int data =0;
		while((data=input.read())!= -1 ){
			//input.read() > 내부적으로 next
			//System.out.println(data);
			output.write(data); //
		}
		outSrc = output.toByteArray();
		System.out.println("ourSrc : " + Arrays.toString(outSrc));
		
		
	}

}
