import java.util.List;
import java.util.ArrayList;

public class ConjuntoAgente {
		private int numAgentes = 0;
		private Agente[] ConjAgentes;

		public void añadirAgente(String id, String ciudad_ini, String ciudad_obj){ //ANADIR AGENTE
			Agente a = new Agente();
			a.setNombre(id);
			a.setCiudad_inicial(ciudad_ini);
			a.setCiudad_objetivo(ciudad_obj);
			//ConjAgentes.add(a);
			ConjAgentes[numAgentes] = a;
			++numAgentes;
		}	//FIN ANADIR
		
		public int getNumAgentes(){ //consulta del numero de agentes que hay
		return numAgentes;
		}
		
		public Agente consultarAgente(String nom){	//CONSULTAR AGENTE
			Agente a = new Agente();
			boolean b = false;
			for (int i = 0; i < numAgentes; ++i){
				
				if (ConjAgentes[i].getNombre() == nom) {
					a.setNombre(ConjAgentes[i].getNombre());
					a.setCiudad_inicial(ConjAgentes[i].getCiudad_inicial());
					a.setCiudad_objetivo(ConjAgentes[i].getCiudad_objetivo());
					b = true;					
					}
				
				if (b) break;				
				}
			
			return a;
			} //FIN CONSULTAR
			
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




		//public list consultar_agentes_con_ciudad_inicial
		//public list consultar_agentes_con_ciudad_objetivo

