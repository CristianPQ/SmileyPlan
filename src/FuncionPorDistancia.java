
public class FuncionPorDistancia extends FuncionCoste{
	
	public FuncionPorDistancia (){ 
		super();
	}
	@Override
	public int getCoste(int coste, int distancia ){
		return distancia;
	}
}
