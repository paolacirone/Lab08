package it.polito.tdp.extflightdelays.model;


public class Rotta {

	Airport p; 
	Airport a; 
	double peso;
	
	public Rotta(Airport p, Airport a, double peso) {
		this.p = p;
		this.a = a;
		this.peso = peso;
	}
	
	public Airport getP() {
		return p;
	}
	public void setP(Airport p) {
		this.p = p;
	}
	public Airport getA() {
		return a;
	}
	public void setA(Airport a) {
		this.a = a;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return p.getAirportName()+ "  " + a.getAirportName() + "   " + peso;
	}

	
	


	
	
	

	
}
