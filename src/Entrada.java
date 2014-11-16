import java.util.*;

public class Entrada {
		private GrafoAntiguo g;
		private String ciudadOrigen;
		private String ciudadDestino;
		private int s;
		private int t;
		private int numeroAgentesSyT;
		private String[] mapping; //HABRA QUE COPIARLO A CNTRLALGORITMO AL INICIALIZAR EL CNTRL, acordarse del SIZE
		
		public Entrada(String source, String sink, int numAgentes) throws Exception{
				ciudadOrigen = source;
				ciudadDestino = sink;
				numeroAgentesSyT = numAgentes;
		}
		
		public GrafoAntiguo consultarGrafo(){
			return g;
		}
		
		public int consultarOrigen(){
			return s;
		}
		
		public int consultarDestino(){
			return t;
		}
		
		public int consultarNumAgentes(){
			return numeroAgentesSyT;
		}
		

		public void insertarCiudadesMapping(ControladorAlgoritmo ca, Mapa m) throws Exception{
			int i;
			int donde_guardo = 0;
			ArrayList<String> mapeo = new ArrayList<String>();

			for (i = 0; i < m.listarCiudades().size();++i){ //per cada ciutat
				int necesito = 1;
				for (int j = 0; j < m.listarCiudades().size(); ++j){ 
					//per cada ciutat possiblement adjacent a la ciutat (i)
					
					if (j != i){	//consultar caminos (i,j) 	
						ArrayList<Camino> Caminos = m.consultarCaminosEntre(m.listarCiudades().get(i), m.listarCiudades().get(j));		
						if (!Caminos.equals(null) && Caminos.size() > necesito ) necesito = Caminos.size();							
					}
				}
				
				for (int w = donde_guardo; w < (donde_guardo + necesito); ++w) mapeo.add(m.listarCiudades().get(i));
				donde_guardo += necesito;
			}
			
			mapping = new String[mapeo.size()];
			for (int z = 0; z < mapeo.size(); ++z) mapping[z] = mapeo.get(z);
			
			s = returnCityIndex(ciudadOrigen); //StringToVertex
			t = returnCityIndex(ciudadDestino); //StringToVertex
		}
		
		/*public void OrigenToSandObjetivoToT(){ //NO SE PUEDE HACER SI NO HAY MAPPING
			s = returnCityIndex(ciudadOrigen);
			t = returnCityIndex(ciudadDestino);
		}*/
		
		
		public int returnCityIndex(String city){
			int indice = -1;
			for (int i = 0; i < mapping.length; ++i) 
				if (mapping[i].equals(city)) {indice = i; return indice;}
				return indice;
		}
		
		public void crearGrafo(ControladorMapa m, ControladorAlgoritmo ca, ControladorMedioTransporte cm)throws Exception{
			g = new GrafoAntiguo(ca.consultarNumeroVertices()); //init grafo
			ArrayList<Camino> aristando;
			for (int i = 0; i < m.listarCiudades().size(); ++i){ //cada ciudad del mapa
				aristando = m.consultarCaminosDestino(m.listarCiudades().get(i)); //consultar ciudades adyacentes
				for (int j = 0; j < aristando.size(); ++j){ //cada ciudad adyacente...
					////////////////PREPARAR LA ARISTA
					int targetVertex  = returnCityIndex(aristando.get(j).consultarDestino());
					int capacity = aristando.get(i).consultarCapacidad();
					////////CALCULO TEMA COSTE
					MedioTransporte mtrans = cm.buscarMedio(aristando.get(j).consultarTransporte());
					int x1 = m.consultarCiudad(m.listarCiudades().get(i)).consultarCoordenadas().consultarX();
					int y1 =  m.consultarCiudad(m.listarCiudades().get(i)).consultarCoordenadas().consultarY();
					int x2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarX();
					int y2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarY();
					int x; int y;
					if (x1 > x2) x= x1-x2; else x = x2-x1;
					if (y1 > y2) y= y1-y2; else y = y2-y1;
					int cost = (x + y)* mtrans.getPrecio(); //REVISAR ESTO
					///////////////////////
					
					int insert_here = 0;
					boolean insertado = false;
					while (!insertado){
						if (!g.existeAdyacente(ca.devolverIndiceCiudad(m.listarCiudades().get(i)) + insert_here, targetVertex)){
							insertado = true;
							g.anadirArista(i,targetVertex, 0, capacity, cost);}
						++insert_here;
					}
					
					for (int d = 0; d < insert_here; ++d) 
						g.anadirArista(returnCityIndex(m.listarCiudades().get(i)) + d, 
								returnCityIndex(m.listarCiudades().get(i)) +1, 0, 2147483647, 0);
						
					}
				}
			}
		}
	
		
 //crearAristas


