
public class Ex0118_InnerClass6_Anony {
	Object iv = new Object(){ void method(){} };             // 익명클래스 
    static Object cv = new Object(){ void method(){} };       // 익명클래스 

    void myMethod() { 
          Object lv = new Object(){ void method(){} };       // 익명클래스 
    }
}

// 다음은 awt_frame! innerclass의 응용