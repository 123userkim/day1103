package com.sist.inner;

public class A {

	public String title="Hello";
	
	public void pro() {
		System.out.println("AŬ������ pro�Դϴ�.");
		//System.out.println(year);  //outclass �� inner �� �����ο� ������ �Ұ�����
		//�����Ϸ��� ��ü�� ���� �ʼ�
		
		B ob = new B();
		System.out.println(ob.year);
		ob.test();
	}
	
			class B{
						//inner class
				public int year=2021;
				public void test() {
					System.out.println("B�� test�Դϴ�.");
					System.out.println(title); //Inner Class �� outter�� �����ο� ������ ������
				}
			}
			
		public static void main(String[] args) {
			A a = new A();
			a.pro();
			
	 
		}
	
	
}
