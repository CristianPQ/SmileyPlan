//package Dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Pinto
 */

public class Coordenadas {
	
	private int x;	//Posicion segun el eje horizontal
	private int y;	//Posicion segun el eje vertical
	
	/**
	 * Constructor Coordenadas
	 * @param x referencia sobre el eje horizontal
	 * @param y referencia sobre el eje vertical 
	 */
	public Coordenadas(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * Getter del elemento x
	 * @return posicion sobre el eje horizontal
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter del elemento x
	 * @param x referencia sobre el eje horizontal
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter del elemento y
	 * @return posicion sobre el eje vertical
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter del elemento y
	 * @param y referencia sobre el eje horizontal
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}