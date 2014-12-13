
public class FuncionCostePorDistancia extends FuncionCoste {

	public FuncionCostePorDistancia (){ 
		super();
	}
	@Override
	public int getCoste(int coste, int distancia ){
		return distancia*coste;
	}
}

	
