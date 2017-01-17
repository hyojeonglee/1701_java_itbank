package kr.or.bank;

//Grouping! Tank, Marine, Dropship
// http://gangzzang.tistory.com/entry/Java-%EC%B6%94%EC%83%81%ED%81%B4%EB%9E%98%EC%8A%A4abstract-class

abstract class Unit {
	int x, y;
	
	abstract void move(int x, int y);
	
	void stop() {
	} // stop : 현재 위치에 정지
} // Unit

class Marine extends Unit {     
	void move(int x, int y) {
	} // move : 지정된 위치로 이동
  
	void stimPack() {
		
	} // stimPack : 스팀팩 사용
} // Marine : 마린

class Tank extends Unit {
	void move(int x, int y) {
	} // move : 지정된 위치로 이동
  
	void mode() {
	} // mode : 모드 변경
} // Tank : 시즈탱크

class Dropship extends Unit {
	void move(int x, int y) {
	} // move : 지정된 위치로 이동
  
	void load() {
	} // load : 선택 대상을 태운다
  
	void unload() {
	} // load : 선택 대상을 내린다
} // Dropship : 수송선

public class Ex0117_Abstract2 {
	public static void main(String[] args) {
		//문제. (다형성)
		//Tank, Marine, DropShip
		//3개의 Unit을 같은 좌표로 이동하게 하세요.
		Unit[] unitArray = {new Tank(), new Marine(), new Dropship()};
		for(Unit unit : unitArray) {
			unit.move(20, 80);
		}
	}
}