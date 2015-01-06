import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
 
public abstract class Vista3 extends Vista1 {
 
    protected VistaBuscador vb;
    protected VistaBuscador vciut;
   
    protected JPanel panelv3;
    protected JPanel panelLista;
    protected JPanel panelBotones;
    protected JPanel panelCrear;
   
    protected JButton botonCargar;
    protected JButton botonGuardar;
    protected JButton botonModificar;
    protected JButton botonEliminar;
    protected JButton botonCrear;
   
    protected JTextField txtXMapa;
    protected JTextField txtYMapa;
    protected JTextField txtConti;
    protected JTextField txtCap;
   
    protected JLabel label1;
    protected JLabel label2;
    protected JLabel label3;
   
    protected JPanel panelCiudad;
    protected JPanel panelCaminos;
   
    protected JTextField txtIdCiutat;
    protected JTextField txtY;
    protected JTextField txtX;
    protected JTextField txtCO;
    protected JTextField txtCD;
    protected JTextField txtMedio;
   
    protected JLabel label4;
    protected JLabel label5;
    protected JLabel label6;
    protected JLabel label7;
   
    protected JButton botoncaC;
    protected JButton botonciC;
    protected JButton botoncaG;
    protected JButton botonciG;
    
    protected VistaMatriz vMatriz;
   
  
   
   
    public Vista3() {
        super();
        
        
        
        //#########################################
    	//##########vciut
        //#########################################
        //p.fill = GridBagConstraints.HORIZONTAL;
        //p.gridx = 0;
        
        GridBagConstraints pVCiut = new GridBagConstraints();
        
        //pVCiut.gridheight = 5;
        pVCiut.gridx = 0;
        //pVCiut.gridy = 0;
        pVCiut.fill = GridBagConstraints.BOTH;
       
        
        JPanel cams = new JPanel();
        cams.setLayout(new GridBagLayout());
        
        vciut = new VistaBuscador(this);
        //panel que engloba a todos
        
        JPanel aux1 = new JPanel();
        
        botoncaC = new JButton("Cargar");
        botoncaG = new JButton("Guardar");
        
        aux1.add(botoncaC);
        aux1.add(botoncaG);
        
        JLabel cami  = new JLabel();
        
        cami.setText("Caminos");
        cami.setFont(new Font("Verdana",1,15));
        cami.setForeground(Color.darkGray);
        
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        
        cams.add(cami,c);
        
        GridBagConstraints c1 = new GridBagConstraints();
        c1.gridy = 1;
        c1.fill = GridBagConstraints.BOTH;
        
        cams.add(vciut,c1);
        
        GridBagConstraints c2 = new GridBagConstraints();
        c2.gridy = 2;
        
        cams.add(aux1,c2);
        
        
        
        
        super.panelPrincipal.add(cams,pVCiut);
        
        
        //#########################################
    	//##########panelv3
        //#########################################
        
        //p.gridheight = 3;
        
        GridBagConstraints PV3 = new GridBagConstraints();
        
        PV3.gridx = 1;
        //PV3.gridy = 0;
        
        panelv3 = new JPanel();
        panelv3.setLayout(new GridBagLayout());
        //panelv3.setBorder(BorderFactory.createEmptyBorder(10,20,15,20));
        
        //panellmapa
        TitledBorder Mapa;
        Mapa = BorderFactory.createTitledBorder("Mapa: ");
        panelLista = new JPanel();
        panelLista.setBorder(BorderFactory.createTitledBorder(Mapa));
        panelLista.setMinimumSize(new Dimension(700,100));
        panelLista.setMaximumSize(new Dimension(700,100));
       
        txtXMapa = new JTextField();
        txtXMapa.setPreferredSize(new Dimension(70,30));
        txtXMapa.setEditable(true);
        txtYMapa = new JTextField();
        txtYMapa.setPreferredSize(new Dimension(70,30));
        txtYMapa.setEditable(true);
        label1 = new JLabel();
        label2 = new JLabel();
        label1.setText("X: ");
        label2.setText("Y: ");
        label3 = new JLabel();
        label3.setText("Continente: ");
        txtConti = new JTextField();
        txtConti.setPreferredSize(new Dimension(400,30));
        txtConti.setEditable(true);
        
        panelLista.add(label1);
        panelLista.add(txtXMapa);
        panelLista.add(label2);
        panelLista.add(txtYMapa);
        panelLista.add(label3);
        panelLista.add(txtConti);
       
        //panell Ciutat
        TitledBorder Ciudad;
        Ciudad = BorderFactory.createTitledBorder("Ciudad: ");
        panelCiudad = new JPanel();
        panelCiudad.setBorder(BorderFactory.createTitledBorder(Ciudad));
        panelCiudad.setMinimumSize(new Dimension(700,100));
        panelCiudad.setMaximumSize(new Dimension(700,100));
        //panelLista.setBorder(Ciudad);
        txtIdCiutat = new JTextField();
        txtIdCiutat.setPreferredSize(new Dimension(100,30));
        txtIdCiutat.setEditable(true);
        label1 = new JLabel();
        label1.setText("Nombre: ");
        label2 = new JLabel();
        label2.setText("X: ");
        label3 = new JLabel();
        label3.setText("Y: ");
        txtX = new JTextField();
        txtX.setPreferredSize(new Dimension(100,30));
        txtX.setEditable(true);
        txtY = new JTextField();
        txtY.setPreferredSize(new Dimension(100,30));
        txtY.setEditable(true);
               
        panelCiudad.add(label1);
        panelCiudad.add(txtIdCiutat);
        panelCiudad.add(label2);
        panelCiudad.add(txtX);
        panelCiudad.add(label3);
        panelCiudad.add(txtY);
 
        //panel Camino
        TitledBorder Camino;
        Camino = BorderFactory.createTitledBorder("Camino: ");
        panelCaminos = new JPanel();
        panelCaminos.setBorder(BorderFactory.createTitledBorder(Camino));
        panelCaminos.setMinimumSize(new Dimension(700,100));
        panelCaminos.setMaximumSize(new Dimension(700,100));
        txtCO = new JTextField();
        txtCO.setPreferredSize(new Dimension(80,30));
        txtCO.setEditable(true);
        label4 = new JLabel();
        label4.setText("Ciudad de Origen: ");
        label5 = new JLabel();
        label5.setText("Ciudad de Destino: ");
        label6 = new JLabel();
        label6.setText("Medio de Transporte: ");
        txtCD = new JTextField();
        label7 = new JLabel();
        label7.setText("Capacidad: ");
        txtCap = new JTextField();
        txtCap.setPreferredSize(new Dimension(80,30));
        txtCD.setEditable(true);
        txtCD.setPreferredSize(new Dimension(80,30));
        txtCD.setEditable(true);
        txtMedio = new JTextField();
        txtMedio.setPreferredSize(new Dimension(80,30));
        txtMedio.setEditable(true);
        
        panelCaminos.add(label4);
        panelCaminos.add(txtCO);
        panelCaminos.add(label5);
        panelCaminos.add(txtCD);
        panelCaminos.add(label6);
        panelCaminos.add(txtMedio);
        panelCaminos.add(label7);
        panelCaminos.add(txtCap);
        
        //panel Botones
        panelBotones = new JPanel();
        panelBotones.setBorder(BorderFactory.createLoweredBevelBorder());
        panelBotones.setMinimumSize(new Dimension(700,50));
        panelBotones.setMaximumSize(new Dimension(700,50));
        botonCargar = new JButton();
        botonGuardar = new JButton();
        botonModificar = new JButton();
        botonEliminar = new JButton();
        botonCrear = new JButton();
        botonGuardar.setText("Guardar");
        botonCargar.setText("Cargar");
        botonModificar.setText("Modificar");
        botonEliminar.setText("Eliminar");
        botonCrear.setText("Crear");
        panelBotones.add(botonCrear);
        panelBotones.add(botonModificar);
        panelBotones.add(botonEliminar);
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCargar);
        
    	//##########VistaMatriz
        vMatriz = new VistaMatriz();
        //vMatriz.main(null);
        vMatriz.setMinimumSize(new Dimension(350,350));
        
        vMatriz.setMaximumSize(new Dimension(350,350));
        
        //vMatriz.setSize(350, 350);
        
        
        GridBagConstraints vM = new GridBagConstraints();
        vM.gridy = 0;
        panelv3.add(vMatriz,vM);
        //JFrame vMat = new JFrame();
        //vMat.add(vMatriz);
        
        //vMat.setSize(510, 530);
        
        
        GridBagConstraints pL = new GridBagConstraints();
        pL.gridy = 1;
                       
        panelv3.add(panelLista, pL);
        
        GridBagConstraints pC = new GridBagConstraints();
        pC.gridy = 2;
        
        panelv3.add(panelCiudad, pC);
        
        GridBagConstraints pCams = new GridBagConstraints();
        pCams.gridy = 3;
        
        panelv3.add(panelCaminos, pCams);
        
        GridBagConstraints pB = new GridBagConstraints();
        pB.gridy = 4;
        
        panelv3.add(panelBotones, pB);
        
        super.panelPrincipal.add(panelv3,PV3);
        
        //#########################################
    	//##########vb
        //#########################################
        
        GridBagConstraints vB = new GridBagConstraints();
        vB.gridx = 2;
        vB.fill = GridBagConstraints.BOTH;
        
        
        JPanel ciuts = new JPanel();
        ciuts.setLayout(new GridBagLayout());
        
        vb = new VistaBuscador(this);
        
        JPanel aux2 = new JPanel();
        
        botonciC = new JButton("Cargar");
        botonciG = new JButton("Guardar");
        
        aux2.add(botonciC);
        aux2.add(botonciG);
        
        JLabel ciud = new JLabel();
        
        ciud.setText("Ciudades");
        ciud.setFont(new Font("Verdana",1,15));
        ciud.setForeground(Color.darkGray);
        
        GridBagConstraints v1 = new GridBagConstraints();
        v1.gridy = 0;
        
        ciuts.add(ciud,v1);
        
        GridBagConstraints v2 = new GridBagConstraints();
        v2.gridy = 1;
        //vb.setMinimumSize(new Dimension(50, 200));
        
        ciuts.add(vb,v2);
        
        GridBagConstraints v3 = new GridBagConstraints();
        v3.gridy = 2;
        
        ciuts.add(aux2,v3);

        super.panelPrincipal.add(ciuts,vB);
       
    }
}
