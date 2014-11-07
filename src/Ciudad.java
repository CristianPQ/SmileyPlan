
/*
 * Clase Ciudad
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cristian Pinto
 */
public class Ciudad {
	
	private String nombre; 		//Identificador
	private Coordenadas coord;	//Senala la ubicacion
	
	//Constructor Ciudad
	public Ciudad(String nombreCiudad, Coordenadas coordCiudad){
		nombre = nombreCiudad;
		coord = coordCiudad;
	}

	/*
	 * Getter nombre
	 * Consultar nombre de Ciudad
	 */
	public String consultarNombre() {
		return nombre;
	}

	/*
	 * Getter coordenadas
	 * Consultar Coordenadas de Ciudad
	 */
	public Coordenadas consultarCoordenadas() {
		return coord;
	}

	/*
	 * Setter coord
	 * Mover ciudad con nuevas coordenadas
	 */
	public void modificarCoordenadas(Coordenadas coordCiudad) {
		coord = coordCiudad;
	}
	
	/*
	 * Mover Ciudad un espacio
	 * Mover ciudad a partir de una distancia de movimiento.
	 */
	public void mover(int x, int y) {
		x = x + coord.consultarX();
		y = y + coord.consultarY();
		coord = new Coordenadas(x, y);
	}
	

}