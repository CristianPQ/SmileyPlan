public class Arista{
		private int verticeDestino;
		private int flujo;
		private int capacidad;
		private int coste;
		
		public Arista(int targetVertex, int flow, int capacity, int cost){
			
		}
		
		public int consultarVerticeDestino(){
			return verticeDestino;
		}

		public void modificarVerticeDestino(int targetVertex){
			verticeDestino = targetVertex;
		}

		public int consultarFlujo() {
			return flujo;
		}

		public void modificarFlujo(int flow) {
			flujo = flow;
		}

		public int consultarCapacidad() {
			return capacidad;
		}

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