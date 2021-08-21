package view;

import controller.ControladorRequerimientosReto4;

import model.vo.CompraPorProveedor;
import model.vo.ProyectosCasaCampestre;
import model.vo.AsesorPorCiudad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class VistaRequerimientosReto4 extends JFrame{
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textArea;

    public VistaRequerimientosReto4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 800,620);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbltitulo = new JLabel("Reto 5 UTP");
        lbltitulo.setBounds(28, 6, 81, 16);
        contentPane.add(lbltitulo);

        JLabel lblautor = new JLabel("Jorge Eliecer Olaya León");
        lblautor.setBounds(28, 34, 208, 16);
        contentPane.add(lblautor);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(28, 70, 737, 455);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JButton btnConsuta1 = new JButton("Consulta 1");
        btnConsuta1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        btnConsuta1.setBounds(28, 537, 117, 29);
        contentPane.add(btnConsuta1);

        JButton btnConsuta2 = new JButton("Consulta 2");
        btnConsuta2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        btnConsuta2.setBounds(157, 537, 117, 29);
        contentPane.add(btnConsuta2);

        JButton btnConsuta3 = new JButton("Consulta 3");
        btnConsuta3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        btnConsuta3.setBounds(286, 537, 117, 29);
        contentPane.add(btnConsuta3);

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        btnLimpiar.setBounds(648, 537, 117, 29);
        contentPane.add(btnLimpiar);

    }

    public void requerimiento1(){
        try{
            ArrayList<AsesorPorCiudad> rankingAsesorPorCiudad = controlador.consultarAsesorPorCiudad();
            String salida = "*** Asesor por Ciudad *** \n\nID_Lider\tNombre\tPrimer_Apellido\tResidencia\n\n";
            for (AsesorPorCiudad asesorPorCiudad : rankingAsesorPorCiudad){
                salida += asesorPorCiudad.getIdLider();
                salida += "\t";
                salida += asesorPorCiudad.getNombre();
                salida += "\t";
                salida += asesorPorCiudad.getPrimerApellido();
                salida += "\t\t";
                salida += asesorPorCiudad.getCiudadResidencia();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento2(){
        try{
            ArrayList<ProyectosCasaCampestre> rankingProyectosCasaCampestre = controlador.consultarProyectosCasaCampestre();
            String salida = "*** Proyectos Casa Campestre *** \n\nID_Proyecto\tConstructora\t\tHabitaciones\tCiudad\n\n";
            for (ProyectosCasaCampestre proyectosCasaCampestre : rankingProyectosCasaCampestre){
                salida += proyectosCasaCampestre.getID_Proyecto();
                salida += "\t";
                salida += proyectosCasaCampestre.getConstructora();
                if(proyectosCasaCampestre.getConstructora().length() <= 11){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += proyectosCasaCampestre.getNumero_Habitaciones();
                salida += "\t";
                salida += proyectosCasaCampestre.getCiudad();
                salida += "\n";
            }
            textArea.setText(salida);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public void requerimiento3(){
        try{
            ArrayList<CompraPorProveedor> rankingCompraPorProveedor = controlador.consultarCompraPorProveedor();
            String salida = "*** Compras por Proveedor *** \n\nID_Compra\tProveedor\tConstructora\t\tBanco\t\tCiudad\n\n";
            for (CompraPorProveedor compraPorProveedor : rankingCompraPorProveedor){
                salida += compraPorProveedor.getID_Compra();
                salida += "\t";
                salida += compraPorProveedor.getProveedor();
                salida += "\t";
                salida += compraPorProveedor.getConstructora();
                if(compraPorProveedor.getConstructora().length() <= 11){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += compraPorProveedor.getBanco_Vinculado();
                if(compraPorProveedor.getBanco_Vinculado().length() <= 15){
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += compraPorProveedor.getCiudad();
                salida += "\n";
            } 
            textArea.setText(salida);   
        
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}
