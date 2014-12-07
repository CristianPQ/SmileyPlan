import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAgentes extends Vista2 {
	
	private ControladorPresentacionAgentes ctrlPAg;
	
	VistaAgentes(ControladorPresentacionAgentes cpag){
		super();
		ctrlPAg = cpag;
		
		super.label1.setText("Nombre: ");
		super.label2.setText("Ciudad Inicial: ");
		//super.label3.setText("Ciudad Objetivo: ");
		
		crearListeners();
		
	
}
	
	void crearListeners(){
		
		botonCrear.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String nombre = text1.getText();
				String ciuIni = text2.getText();
				//String ciuObj = text3.getText();
				if (!text1.getText().equals("") && !text2.getText().equals("")
						&& !text2.getText().equals(""))
					try {
						ctrlPAg.agregarAgente(nombre, ciuIni, ciuIni);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}	
		});
				}
	


	}
