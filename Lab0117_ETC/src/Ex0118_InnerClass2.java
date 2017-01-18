
public class Ex0118_InnerClass2 {
	class InstanceInner {} 
    static class StaticInner {} 

    InstanceInner iv = new InstanceInner(); // �ν��Ͻ� ��������� ���� ���� ������ �����ϴ�. 
    static StaticInner cv = new StaticInner();    // static ��������� ���� ���� ������ �����ϴ�. 

    static void staticMethod() { 
//     static����� �ν��Ͻ� ����� ���� ������ �� ����. 
//           InstanceInner obj1 = new InstanceInner();       
          StaticInner obj2 = new StaticInner(); 

//     ���� �����Ϸ��� �Ʒ��� ���� ��ü�� �����ؾ��Ѵ�. 
//     �ν��Ͻ� ����Ŭ������ �ܺ�Ŭ������ ���� �����ؾ߸� ������ �� �ִ�. 
          Ex0118_InnerClass2 outer = new Ex0118_InnerClass2(); 
          InstanceInner obj1 = outer.new InstanceInner(); 
    } 

    void instanceMethod() { 
//�ν��Ͻ� �޼��忡���� �ν��Ͻ������ static��� ��� ���� �����ϴ�. 
          InstanceInner obj1 = new InstanceInner(); 
          StaticInner obj2 = new StaticInner(); 
//     �޼��� ���� ���������� ����� ����Ŭ������ �ܺο��� ������ �� ����. 
//           LocalInner lv = new LocalInner(); 
    } 

    void myMethod() { 
          class LocalInner {} 
          LocalInner lv = new LocalInner(); 
    } 
}
