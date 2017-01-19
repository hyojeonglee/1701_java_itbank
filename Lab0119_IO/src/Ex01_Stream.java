import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

//Stream : ������� (input , output) ����(Byte)
//Byte ������ > byte[]

//�߻�Ŭ����
//input  , output
//����
//���
//File : File , File
//Memory : byteArray  , byteArray

//���� (����) > Buffer
//I/O�۾��� DISK �������
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
		
		
		//���İ��� ����
		int data =0;
		while((data=input.read())!= -1 ){
			//input.read() > ���������� next
			//System.out.println(data);
			output.write(data); //
		}
		outSrc = output.toByteArray();
		System.out.println("ourSrc : " + Arrays.toString(outSrc));
		
		
	}

}
