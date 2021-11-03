package com.sist.inner;

public class A {

	public String title="Hello";
	
	public void pro() {
		System.out.println("A클래스의 pro입니다.");
		//System.out.println(year);  //outclass 는 inner 에 자유로운 접근이 불가능함
		//접근하려면 객체를 생성 필수
		
		B ob = new B();
		System.out.println(ob.year);
		ob.test();
	}
	
			class B{
						//inner class
				public int year=2021;
				public void test() {
					System.out.println("B의 test입니다.");
					System.out.println(title); //Inner Class 는 outter에 자유로운 접근이 가능함
				}
			}
			
		public static void main(String[] args) {
			A a = new A();
			a.pro();
			
	 
		}
	
	
}
