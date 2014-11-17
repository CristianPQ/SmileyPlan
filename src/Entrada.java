import java.util.*;

public class Entrada {
		private GrafoAntiguo g;
		private int source;
		private int sink;
		private int numeroAgentesSyT;
		
		/**
		 * Creadora de la entrada
		 * @param G
		 * @param s
		 * @param t
		 * @param numAgentes
		 * @throws Exception
		 */
		public Entrada(GrafoAntiguo G, int s, int t, int numAgentes) throws Exception{
				g = G;
				source = s;
				sink = t;
				numeroAgentesSyT = numAgentes;
		}
		
		/**
		 * Devuelve el grafo 
		 * @return
		 */
		public GrafoAntiguo consultarGrafo(){
			return g;
		}
		
		/**
		 * Modificadora de el grafo
		 * @param G
		 */
		public void modificarGrafo(GrafoAntiguo G){
			g = G;
		}
		
		/**
		 * Modificadora de la Source
		 * @param s
		 */
		public void modificarSource(int s){
			source = s;
		}
		
		/**
		 * Consultora de la Source
		 * @return
		 */
		public int consultarSource(){
			return source;
		}
		
		/**
		 * Modificadora del sink 
		 * @param t
		 */
		public void modificarSink(int t){
			sink = t;
		}
		
		/**
		 * Consultora del sink 
		 * @return
		 */
		public int consultarSink(){
			return sink;
		}
		
		/**
		 * Consultora del numero de agentes 
		 * @return
		 */
		public int consultarNumeroAgentes(){
			return numeroAgentesSyT;
		}
		
		/**
		 * Modificadora del numero de agentes
		 * @param numAg
		 */
		public void modificarNumeroAgentes(int numAg){
			numeroAgentesSyT = numAg;
		}
		
		

	}


