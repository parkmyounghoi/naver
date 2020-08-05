package com.munggu.org;

public class TestSigleTon {

	private int a;
	private int b;
	private int c;
	private String d;
	private A aa;
	
	public TestSigleTon(A aa) {
		this.aa = aa;
	}
	
	public A getAa() {
		return aa;
	}
	public void setAa(A aa) {
		this.aa = aa;
	}
	// alt shift s r
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	
	
	
	
	
	
	
}
