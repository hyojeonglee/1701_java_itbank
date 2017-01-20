package Quiz;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.io.*;
import Quiz.BMI;

public class BMICheck {
   static HashMap<Integer, BMI> map = new  HashMap<Integer,BMI>();
   static int count = 1;
   static Scanner scan = new Scanner(System.in);
   
   public static void main(String[] args){
      BMICheck bc = new BMICheck();
      while(true){
         System.out.print("�񸸵� �����մϴ�!!");
         System.out.println("1. �߰�    2. ����    3. ���      4. ����     5. �ε�     6. ����\n:");
         
         switch (scan.nextInt()){
         case 1:
            bc.add();
            break;
         case 2:
            bc.delete();
            break;
         case 3:
            bc.print();
            break;
         case 4:
            bc.save();
            break;
         case 5:
            bc.load();
            break;
         case 6:
            bc.exit();
            break;
            
         }
      }
   }
   
	private void save() {
		// TODO Auto-generated method stub
		String fileName = "BMIData.ser";
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
//			// Ʋ�� ��! ����!
//			Set<Integer> set = map.keySet();
//			for(Integer number : set) {
//				oos.writeObject(map.get(number));
//			}
			oos.writeObject(map);
			oos.close();
			bos.close();
			fos.close();
		} catch(Exception e) {
		}
	}
	
	private void exit(){
		System.out.println("�ý�������");
		System.exit(0);
		scan.close();
	}
	private void print(){
		Set<Integer> set = map.keySet();
		System.out.println("��ȣ\tŰ\t������\t���\t����");
		for(Integer number : set) {
			double length = map.get(number).getLength();
			double weight = map.get(number).getWeight();
			double result = map.get(number).getResult();
			String you = map.get(number).getYou();
			
			System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
		}
	}
	private void delete(){
		System.out.print("���� ��ȣ�� �Է��ϼ���. : ");
		int number = scan.nextInt();
		if(map.containsKey(number))
			map.remove(number);
		else
			System.out.println("�ش��ϴ� ����� �����.");
	}
	private void add(){
		BMI bmi = new BMI();
		map.put(count++, bmi.input(bmi));
	}
	private void load() {
		String fileName = "BMIData.ser";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fileName);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			
			map = (HashMap)ois.readObject();
			Set<Integer> set = map.keySet();
			System.out.println("��ȣ\tŰ\t������\t���\t����");
			for(Integer number : set) {
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();
				
				System.out.printf("%s\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			
		} catch(Exception e) {
			System.out.println("�ҷ����� �� �����߽��ϴ�.");
			System.out.println(e.getMessage());
		} finally {
			try {
				ois.close();
				bis.close();
				fis.close();
			} catch(Exception e) {
			}
		}
	}
}
