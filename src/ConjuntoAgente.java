
public class ConjuntoAgente {
		private int num_agentes = 0;
		private Agente[] ConjAgentes;

		public void añadirAgente(String id, String ciudad_ini, String ciudad_obj){ //ANADIR
			Agente a = new Agente();
			a.setNombre(id);
			a.setCiudad_inicial(ciudad_ini);
			a.setCiudad_objetivo(ciudad_obj);
			//ConjAgentes.add(a);
			ConjAgentes[num_agentes] = a;
			++num_agentes;
		}	//FIN ANADIR
		
		public Agente consultarAgente(String nom){	//CONSULTAR
			Agente a = new Agente();
			boolean b = false;
			for (int i = 0; i < num_agentes; ++i){
				
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
			
		}
		//public String consultar_ciudad_inicialAgente a);
		//public String consultar_ciudad_objetivo
		//public list consultar_agentes_con_ciudad_inicial
		//public list consultar_agentes_con_ciudad_objetivo

