package com.cursogetafe.jpa.ejemplo04pkcompuesta;

public class Dni {

	private int nroDoc;
	private char letraDoc;
	
	public Dni() {}
	
	public Dni(int nroDoc, char letraDoc) {
		super();
		this.nroDoc = nroDoc;
		this.letraDoc = letraDoc;
	}

	public int getNroDoc() {
		return nroDoc;
	}

	public void setNroDoc(int nroDoc) {
		this.nroDoc = nroDoc;
	}

	public char getLetraDoc() {
		return letraDoc;
	}

	public void setLetraDoc(char letraDoc) {
		this.letraDoc = letraDoc;
	}

	@Override
	public String toString() {
		return "Dni [nroDoc=" + nroDoc + ", letraDoc=" + letraDoc + "]";
	}
	
	
}
