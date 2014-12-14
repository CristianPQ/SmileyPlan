
public class Arista{

		private int verticeDestino;
		private int flujo;
		private int capacidad;
		private int coste;
		
		public boolean equals(Object obj) {
			if(this == obj) return true;
			if(obj == null) return false;
			if(getClass() != obj.getClass()) return false;
			Arista c = (Arista) obj;
			if (verticeDestino == c.consultarVerticeDestino()) return true;
			return false;

		}
		
		/**
		 * Creadora arista
		 * @param targetVertex
		 * @param flow
		 * @param capacity
		 * @param cost
		 */
		public Arista(int targetVertex, int flow, int capacity, int cost){
			verticeDestino = targetVertex;
			flujo = flow;
			capacidad = capacity;
			coste = cost;
		}
		
		/**
		 * Devuelve vertice destino 
		 * @return
		 */
		public int consultarVerticeDestino(){
			return verticeDestino;
		}
		
		/**
		 * consultar vertice destino 
		 * @return
		 */
		public String consultarVerticeDestinoString(){
			
			return Integer.toString(verticeDestino);
		}
		/**
		 * Modificadora vertice destino
		 * @param targetVertex
		 */
		public void modificarVerticeDestino(int targetVertex){
			verticeDestino = targetVertex;
		}
		
		/**
		 * Consultora flujo
		 * @return
		 */
		public int consultarFlujo() {
			return flujo;
		}
		
		/**
		 * Modificadora flujo
		 * @param flow
		 */
		public void modificarFlujo(int flow) {
			flujo = flow;
		}
		/**
		 * Consultora capacidad
		 * @return
		 */
		public int consultarCapacidad() {
			return capacidad;
		}
		/** 
		 * Modificadora capacidad
		 * @param capacity
		 */
		public void modificarCapacidad(int capacity) {
			capacidad = capacity;
		}

		public int consultarCoste() {
			return coste;
		}

		public void modificarCoste(int cost) {
			coste = cost;
			}
		
}