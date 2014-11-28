
import java.util.ArrayList;
public class Grafo<E> {
	
	class Sentidos {
		
		private ArrayList<E> entrada;
		private ArrayList<E> salida;
		
		public Sentidos() {
			entrada = new ArrayList<E>();
			salida = new ArrayList<E>();
		}
		
		//No se si esta bien
		public boolean existe(E e) {
			return entrada.contains(e) || salida.contains(e);
		}
		
		public boolean entradaEmpty() {
			return entrada.isEmpty();
		}
		
		public boolean salidaEmpty() {
			return salida.isEmpty();
		}
		
		public agregarEntrada() {
			
		}
	}

	private ArrayList<Sentidos> adyacencias;


	/**
	 * Constructora Grafo
	 * @param numVertex
	 */
	public Grafo() {
		//numVertices = numVertex;
		adyacencias = new ArrayList<Sentidos>();
	}
	
	/**
	 * Consultora de adyacencias de salida de un vertice
	 * @param indice
	 * @return
	 */
	public ArrayList<E> consultarAdyacentesSalida(int indice){
		return adyacencias.get(indice).salida;
	}
	
	/**
	 * Consultora de adyacencias de entrada de un vertice
	 * @param indice
	 * @return
	 */
	public ArrayList<E> consultarAdyacentesEntrada(int indice){
		return adyacencias.get(indice).entrada;
	}

	/**
	 * 
	 * @param indice
	 * @param e
	 * @return
	 */
	public boolean existeAdyacente(int indice, E e) {
		return adyacencias.get(indice).existe(e);
	}
	
	/**
	 * Adicion de elemento
	 * @param vertex vertice origen
	 * @param e
	 */
	public void agregarElemento(int in, int out, E e) {
		Sentidos ent = adyacencias.get(in).agregarEntrada(e);
		adyacencias.set(in, ent);
		
		Sentidos sal = adyacencias.get(out).agregarSalida(e);
		adyacencias.set(out, sal);
	}

	/**
	 * Eliminacion de una arista
	 * @param vertex vertice origen
	 * @param targetVertex vertice destino 
	 */
	public void eliminarArista(int vertex, int targetVertex){
		int i = 0;
		boolean trobat = false;
		for (i = 0; i < Adyacencias[vertex].size() && !trobat; ++i){			
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
					Adyacencias[vertex].remove(i);
				trobat = true;
			}
			
		}
	}
	
	/**
	 * Consulta del flujo de una arista
	 * @param vertex vertice origen
	 * @param targetVertex vertice destino 
	 */
	public int consultarFlujoArista(int vertex, int targetVertex){
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarFlujo();
			}			
		}
		return -1;
	}

	/**
	 * Modificadora flujo de una arista
	 * @param vertex vertice origen
	 * @param targetVertex vertice destino
	 * @param nuevoFlujo
	 */
	public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo) 
			{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarFlujo(nuevoFlujo);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);

			}			
		}
	}


	/**
	 * Consultora capacidad
	 * @param vertex vertice origen
	 * @param targetVertex vertice destino
	 * @return
	 */
	public int consultarCapacidadArista(int vertex, int targetVertex) {
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCapacidad();
			}			
		}
		return -1;
	}

	/**
	 * Modificadora capacidad
	 * @param vertex vertice origen
	 * @param targetVertex vertice destino
	 * @param nuevaCapacidad
	 */
	public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad) 
			{
				
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarCapacidad(nuevaCapacidad);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);
			}			
		}
	}
	/**
	 * Consultar coste
	 * @param vertex
	 * @param targetVertex
	 * @return
	 * @throws Exception
	 */
	public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						return Adyacencias[vertex].get(i).consultarCoste();
			}			
		}
		return -1;
	}

	/**
	 * Modificar coste
	 * @param vertex
	 * @param targetVertex
	 * @param nuevoCoste
	 */
	public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
		{
		int i;
		for (i = 0; i < Adyacencias[vertex].size(); ++i){
			if( !Adyacencias[vertex].get(i).equals(null) &&
					Adyacencias[vertex].get(i).consultarVerticeDestino() == targetVertex){
						Arista a = Adyacencias[vertex].get(i);
						a.modificarCoste(nuevoCoste);
						Adyacencias[vertex].remove(i);
						Adyacencias[vertex].add(i,a);

			}			
		}
	}
	
	/**
	 * Consulta del numero de vertices del grafo
	 * @return
	 */
	public int consultarNumVertices(){
		return numVertices;
	}

	/**
	 * Consultar el numero de aristas que salen de un vertice determinado
	 * @param vertex
	 * @return
	 */
	public int consultarNumAristasVertice(int vertex){
		return Adyacencias[vertex].size();
	}
	

}
