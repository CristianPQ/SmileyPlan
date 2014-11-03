import java.util.List;
import java.util.ArrayList;

public class ConjuntoAgentes {
		private int numAgentes = 0;
		private Agente[] ConjAgentes = new Agente[numAgentes];
		
		public ConjuntoAgentes(int numAg){
			numAgentes = numAg;	
		}
		
		public void anadirAgente(String id, String ciudad_ini, String ciudad_obj){ //ANADIR AGENTE
			Agente a = new Agente(id, ciudad_ini, ciudad_obj);
			//ConjAgentes.add(a);
			ConjAgentes[numAgentes] = a;
			++numAgentes;
		}	//FIN ANADIR
		
		public int getNumAgentes(){ //consulta del numero de agentes que hay
		return numAgentes;
		}
		
		public Agente consultarAgente(String nom){	//CONSULTAR AGENTE
			Agente a = null;
			boolean b = false;
			for (int i = 0; i < numAgentes; ++i){
				
				if (ConjAgentes[i].getNombre() == nom) {
					a = new Agente(
							ConjAgentes[i].getNombre(),
								ConjAgentes[i].getCiudad_inicial(),
									ConjAgentes[i].getCiudad_objetivo());
							
					b = true;					
					}
				
				if (b) break;				
				}
			
			return a;
			} //FIN CONSULTAR
			
		public void borrarAgente(String nom){ //BORRAR AGENTE
			for (int i = 0; i < numAgentes; ++i){
				if (ConjAgentes[i].getNombre() == nom){
					ConjAgentes[i] = ConjAgentes[numAgentes-1];
					ConjAgentes[numAgentes-1] = null;
					--numAgentes;		
				}
			}		//Estrategia: SWAP + eliminar el ultimo elemento del vector
		}			//y decrementar el numAgentes HABRIA QUE MEJORAR EN CASO DE CAMBIO DE TIPO DE ESTRUCTURA				
		
		public String consultar_ciudad_inicial(String nom){ //CONSULTAR CIUDAD INICIAL
			boolean b = false;
			String initial_city = "NoExisteAgenteConDichoNombre";
			for (int i = 0; i < numAgentes; ++i){
				
				if (ConjAgentes[i].getNombre() == nom) {
					initial_city = ConjAgentes[i].getCiudad_inicial();
					b = true;					
					}
				
				if (b) break;				
				}
			
			return initial_city;
			} //FIN CONSULTAR INIT CITY
			
		public String consultar_ciudad_objetivo(String nom){ //CONSULTAR CIUDAD OBJ
			boolean b = false;
			String final_city = "NoExisteAgenteConDichoNombre";
			for (int i = 0; i < numAgentes; ++i){
				
				if (ConjAgentes[i].getNombre() == nom) {
					final_city = ConjAgentes[i].getCiudad_objetivo();
					b = true;					
					}
				
				if (b) break;				
				}
			
			return final_city;
			}//FIN FINAL CITY
		
		public List<Agente> consultar_agentes_con_ciudad_inicial(String init_city){ //AG con CiIni concreta
			List<Agente> l = new ArrayList<Agente>();
			for (int i = 0; i < numAgentes; ++i)
				if (ConjAgentes[i].getCiudad_inicial() == init_city) l.add(ConjAgentes[i]);
			return l;
			}
		
		public List<Agente> consultar_agentes_con_ciudad_objetivo(String final_city){ //AG con Cobj concreta
			List<Agente> l = new ArrayList<Agente>();
			for (int i = 0; i < numAgentes; ++i)
				if (ConjAgentes[i].getCiudad_objetivo() == final_city) l.add(ConjAgentes[i]);
			return l;
			}
		
}

