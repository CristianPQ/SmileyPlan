
public class ControladorPresentacionAlgoritmo {
	
		private static ControladorAlgoritmo ca; 
		private static VistaAlgoritmo va;
		private static ControladorItinerarios citi; 
		private static ControladorPresentacionAgentes cpa;
		private static ControladorPresentacionMedios cpm;
		private static ControladorPresentacionMapa cpmapa;
		
		public ControladorPresentacionAlgoritmo(ControladorPresentacionAgentes cpa2, ControladorPresentacionMapa cpmapa2,
				ControladorPresentacionMedios cpm2) {
			citi = new ControladorItinerarios(); 
			va = new VistaAlgoritmo(this);
			cpa = cpa2;
			cpmapa = cpmapa2;
			cpm = cpm2;
			
		}

		
		public String escribirItinearios(){
			String s = new String();
			if (ca.haySoucion()){
				try {
					s = "Tiempo: " + ca.consultarTiempo() + "ms\n";
					s += "El max flow es: " + ca.consultarMaxFlow() + "\n";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					va.setError(e.getMessage());
				}
				return s + citi.escribirItinerarios(); 
			}
			else return "No hay solucion para tantos agentes, el numero maximo de agentes que "
					+ "pueden hacer este viaje es " + citi.consultarSize();
			
		
		}
		
		public void initItinerarios(){
			citi = new ControladorItinerarios();
		}
		
		public void guardarSeq(String file){
			try {
				ca.guardarSeq(file);
			} catch (Exception e) {
				va.setError(e.getMessage()); 
			}
		}
		
		public void ejecutar(int i, String s, String t, boolean funcionCoste) {
			try {
				//System.out.println("entro en ejecutar controlador presentacio");
				ControladorAgentes cagentes = cpa.devolverControlador();
				ControladorMedioTransporte cmt = cpm.devolverControlador();
				ControladorMapa cmapa = cpmapa.devolverControlador();
				ca = new ControladorAlgoritmo(cagentes,cmapa,cmt,s,t,funcionCoste,citi); 
				ca.ejecutar(i);
				System.out.println("El timepo en presentacion es " + ca.consultarTiempo());
			} catch (Exception e) {
				va.setError(e.getMessage()); 
			}
		}
		
		public VistaAlgoritmo getVista(){
			return va; 
		}
}
