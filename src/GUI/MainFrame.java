package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;
import javax.swing.JButton;

public class MainFrame extends JFrame implements Serializable {
    private JPanel mainPanel;
    private JButton btnCalcular;
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
    private JTextField txtDireccionCliente;
    private JTextField txtTelefonoCliente;
    private JTextField txtNombreCliente;
    private JTextField txtEdadCliente;
    private JTextField txtMontoCliente;
    private JTextField txtApellidoCliente;
    private JTextField txtPlazoCliente;
    private JTextField txtEmailCliente;
    private JTextField txtIDCliente;
    private JTextField txtVendedorCliente;
    private JTextField txtCiudadCliente;
    private JTextField txtPaisCliente;
    private JTextField txtZipCliente;
    private JPanel panelPagos;
    private JPanel panelVentas;
    private JPanel panelCliente;
    private JPanel panelMensaje;
    private JButton btnCliente;

    //variables globales
    int contVentas=0;
    int contPagos=0;
    private boolean botonCliente;
    private boolean botonPagos;
    private boolean botonVentas;
    private boolean botonCalcular;

    //Clases globales
    private Cliente cliente;
    private PagosVentas pyg;
    private PagosVentas[] pagosVentas= new PagosVentas[30];

    //getters and setters Cliente, pagosventa
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PagosVentas[] getPagosVentas() {
        return pagosVentas;
    }

    public void setPagosVentas(PagosVentas[] pagosVentas) {
        this.pagosVentas = pagosVentas;
    }

    //Boton Cliente
    public boolean isBotonCliente() {
        return botonCliente;
    }
    private boolean pressBotonCliente(){
        return true;
    }
    public void setBotonCliente(boolean botonCliente){
        this.botonCliente = botonCliente;
    }

    //Boton Pagos
    public boolean isBotonPagos(){
        return botonPagos;
    }
    private boolean pressBotonPagos(){
        return botonPagos;
    }
    public void setBotonPagos(boolean botonPagos){
        this.botonPagos = botonPagos;
    }

    //Boton Ventas
    public boolean isBotonVentas(){
        return botonVentas;
    }
    private boolean pressBotonVentas(){
        return botonVentas;
    }
    public void setBotonVentas(boolean botonVentas){
        this.botonVentas = botonVentas;
    }

    //Boton Calcular
    public boolean isBotonCalcular(){
        return botonCalcular;
    }
    private boolean pressBotonCalcular(){
        return botonCalcular;
    }
    public void setBotonCalcular(boolean botonVentas){
        this.botonCalcular = botonCalcular;
    }


    public MainFrame(){
        //Init mainFrame
        setContentPane(mainPanel);
        setTitle("Agentes-GUI");
        setSize(600,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Set the initial state of the mainframe
//        Cliente primerCliente =  new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241",
//                "xavier.tintin@epn.edu.ec", "Cuenca", "Ecuador", 1, 22, 2, 999,
//                36, 500);
//        Pagos primerPagos = new Pagos(1,1,100,"2022-10-10");
//        Ventas primeraVenta= new Ventas(1, 1,100,true,"2022-10-10", "Aguacates");
//        pyg=new PagosVentas();
//        pyg.nuevoPago(contPagos,primerPagos);
//        pyg.nuevoVentas(contVentas,primeraVenta);
//        pagosVentas[0]=pyg;
//
//
//        contPagos++;
//        contVentas++;

        //Actions Performed by Buttons
        btnIngresarVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sales Button pressed");             //se ingresa el numero de ventas que se desee
//                Ventas venta=new Ventas(contVentas, Integer.parseInt(txtIDCliente.getText()), Double.parseDouble(txtValorVentas.getText()), true, txtFechaVentas.getText(), txtDescripVentas.getText());
//                boolean rbnSelection=true;
//                if (rbnNo.isSelected()){
//                    rbnSelection=false;
//                }
                Ventas primeraVenta= new Ventas(1, 1,100,true,"2022-10-10", "Aguacates");

                pyg.nuevoVentas(contVentas,primeraVenta);
                contVentas++;

                botonVentas = pressBotonVentas();
            }
        });
        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Payment Button pressed");           //se ingresan el numero de pagos que se desee
                //Pagos pago = new Pagos(contPagos, Integer.parseInt(txtIDCliente.getText()), Double.parseDouble(txtValorPagos.getText()),txtFechaPagos.getText());

                Pagos primerPagos = new Pagos(1,1,100,"2022-10-10");

                pyg.nuevoPago(contPagos,primerPagos);
                contPagos++;

                botonPagos = pressBotonPagos();
            }
        });
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Client Button pressed");            //se ingresan los datos del cliente una sola vez
//                Cliente cliente=new Cliente(txtNombreCliente.getText(),txtApellidoCliente.getText(),txtDireccionCliente.getText(),
//                        txtTelefonoCliente.getText(),txtEmailCliente.getText(),txtCiudadCliente.getText(),"Ecuador",
//                        Integer.parseInt(txtIDCliente.getText()),Integer.parseInt(txtEdadCliente.getText()),123,
//                        Integer.parseInt(txtZipCliente.getText()),Integer.parseInt(txtPlazoCliente.getText()),Double.parseDouble(txtMontoCliente.getText()));
//                JOptionPane.showMessageDialog(rootPane, "Client Button");

                setCliente(new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241",
                        "xavier.tintin@epn.edu.ec", "Cuenca", "Ecuador", 1, 22, 2, 999,
                        36, 500));

                botonCliente = pressBotonCliente();
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Set components of the first state to visualize in GUI
                System.out.println("Calculate Button Pressed");         //llama al agente 4 para que se realicen los calculos
                botonCalcular = pressBotonCalcular();
            }
        });
    }
}
