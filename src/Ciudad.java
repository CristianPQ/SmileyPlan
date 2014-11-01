
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

	//Getter nombre
	public String getNombre() {
		return nombre;
	}

	//Setter nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Getter coordenadas
	public Coordenadas getCoord() {
		return coord;
	}

	//Setter coord
	public void setCoord(Coordenadas coord) {
		this.coord = coord;
	}
	

}
