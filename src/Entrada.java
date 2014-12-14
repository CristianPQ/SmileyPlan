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
		///////////////////////////////////////////////
		///////////////FUNCIONES GRAFO ARISTA///////////
		////////////////////////////////////////////////
		
		//ArrayList<Arista> consultarAdyacentes(int vertex) -> g.consultarAdyacentesSalida(int vertex)
		public boolean existeAdyacente(int vertex, int targetVertex){
			ArrayList<Arista> a = g.consultarAristasSalida(vertex);
			for (int i = 0; i < a.size(); ++i)
				if (a.get(i).consultarVerticeDestino() == targetVertex) return true;
			return false;
		}
		
		public void anadirArista (int vertex, int targetVertex,
				int flow, int capacity, int cost){
			Arista a = new Arista(targetVertex, flow, capacity, cost);
			g.agregarElemento(targetVertex, vertex, a);
		}
		
		public void eliminarArista(int vertex, int targetVertex){
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			boolean trobat = false;
			Arista ar = null;
			for(int i = 0; i < adj.size() && !trobat; ++i){	
				if(!adj.get(i).equals(null) && adj.get(i).consultarVerticeDestino() == targetVertex){
				ar = adj.get(i);
				trobat = true;				
				}
			}
			if (trobat) g.eliminarAristaSalida(ar, vertex);					
		}
		
		public int consultarFlujoArista(int vertex, int targetVertex){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							return adj.get(i).consultarFlujo();
				}			
			}
			return -1;
		}
		
		public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			Arista ar = null;
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							ar = adj.get(i);
					}			
				}
			
			g.eliminarAristaSalida(ar, vertex);
			ar.modificarFlujo(nuevoFlujo);		
			g.agregarArista(ar, targetVertex, vertex);
		}
		
		public int consultarCapacidadArista(int vertex, int targetVertex){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							return adj.get(i).consultarCapacidad();
				}			
			}
			return -1;
		}
		
		public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			Arista ar = null;
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							ar = adj.get(i);
					}			
				}
			
			g.eliminarAristaSalida(ar, vertex);
			ar.modificarCapacidad(nuevaCapacidad);		
			g.agregarArista(ar, targetVertex, vertex);
		}

		public int consultarCosteArista(int vertex, int targetVertex){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							return adj.get(i).consultarCoste();
				}			
			}
			return -1;
		}
		
		public void modificarCosteArista(int vertex, int targetVertex, int nuevaCapacidad){
			int i;
			ArrayList<Arista> adj = g.consultarAristasSalida(vertex);
			Arista ar = null;
			for (i = 0; i < adj.size(); ++i){
				if( !adj.get(i).equals(null) &&
						adj.get(i).consultarVerticeDestino() == targetVertex){
							ar = adj.get(i);
					}			
				}
			
			g.eliminarAristaSalida(ar, vertex);
			ar.modificarCoste(nuevaCapacidad);		
			g.agregarArista(ar, targetVertex, vertex);
		}	
		
		//Yo haria una funcion que devolviera el NUM DE VERTICES
		//o sea almacenaría el numero que le pasas por la constructora
		//y lo devolveria, se puede hacer en mismo grafo easy
		
		
		public int consultarNumAristasVertice(int vertex){
			return g.consultarAristasSalida(vertex).size();
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


