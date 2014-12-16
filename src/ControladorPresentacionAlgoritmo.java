
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
			return citi.escribirItinerarios(); 
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
				ControladorAgentes cagentes = cpa.devolverControlador();
				ControladorMedioTransporte cmt = cpm.devolverControlador();
				ControladorMapa cmapa = cpmapa.devolverControlador();
				ca = new ControladorAlgoritmo(cagentes,cmapa,cmt,s,t,funcionCoste); 
				ca.ejecutar(i);
			} catch (Exception e) {
				va.setError(e.getMessage()); 
			}
		}
		
		public VistaAlgoritmo getVista(){
			return va; 
		}
}
