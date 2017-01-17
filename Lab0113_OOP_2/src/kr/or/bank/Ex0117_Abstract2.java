package kr.or.bank;

//Grouping! Tank, Marine, Dropship
// http://gangzzang.tistory.com/entry/Java-%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4abstract-class

abstract class Unit {
	int x, y;
	
	abstract void move(int x, int y);
	
	void stop() {
	} // stop : ���� ��ġ�� ����
} // Unit

class Marine extends Unit {     
	void move(int x, int y) {
	} // move : ������ ��ġ�� �̵�
  
	void stimPack() {
		
	} // stimPack : ������ ���
} // Marine : ����

class Tank extends Unit {
	void move(int x, int y) {
	} // move : ������ ��ġ�� �̵�
  
	void mode() {
	} // mode : ��� ����
} // Tank : ������ũ

class Dropship extends Unit {
	void move(int x, int y) {
	} // move : ������ ��ġ�� �̵�
  
	void load() {
	} // load : ���� ����� �¿��
  
	void unload() {
	} // load : ���� ����� ������
} // Dropship : ���ۼ�

public class Ex0117_Abstract2 {
	public static void main(String[] args) {
		//����. (������)
		//Tank, Marine, DropShip
		//3���� Unit�� ���� ��ǥ�� �̵��ϰ� �ϼ���.
		Unit[] unitArray = {new Tank(), new Marine(), new Dropship()};
		for(Unit unit : unitArray) {
			unit.move(20, 80);
		}
	}
}