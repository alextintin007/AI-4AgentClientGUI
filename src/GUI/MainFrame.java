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

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private JButton calcularButton;
    public JTextField txtidPagos;
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
    private JTextField txtDireccionCliente;
    private JTextField textField2;
    private JTextField txtNombreCliente;

    //variables globales
    int contVentas=1;
    int contPagos=1;
    int contCliente=1;
    Pagos[] pagos = new Pagos[30];
    Ventas[] ventas = new Ventas[30];
    Cliente[] cliente = new Cliente[1];
    PagosVentas[] pv1 = new PagosVentas[1];

    public MainFrame(){
        setContentPane(mainPanel);
        setTitle("Deber 1");
        setSize(600,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btnIngresarVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean rbnSelection=true;
                if (rbnNo.isSelected()==true){
                    rbnSelection=false;
                }
                ventas[contVentas] = new Ventas(contVentas, 1, Double.parseDouble(txtValorVentas.getText()), rbnSelection,
                        txtFechaVentas.getText(), txtDescripVentas.getText());
                contVentas++;
            }
        });
        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagos[contPagos] = new Pagos(contPagos, 1, Double.parseDouble(txtValorPagos.getText()),txtFechaPagos.getText());
                contPagos++;
            }
        });
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente[contCliente] =  new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241", "xavier.tintin@epn.edu.ec",
                        "Cuenca", "Ecuador", 1, 22, 2, 999, 36, 500);
                contCliente++;

                PagosVentas pv = new PagosVentas(pagos,ventas);

                pv1[0]=pv;
                new Contenedor(pv1,cliente).contenedor();

            }
        });
    }

    public static void main(String[] arg){
        MainFrame myframe = new MainFrame();
    }
}
