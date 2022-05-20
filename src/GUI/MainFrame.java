package GUI;

import agentesc.Contenedor;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton calcularButton;
    private JTextField txtidPagos;
    private JTextField txtClientePagos;
    private JTextField txtValorPagos;
    private JTextField txtFechaPagos;
    private JTextField txtidVentas;
    private JTextField txtClienteVentas;
    private JTextField txtValorVentas;
    private JTextField txtFechaVentas;
    private JPasswordField txtDescVentas;
    private JRadioButton rbnYes;
    private JRadioButton rbnNo;
    private JTextArea txaMensaje;
    private JButton btnIngresarPagos;
    private JButton btnIngresarVentas;
    private JLabel lblidPagos;
    private JTextField txtDescripVentas;

    //variables globales
    int contVentas=1;
    int contPagos=1;
    public final int SENT_TYPE = 0;
    private GuiAgent owner;

    public MainFrame(){

        setContentPane(mainPanel);
        setTitle("Deber 1");
        setSize(600,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Cliente cliente = new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241", "xavier.tintin@epn.edu.ec",
                "Cuenca", "Ecuador", 1, 22, 2, 999, 36, 500);

        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnIngresarVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean rbnSelection=true;
                if (rbnNo.isSelected()==true){
                    rbnSelection=false;
                }
                Ventas ventas = new Ventas(contVentas, 1, Double.parseDouble(txtValorVentas.getText()), rbnSelection,
                        txtFechaVentas.getText(), txtDescripVentas.getText());

                contVentas++;
            }
        });
        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pagos pagos = new Pagos(contPagos, 1, Double.parseDouble(txtValorPagos.getText()),txtFechaPagos.getText());
                contPagos++;
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txaMensaje.setText("");
            }
        });
    }

    public static void main(String[] arg){
        //MainFrame myframe = new MainFrame();
        new Contenedor().contenedor();
    }
}
