import java.util.ArrayList;

import javax.lang.model.type.NullType;

public class AlgGraph {
		 Grafo<NullType, Arista> g;
	///////////////////////////////////////////////
	///////////////FUNCIONES GRAFO ARISTA///////////
	////////////////////////////////////////////////
	
		AlgGraph(Grafo<NullType, Arista> g1) {
		g = g1;
		}
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
	
	
	 int consultarNumAristasVertice(int vertex){
		return g.consultarAristasSalida(vertex).size();
	}
	
	
	
}