public class GNodePeso {
		int flujo;
		int capacidad;
		int coste;
		GNode nodo = null;
		
		/**
		 * Creadora
		 * @param f
		 * @param ca
		 * @param co
		 * @param nCiudad
		 */
		public GNodePeso(int f, int ca, int co, String nCiudad) {
			flujo = f;
			capacidad = ca;
			coste = co;
			nodo = new GNode(nCiudad);
		}
		
		/**
		 * Consultora de la capacidad del nodo
		 * @return
		 */
		public int consultarCapacidad() {
			return capacidad;
		}
		
		/**
		 * Consultora del flujo 
		 * @return
		 */
		public int consultarFlujo() {
			return flujo;
		}
		
		/**
		 * Modificadora del flujo 
		 * @param nuevoFlujo
		 */
		public void modificarFlujo(int nuevoFlujo) {
			flujo = nuevoFlujo;
		}
		
		/**
		 * Consultora del coste 
		 * @return
		 */
		public int consultarCoste() {
			return coste;
		}
		
		/**
		 * Devuelve el nodo 
		 * @return
		 */
		public GNode consultarNodo() {
			return nodo;
		}
		
		/**
		 * Modificadora del nodo
		 * @param nuevoNodo
		 */
		public void modificarNodo(GNode nuevoNodo) {
			nodo = nuevoNodo;
		}
}