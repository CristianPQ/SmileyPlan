import java.util.*;

import javax.lang.model.type.NullType;

public class Entrada {
		private Grafo<NullType, Arista> g;
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
		public Entrada(Grafo<NullType,Arista> G, int s, int t, int numAgentes) throws Exception{
				g = G;
				source = s;
				sink = t;
				numeroAgentesSyT = numAgentes;
		}
		
		/**
		 * Devuelve el grafo 
		 * @return
		 */
		public Grafo<NullType,Arista> consultarGrafo(){
			return g;
		}
		
		/**
		 * Modificadora de el grafo
		 * @param G
		 */
		public void modificarGrafo(Grafo<NullType, Arista> G){
			g = G;
		}
		
		///////////////FUNCIONES GRAFO ARISTA///////////
		
		//ArrayList<Arista> consultarAdyacentes(int vertex) -> g.consultarAdyacentesSalida(int vertex)
		public boolean existeAdyacente(int vertex, int targetVertex){
			ArrayList<Arista> a = g.consultarAdyacentesSalida(vertex);
			for (int i = 0; i < a.size(); ++i)
				if (a.get(i).consultarVerticeDestino() == targetVertex) return true;
			return false;
		}
		
		public void anadirArista (int vertex, int targetVertex,
				int flow, int capacity, int cost){
			Arista a = new Arista(targetVertex, flow, capacity, cost);
			g.agregarElemento(vertex, targetVertex, a);
		}
		
		/*public void eliminarArista(int vertex, int targetVertex){
			for(int i = 0; i < g.consultarAdyacentesSalida(vertex).size(); ++i){	
			}
		}
		*/
		public void
		
		
		
		
		
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


