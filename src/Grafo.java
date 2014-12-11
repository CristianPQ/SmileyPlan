import java.util.ArrayList;
public class Grafo<E1, E2> {
    
    public class Sentidos {
        
        private ArrayList<E2> entrada;
        private ArrayList<E2> salida;
        
        public Sentidos() {
            entrada = new ArrayList<E2>();
            salida = new ArrayList<E2>();
        }
        
        //No se si esta bien
        public boolean existe(E2 e) {
            return entrada.contains(e) || salida.contains(e);
        }
        
        public boolean entradaEmpty() {
            return entrada.isEmpty();
        }
        
        public boolean salidaEmpty() {
            return salida.isEmpty();
        }
        
        public void agregarEntrada(E2 e) {
            entrada.add(e);
        }
        
        public void agregarSalida(E2 e) {
            salida.add(e);
        }
        
        public void eliminarEntrada(E2 e) {
        	for(int i = 0; i < entrada.size(); ++i) {
        		if(entrada.get(i).equals(e)) {
        			entrada.remove(i);
        			return;
        		}
        	}
        }
        public void eliminarSalida(E2 e) {
        	for(int i = 0; i < salida.size(); ++i) {
        		if(salida.get(i).equals(e)) {
        			salida.remove(i);
        			return;
        		}
        	}
        }
    }
    
    private TST<E1> vertices;
    private ArrayList<Sentidos> aristas;
    
    private static Exception NoExiste = new Exception ("Este elemento no existe");
    
    
    /**
     * Constructora Grafo
     * @param numVertex
     */
    public Grafo() {
        //numVertices = numVertex;
        aristas = new ArrayList<Sentidos>();
    }
    
    public Grafo(int n) {
    	aristas = new ArrayList<Sentidos>();
    	for(int i = 0; i < n; ++i) {
    		agrandar();
    	}
    }
    
    /**
     * Consultora de aristas de salida de un vertice
     * @param indice
     * @return
     */
    public ArrayList<E2> consultarAdyacentesSalida(int indice){
        return aristas.get(indice).salida;
    }
    
    /**
     * Consultora de aristas de entrada de un vertice
     * @param indice
     * @return
     */
    public ArrayList<E2> consultarAdyacentesEntrada(int indice){
        return aristas.get(indice).entrada;
    }
    
    /**
     *
     * @param indice
     * @param e
     * @return
     */
    public boolean existeAdyacente(int indice, E2 e) {
        return aristas.get(indice).existe(e);
    }
    
    /**
     * Adicion de elemento
     * @param vertex vertice origen
     * @param e
     */
    public void agregarElemento(int in, int out, E2 e) {
        Sentidos ent = aristas.get(in);
        ent.agregarEntrada(e);
        aristas.set(in, ent);
        
        Sentidos sal = aristas.get(out);
        sal.agregarSalida(e);
        aristas.set(out, sal);
    }
    
    /**
     * Eliminacion de un elemento
     * @param vertex vertice origen
     * @param targetVertex vertice destino
     * @throws Exception 
     */
    public void eliminarElemento(int in, int out, E2 e) throws Exception{
    	Sentidos ent = aristas.get(in);
    	Sentidos sal= aristas.get(out);
        if(!ent.existe(e) || !sal.existe(e)) throw NoExiste;
        ent.eliminarEntrada(e);
        sal.eliminarSalida(e);
        aristas.set(in, ent);
        aristas.set(out, sal);
    }
    
    public int size() {
    	return aristas.size();
    }
    
    public void agrandar() {
    	Sentidos s = new Sentidos();
    	aristas.add(s);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Consulta del flujo de una arista
     * @param vertex vertice origen
     * @param targetVertex vertice destino
     */
    /*
    public int consultarFlujoArista(int vertex, int targetVertex){
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                return aristas[vertex].get(i).consultarFlujo();
            }
        }
        return -1;
    }*/
    
    /**
     * Modificadora flujo de una arista
     * @param vertex vertice origen
     * @param targetVertex vertice destino
     * @param nuevoFlujo
     */
    /*
    public void modificarFlujoArista(int vertex, int targetVertex, int nuevoFlujo)
    {
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                Arista a = aristas[vertex].get(i);
                a.modificarFlujo(nuevoFlujo);
                aristas[vertex].remove(i);
                aristas[vertex].add(i,a);
                
            }
        }
    }*/
    
    
    /**
     * Consultora capacidad
     * @param vertex vertice origen
     * @param targetVertex vertice destino
     * @return
     */
    /*
    public int consultarCapacidadArista(int vertex, int targetVertex) {
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                return aristas[vertex].get(i).consultarCapacidad();
            }
        }
        return -1;
    }*/
    
    /**
     * Modificadora capacidad
     * @param vertex vertice origen
     * @param targetVertex vertice destino
     * @param nuevaCapacidad
     */
    /*
    public void modificarCapacidadArista(int vertex, int targetVertex, int nuevaCapacidad)
    {
        
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                Arista a = aristas[vertex].get(i);
                a.modificarCapacidad(nuevaCapacidad);
                aristas[vertex].remove(i);
                aristas[vertex].add(i,a);
            }
        }
    }*/
    /**
     * Consultar coste
     * @param vertex
     * @param targetVertex
     * @return
     * @throws Exception
     */
    /*
    public int consultarCosteArista(int vertex, int targetVertex)throws Exception{
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                return aristas[vertex].get(i).consultarCoste();
            }			
        }
        return -1;
    }*/
    
    /**
     * Modificar coste
     * @param vertex
     * @param targetVertex
     * @param nuevoCoste
     */
    /*
    public void modificarCosteArista(int vertex, int targetVertex, int nuevoCoste)
    {
        int i;
        for (i = 0; i < aristas[vertex].size(); ++i){
            if( !aristas[vertex].get(i).equals(null) &&
               aristas[vertex].get(i).consultarVerticeDestino() == targetVertex){
                Arista a = aristas[vertex].get(i);
                a.modificarCoste(nuevoCoste);
                aristas[vertex].remove(i);
                aristas[vertex].add(i,a);
                
            }			
        }
    }*/
    
    /**
     * Consulta del numero de vertices del grafo
     * @return
     */
    /*
    public int consultarNumVertices(){
        return numVertices;
    }*/
    
    /**
     * Consultar el numero de aristas que salen de un vertice determinado
     * @param vertex
     * @return
     */
    /*
    public int consultarNumAristasVertice(int vertex){
        return aristas[vertex].size();
    }*/
    
    
}