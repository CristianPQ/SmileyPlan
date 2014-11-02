
/*
 * Clase Ciudad
*/
public class Ciudad {
	
	private String nombre; 		//Identificador
	private Coordenadas coord;	//Señala la ubicacion
	
	//Constructor Ciudad
	public Ciudad(String nombre, Coordenadas coord){
		setNombre(nombre);
		setCoord(coord);
	}

	/*
	 * Getter nombre
	 * Consultar nombre de Ciudad
	 */
	public String getNombre() {
		return nombre;
	}

	//Setter nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * Getter coordenadas
	 * Consultar Coordenadas de Ciudad
	 */
	public Coordenadas getCoord() {
		return coord;
	}

	/*
	 * Setter coord
	 * Mover ciudad con nuevas coordenadas
	 */
	public void setCoord(Coordenadas coord) {
		this.coord = coord;
	}
	
	/*
	 * Mover Ciudad un espacio
	 * Mover ciudad a partir de una distancia de movimiento.
	 */
	public void mover(int x, int y) {
		x = x + this.coord.getX();
		y = y + this.coord.getY();
		this.coord = new Coordenadas(x, y);
	}
	

}



















