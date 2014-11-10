public class GNodePeso {
		int flujo;
		int capacidad;
		int coste;
		GNode nodo = null;
		
		public GNodePeso(int f, int ca, int co, String nCiudad) {
			flujo = f;
			capacidad = ca;
			coste = co;
			nodo = new GNode(nCiudad);
		}
		
		public int consultarCapacidad() {
			return capacidad;
		}
		
		public int consultarFlujo() {
			return flujo;
		}
		
		public void modificarFlujo(int nuevoFlujo) {
			flujo = nuevoFlujo;
		}
		
		public int consultarCoste() {
			return coste;
		}
		
}