import java.util.*;

public class ConjuntoCaminos {

	private Map<String, ArrayList<Camino>> caminos;
	
	
	public ConjuntoCaminos() {
		 this.caminos = new HashMap<String, ArrayList<Camino>>();
	}

	//crear un Camino sin capcidad, 1 por defecto
	public void agregarCamino(Camino camino) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para insertarle el Camino 
		if (caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			if (caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				throw new Exception("El Camino ya existe");   
			}
			else {
				listAux = caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
				listAux.add(camino);
				caminos.put(camino.getOrigen(), listAux);
			}
		}	
		else { 
			if (caminos.containsKey(camino.getOrigen()))
				listAux = caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
			listAux.add(camino);
			caminos.put(camino.getOrigen(), listAux);
		}
	}
		//mirar error contains array list
	public int getCapacidad(Camino camino) throws Exception{
		if (caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			ArrayList<Camino> listAux = new ArrayList<Camino>();
			listAux = caminos.get(camino.getOrigen());
			if (listAux.contains(camino)){ 
			//if (caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				int pos = caminos.get(camino.getOrigen()).indexOf(camino); //posicion donde esta el elemento
				return caminos.get(camino.getOrigen()).get(pos).getCapacidad(); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
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
			return caminos.size();
	}
	
	public void borrarCamino (Camino camino) throws Exception{
		ArrayList<Camino> listAux = new ArrayList<Camino>();  //creo una lista auxiliar para borrar el Camino 
		if (caminos.containsKey(camino.getOrigen())) { //primer miro si hi ha algun cami amb ciutatorigen
			if (caminos.get(camino.getOrigen()).contains(camino)){ //miro si existe ese camino en concreto
				listAux = caminos.get(camino.getOrigen()); //mira si es pot fer sense treure la llista
				listAux.remove(camino); //borro
				caminos.put(camino.getOrigen(), listAux); //inserto la nova llista axtualitzada
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
		if (caminos.containsKey(ciudadOrigen)) {
			return caminos.get(ciudadOrigen);
		}
		else return null; 
	}

	
}







/*
public void setCapacidad(String ciudadOrigen, String ciudadDestino, String transporte, int capacidad) throws Exception{
	Camino auxCamino = new Camino(ciudadOrigen,ciudadDestino, transporte); //Camino auxiliar
	if (caminos.containsKey(ciudadOrigen)) { //primer miro si hi ha algun cami amb ciutatorigen
		if (caminos.get(ciudadOrigen).contains(auxCamino)){ //miro si existe ese camino en concreto
			int pos = caminos.get(ciudadOrigen).indexOf(auxCamino); //posicion donde esta el elemento
			caminos.get(ciudadOrigen).get(pos).setCapacidad(capacidad); //del mapa trec el vector, del array trec el cami, del cami consultu la capacitat
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
