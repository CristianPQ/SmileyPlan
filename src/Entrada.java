import java.util.*;

public class Entrada {
		GrafoAntiguo g;
		int s;
		int t;
		int numAgentes;
		//Ciudad[] ciudades; //obtener todas las ciudades, entonces tendremos
							//las posiciones q ocuparan en el grafo
	  //nombre -> vertex
		
		
		/*public Grafoa Entrada(Mapa m, ControladorAgentes ca, ControladorMedioTransporte cm,
				ControladorAlgoritmo caa) throws Exception{
			


			//para cada Ciudad
			//obtener los caminos
			//para cada camino, 
			
			return g;
		}*/
		
		public void insertarCiudadesMapping(ControladorAlgoritmo ca, Mapa m) throws Exception{
			int i;
			int donde_guardo = 0;
			ArrayList<String> mapeo = new ArrayList<String>();

			for (i = 0; i < m.listarCiudades().size();++i){ //per cada ciutat
				int necesito = 1;
				for (int j = 0; j < m.listarCiudades().size(); ++j){ 
					//per cada ciutat possiblement adjacent a la ciutat (i)
					
					if (j != i){
						ArrayList<Camino> Caminos = m.consultarCaminos(m.listarCiudades().get(i), m.listarCiudades().get(j));
						//consultar caminos (i,j) 
						
						if (!Caminos.equals(null) && Caminos.size() > necesito ) necesito = Caminos.size();
							
					}

				}
				for (int w = donde_guardo; w < (donde_guardo + necesito); ++w) mapeo.add(m.listarCiudades().get(i));
				donde_guardo += necesito;
			}
			
			ca.inicializarRelacCiudades(mapeo.size());
			for (int z = 0; z < mapeo.size(); ++z) ca.modificarRelacCiudad(mapeo.get(z), z);
		}
		
		public void crearGrafo(Mapa m, ControladorAlgoritmo ca, ControladorMedioTransporte cm)throws Exception{
			g = new GrafoAntiguo(ca.consultarNumeroVertices()); //init grafo
			ArrayList<Camino> aristando;
			for (int i = 0; i < m.listarCiudades().size(); ++i){ //cada ciudad del mapa
				aristando = m.consultarCiudadesDestino(m.listarCiudades().get(i)); //consultar ciudades adyacentes
				for (int j = 0; j < aristando.size(); ++j){ //cada ciudad adyacente...
					////////////////PREPARAR LA ARISTA
					int targetVertex  = ca.devolverIndiceCiudad(aristando.get(j).consultarDestino());
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
				}
			}
		}
	}
	
		
 //crearAristas


