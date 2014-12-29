import java.util.ArrayList;
public class Grafo<E1, E2> {
    
    public class Sentidos {
        
    	//Soy destino
        private ArrayList<E2> entrada;
        //Soy origen
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
        
        public void modificarEntrada(E2 e) {
        	for(int i = 0; i < entrada.size(); ++i) {
        		if(entrada.get(i).equals(e)) {
        			entrada.set(i,e);
        			return;
        		}
        	}
        }
        
        public void modificarSalida(E2 e) {
        	for(int i = 0; i < salida.size(); ++i) {
        		if(salida.get(i).equals(e)) {
        			salida.set(i,e);
        			return;
        		}
        	}
        }
    }
    
    private TST<E1> vertices;
    private ArrayList<Sentidos> aristas;
    private ArrayList<Integer> vacios;
    
    private static Exception NoExiste = new Exception ("Este elemento no existe");
    
    
    /**
     * Constructora Grafo
     * @param numVertex
     */
    public Grafo() {
        //numVertices = numVertex;
    	vertices =  new TST<E1>();
        aristas = new ArrayList<Sentidos>();
        vacios = new ArrayList<Integer>();
    }
    
    public int siguiente() {
    	if(vacios.isEmpty()) {
    		return vertices.numero();
    	}
    	else {
    		int i = vacios.get(0);
    		vacios.remove(0);
    		return i;
    	}
    }
    
    public void agregarVertice(E1 e, int index) {
    	vertices.insert(e);
    	while(aristas.size() < index+1) {
    		aristas.add(new Sentidos());
    	}
    }
    
    public void eliminarVertice(String id, int index) {
    		//System.out.println("Antes de delete");
    	vertices.delete(id);
    		//System.out.println("Despues de delete");
    	aristas.set(index, new Sentidos());
    		//System.out.println("Despues de set");
    	vacios.add(index);
    		//System.out.println("Despues de add");
    }
    
    public ArrayList<E1> consultarVertices() {
    	ArrayList<String> v = vertices.consultar();
    	ArrayList<E1> vr = new ArrayList<E1>();
    	int n = vertices.numero();
    	for(int i = 0; i < n; ++i) {
    		vr.add(vertices.consultar(v.get(i)));
    	}
    	return vr;
    }
    
    public ArrayList<String> consultarVerticesID() {
    	return vertices.consultar();
    }
    
    public E1 consultarVertice(String id) {
    	return vertices.consultar(id);
    }
    
    public boolean existeVertice(String id) {
    	return vertices.existe(id);
    }
    
    public void modificarVertice(String id, E1 e) {
    	vertices.modificar(id, e);
    }
    
    public boolean isEmpty() {
    	if(vertices.numero() > 0) return false;
    	else return true;
    }
    public int consultarNumVertices() {
    	return aristas.size();
    }
    
	/////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
    
    public void agregarArista(E2 e, int in, int out) {
    	Sentidos ent = aristas.get(in);
    	ent.agregarEntrada(e);
    	aristas.set(in, ent);
    	Sentidos sal = aristas.get(out);
    	sal.agregarSalida(e);
    	aristas.set(out, sal);
    }
    
    public void modificarArista(E2 e, int in, int out) {
    	Sentidos ent = aristas.get(in);
    	ent.modificarEntrada(e);
    	aristas.set(in, ent);
    	Sentidos sal = aristas.get(out);
    	sal.modificarSalida(e);
    	aristas.set(out, sal);
    }
    
    public void eliminarArista(E2 e, int in, int out) {
    	Sentidos ent = aristas.get(in);
    	ent.eliminarEntrada(e);
    	aristas.set(in, ent);
    	Sentidos sal = aristas.get(out);
    	sal.eliminarSalida(e);
    	aristas.set(out, sal);
    }
    
    public void eliminarAristaEntrada(E2 e, int in) {
    	Sentidos ent = aristas.get(in);
    	ent.eliminarEntrada(e);
    	aristas.set(in, ent);
    }
    
    public void eliminarAristaSalida(E2 e, int out) {
    	Sentidos sal = aristas.get(out);
    	sal.eliminarEntrada(e);
    	aristas.set(out, sal);
    }
    
    public boolean existeArista(E2 e, int in, int out) {
    	Sentidos ent = aristas.get(in);
    	if(ent.existe(e)) return true;
    	Sentidos sal = aristas.get(out);
    	if(sal.existe(e)) return true;
    	return false;
    }
   
    /**
     * Consultora de aristas de salida de un vertice
     * @param indice
     * @return
     */
    public ArrayList<E2> consultarAristasSalida(int indice){
        return aristas.get(indice).salida;
    }
    
    /**
     * Consultora de aristas de entrada de un vertice
     * @param indice
     * @return
     */
    public ArrayList<E2> consultarAristasEntrada(int indice){
        return aristas.get(indice).entrada;
    }
    
    public boolean existeAristaConOrigen(int id) {
    	return !aristas.get(id).salidaEmpty();
    }
    
    public boolean existeAristaConDestino(int id) {
    	return !aristas.get(id).entradaEmpty();
    }
    
    public boolean existeAristaCon(int id) {
    	return !aristas.get(id).salidaEmpty() || !aristas.get(id).entradaEmpty();
    }
    
    
    
    
    
    
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    
    public Grafo(int n) {
    	aristas = new ArrayList<Sentidos>();
    	for(int i = 0; i < n; ++i) {
    		agrandar();
    	}
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