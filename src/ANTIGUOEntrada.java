import java.util.*;

public class ANTIGUOEntrada {
		private GrafoAntiguo g;
		private String ciudadOrigen;
		private String ciudadDestino;
		private int s;
		private int t;
		private int numeroAgentesSyT;
		private String[] mapping; //HABRA QUE COPIARLO A CNTRLALGORITMO AL INICIALIZAR EL CNTRL, acordarse del SIZE
		
		public ANTIGUOEntrada(ControladorMapa m, ControladorMedioTransporte cm,
				 String source, String sink, int numAgentes) throws Exception{
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
		
		
		public int returnCityIndex(String city){
			int indice = -1;
			for (int i = 0; i < mapping.length; ++i) 
				if (mapping[i].equals(city)) {indice = i; return indice;}
				return indice;
		}
		
	
		
		public void insertarCiudadesMapping(ControladorMapa m) throws Exception{
			int i;
		//	int donde_guardo = 0;
			ArrayList<String> mapeo = new ArrayList<String>();

			for (i = 0; i < m.listarCiudades().size();++i){ //per cada ciutat
				System.out.println("entro for");
				int necesito = 1;
				for (int j = 0; j < m.listarCiudades().size(); ++j){ 
					//per cada ciutat possiblement adjacent a la ciutat (i)
					
					if (j != i){//hacer a ver si existen caminos para EVITAR EXCEPCIONES
						//consultar caminos (i,j) 	
						if(m.existeCaminoDesdeA(m.listarCiudades().get(i), m.listarCiudades().get(j))){
							
							ArrayList<Camino> Caminos = m.consultarCaminosEntre(m.listarCiudades().get(i), m.listarCiudades().get(j));
							if (!Caminos.equals(null) && Caminos.size() > necesito ) necesito = Caminos.size();
							System.out.println("entro de vez en cuando al if");
							}
						}
					}
				int w = 0;
				while (w < necesito) {
					mapeo.add(m.listarCiudades().get(i));
					System.out.println(m.listarCiudades().get(i));
					++w;
				}
				//for (int w = donde_guardo; w < (donde_guardo + necesito); ++w) mapeo.add(m.listarCiudades().get(i));
				//donde_guardo += necesito;
			}
			
			mapping = new String[mapeo.size()];
			for (int z = 0; z < mapeo.size(); ++z) mapping[z] = mapeo.get(z);
			
			System.out.println( mapping[0]+" llego al final");
		}
		
		public String[] consultarMapping(){
			return mapping;
		}
		
		public int tamanoMapping(){
			return mapping.length;
		}
		/*public void OrigenToSandObjetivoToT(){ //NO SE PUEDE HACER SI NO HAY MAPPING
			s = returnCityIndex(ciudadOrigen);
			t = returnCityIndex(ciudadDestino);
		}*/
		

		public void crearGrafo(ControladorMapa m, ControladorMedioTransporte cm)throws Exception{
			g = new GrafoAntiguo(mapping.length); //init grafo
			//ArrayList<Camino> aristando = new ArrayList<Camino>();
			
			ArrayList<Camino> aristando;
			for (int i = 0; i < m.listarCiudades().size(); ++i){//cada ciudad del mapa
				aristando = new ArrayList<Camino>();
				System.out.println("entra for"+ m.listarCiudades().get(i));
				String ciudadEncontrandoAristas = m.listarCiudades().get(i);
				if(m.existeCaminoConOrigen(ciudadEncontrandoAristas))
				aristando = m.consultarCaminosDestino(ciudadEncontrandoAristas); //consultar ciudades adyacentes
				if (!aristando.equals(null)){
					for (int j = 0; j < aristando.size(); ++j){ //cada ciudad adyacente...
					////////////////PREPARAR LA ARISTA
						int targetVertex  = returnCityIndex(aristando.get(j).consultarDestino());
						int capacity = aristando.get(j).consultarCapacidad();
					////////CALCULO TEMA COSTE
						/*MedioTransporte mtrans = cm.buscarMedio(aristando.get(j).consultarTransporte());
						System.out.println("aqui no se si ?");
						int x1 = m.consultarCiudad(ciudadEncontrandoAristas).consultarCoordenadas().consultarX();
						System.out.println("aqui no se si ?");
						int y1 =  m.consultarCiudad(ciudadEncontrandoAristas).consultarCoordenadas().consultarY();
						System.out.println("aqui no se si ?");
						int x2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarX();
						int y2 = m.consultarCiudad(aristando.get(j).consultarDestino()).consultarCoordenadas().consultarY();
						int x; int y;
						if (x1 > x2) x= x1-x2; else x = x2-x1;
						if (y1 > y2) y= y1-y2; else y = y2-y1;
						int cost = (x + y)* mtrans.getPrecio(); //REVISAR ESTO
					///////////////////////
					 */
						int cost = 0;
						System.out.println("aqui no se si llego?");
						int insert_here = -1;
						boolean insertado = false;
						while (!insertado){ //para tener en cuenta num d'iteraciones
							++insert_here;
							if (!g.existeAdyacente(returnCityIndex(ciudadEncontrandoAristas) + insert_here, targetVertex)){
								insertado = true;
								g.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + insert_here,targetVertex, 0, capacity, cost);
								System.out.println("CUANTAS VECES INSERTO");
								}
							//if(!insertado)++insert_here; //AQUI PODRIA HABEER UN FALLO
						}
					
						for (int d = 0; d < insert_here; ++d) 
							g.anadirArista(returnCityIndex(ciudadEncontrandoAristas) + d, 
									returnCityIndex(ciudadEncontrandoAristas) +1, 0, 2147483647, 0);
						
						}
						
					}
					
				}
				
			
			System.out.println("LLEGO AL FINAL");
			}
		}
	
		
 //crearAristas
