package com.shubham.employeeDirectory.service;

public class child extends Temp {
	@Override
	public  void method() {
		System.out.println("child");
	}

	public static void main(String[] args) {
		Temp p = new child();
		p.method();
	}
}
