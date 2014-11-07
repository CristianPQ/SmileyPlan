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
	 * @param coordX referencia sobre el eje horizontal
	 * @param coordY referencia sobre el eje vertical 
	 */
	public Coordenadas(int coordX, int coordY){
		x = coordX;
		y = coordY;
	}
	
	/**
	 * Consultor del elemento x
	 * @return posicion sobre el eje horizontal
	 */
	public int consultarX() {
		return x;
	}

	/*
	 * Modificador del elemento x
	 * @param coordX referencia sobre el eje horizontal
	 *
	public void modificarX(int coordX) {
		x = coordX;
	}*/

	/**
	 * Consultor del elemento y
	 * @return posicion sobre el eje vertical
	 */
	public int consultarY() {
		return y;
	}
	
	/*
	 * Setter del elemento y
	 * @param coordY referencia sobre el eje horizontal
	 *
	public void modificarY(int coordY) {
		x = coordY;
	}*/
}