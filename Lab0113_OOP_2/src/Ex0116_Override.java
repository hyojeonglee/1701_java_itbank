class Point2 extends Object {
	int x = 20;
	int y = 30;
	
	String getPosition() {
		return "x : " + this.x + " y : " + this.y;
	}
}

class Point3D extends Point2 {
	int z = 40;

	@Override
	String getPosition() {
		// TODO Auto-generated method stub
		return "x : " + this.x + " y : " + this.y + " z : " + this.z;
	}
}
public class Ex0116_Override {

}
