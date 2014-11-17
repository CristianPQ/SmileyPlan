
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


	/**
	 * Consultor del elemento y
	 * @return posicion sobre el eje vertical
	 */
	public int consultarY() {
		return y;
	}

	/**
	 * Devuelve la distancia de las coordenadas que pasamos por parametro
	 * @param coordD
	 * @return
	 */
	public int distancia(Coordenadas coordD) {
		int cX = coordD.consultarX();
		int cY = coordD.consultarY();
		double dif = Math.sqrt(Math.pow((cX-x),2) + Math.pow((cY-y),2));
		int dif2 = (int) dif;
		return dif2;
	}

}