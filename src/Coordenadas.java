
/*
 * Clase Coordenadas
 * 
 * Necessaria para marcar una posicion para cada ciudad dentro del mapa
 * 
 */
public class Coordenadas {
	
	private int x;	//Posicion segun el eje horizontal
	private int y;	//Posicion segun el eje vertical
	
	//Constructor Coordenadas
	public Coordenadas(int x, int y){
		setCoordenadas(x, y);
	}
	
	//GetterX
	public int getX() {
		return x;
	}

	//SetterX
	public void setX(int x) {
		this.x = x;
	}

	//GetterY
	public int getY() {
		return y;
	}

	//SetterY
	private void setY(int y) {
		this.y = y;
	}
	
	//Setter de Coordenadas con X e Y
	public void setCoordenadas(int x, int y){
		this.setX(x);
		this.setY(y);
	}
}