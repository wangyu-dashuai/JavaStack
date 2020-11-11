package stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��ArrayStack �Ƿ���ȷ
		//�ȴ���һ��ArrayStack����->��ʾջ
		ArrayStack stack = new ArrayStack(4);
		String key = " ";
		boolean loop = true; //�����Ƿ��Ƴ��˵�
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show:��ʾ��ʾջ");
			System.out.println("exit:��ʾ�˳�ջ");
			System.out.println("push:��ʾ������ݵ�ջ");
			System.out.println("pop:��ʾ�����ݴ�ջ��ȡ��");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push": //��ջ
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop": //��ջ
				try {
					int res = stack.pop();
					System.out.printf("��ջ��������%d\n",res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close(); //����һ���ļ���,���������Դ��й¶
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
	}

}

//����һ��ArrayStack ��ʾջ
class ArrayStack{
	private int maxSize; //ջ�Ĵ�С
	private int[] stack; //����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1; //top��ʾջ������ʼ��Ϊ-1
	
	//������
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize -1;
	}
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	//��ջ-push
	public void push(int value) {
		//���ж�ջ�Ƿ���
		if(isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	//��ջ-pop,��ջ�������ݷ���
	public int pop() {
		//���ж�ջ�Ƿ��
		if(isEmpty()) {
			//�׳��쳣
			throw new RuntimeException("ջ�գ�û������");
		}
		int value = stack[top];
		top--;
		return value;
	}
	//��ʾջ�����[����ջ],��Ҫ��ջ����ʼ��ʾ����
	public void list(){
		//�ж�ջ�Ƿ�Ϊ��
		if(isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		for(int i = top;i >= 0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}