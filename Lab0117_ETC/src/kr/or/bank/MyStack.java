package kr.or.bank;

public class MyStack {
	private int maxsize;
	private Object[] stackArr;
	private int top;
	
	public MyStack(int maxsize) {
		this.maxsize = maxsize;
		this.stackArr = new Object[this.maxsize];
		this.top = -1;
	}
	
	public boolean empty() {
		return (this.top == -1);
	}
	
	public boolean full() {
		return (this.top == this.maxsize-1);
	}
	
	public void push(Object i) {
		if(full())
			throw new ArrayIndexOutOfBoundsException((this.top+1) + ">=" + this.maxsize);
		
		stackArr[++top] = i;
	}
	
	public Object pop() {
		if(empty())
			throw new ArrayIndexOutOfBoundsException(this.top);
        
        return stackArr[this.top--];
	}
}
