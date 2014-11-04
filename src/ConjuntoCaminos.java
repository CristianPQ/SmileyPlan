import java.util.*;

public class ConjuntoCaminos {

	private Map<String, ArrayList<Camino>> Caminos = new HashMap<String, ArrayList<Camino>>();
	
	
	

	//crear un Camino sin capcidad, 1 por defecto
	public void agregarCamino(Camino camino) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para insertarle el Camino 
		if (Caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				throw new Exception("El Camino ya existe");   
			}
			else {
				listAux = Caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
				listAux.add(camino);
				Caminos.put(camino.getOrigen(), listAux);
			}
		}	
		else { 
			listAux = Caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
			listAux.add(camino);
			Caminos.put(camino.getOrigen(), listAux);
		}
	}
		
	public int getCapacidad (Camino camino) throws Exception{
		if (Caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				int pos = Caminos.get(camino.getOrigen()).indexOf(camino); //posicion donde esta el elemento
				return Caminos.get(camino.getOrigen()).get(pos).getCapacidad(); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
			}
			else {
				throw new Exception("El Camino NO existe");   
			}
		}	
		else { 
			throw new Exception("El Camino NO existe");   
		}
	}
		
		
		
	public int getNumCaminos(){
			return Caminos.size();
	}
	
	public void borrarCamino (Camino camino) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para borrar el Camino 
		if (Caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			if (Caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				listAux = Caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
				listAux.remove(camino); //borro
				Caminos.put(camino.getOrigen(), listAux); //inserto la nova llista axtualitzada
			}
			else {
				throw new Exception("El Camino NO existe");   
			}
		}	
		else { 
			throw new Exception("El Camino NO existe");   
		}
	}	
	//devuelve todos los caminos existentes con que tengan ciudad origen, ciudadOrigen, en caso de no existir devuelve null
	public ArrayList<Camino> getCaminosConCiudadOrigen (String ciudadOrigen){
		if (Caminos.containsKey(ciudadOrigen)) {
			return Caminos.get(ciudadOrigen);
		}
		else return null; 
	}

	
}







/*
public void setCapacidad(String ciudadOrigen, String ciudadDestino, String transporte, int capacidad) throws Exception{
	Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
	if (Caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
		if (Caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
			int pos = Caminos.get(ciudadOrigen).indexOf(auxCamino); //posicion donde esta el elemento
			Caminos.get(ciudadOrigen).get(pos).setCapacidad(capacidad); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
		}
		else {
			throw new Exception("El Camino NO existe");   
		}
	}	
	else { 
		throw new Exception("El Camino NO existe");   
	}
}
	
*/  
