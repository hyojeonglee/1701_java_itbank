
public class Ex0118_InnerClass6_Anony {
	Object iv = new Object(){ void method(){} };             // �͸�Ŭ���� 
    static Object cv = new Object(){ void method(){} };       // �͸�Ŭ���� 

    void myMethod() { 
          Object lv = new Object(){ void method(){} };       // �͸�Ŭ���� 
    }
}

// ������ awt_frame! innerclass�� ����