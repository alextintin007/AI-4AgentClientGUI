package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;

import java.util.concurrent.Semaphore;
import javax.swing.JButton;

public class MainFrame extends JFrame {
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

    //Getters of buttons
    public JButton getBtnIngresarPagos() {
        return btnIngresarPagos;
    }

    public JButton getBtnIngresarVentas() {
        return btnIngresarVentas;
    }

    public JButton getBtnCliente() {
        return btnCliente;
    }
    public JButton getCalcularButton() {
        return btnCalcular;
    }

    //action listeners for buttons
    public class BotonClienteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Client Button pressed");
            Cliente cliente=new Cliente(txtNombreCliente.getText(),txtApellidoCliente.getText(),txtDireccionCliente.getText(),
                    txtTelefonoCliente.getText(),txtEmailCliente.getText(),txtCiudadCliente.getText(),"Ecuador",
                    Integer.parseInt(txtIDCliente.getText()),Integer.parseInt(txtEdadCliente.getText()),123,
                    Integer.parseInt(txtZipCliente.getText()),Integer.parseInt(txtPlazoCliente.getText()),Double.parseDouble(txtMontoCliente.getText()));
            JOptionPane.showMessageDialog(rootPane, "Client Button");
            botonC=true;
            semaphore.release();
        }
    }
    private class BotonVentaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Sales Button pressed");
            Ventas venta=new Ventas(contVentas, 1, Double.parseDouble(txtValorVentas.getText()), true, txtFechaVentas.getText(), txtDescripVentas.getText());
            //pasar al agente 3
            pyg.nuevoVentas(contVentas, venta);
            contVentas++;
        }
    }
    private class BotonPagoListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Payment Button pressed");
            Pagos pago=new Pagos(contPagos, 1, Double.parseDouble(txtValorPagos.getText()), txtFechaPagos.getText());
            //pasar al agente 3
            pyg.nuevoPago(contPagos, pago);
            contPagos++;
        }
    }

    //variables globales
    int contVentas=0;
    int contPagos=0;
    boolean botonC=false;

    //Clases globales
    private Cliente clientes;
    private PagosVentas pyg;
    private PagosVentas[] pagosVentas= new PagosVentas[30];

    //
    Semaphore semaphore;

    //getters and setters Cliente, pagosventa
    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public PagosVentas[] getPagosVentas() {
        return pagosVentas;
    }

    public void setPagosVentas(PagosVentas[] pagosVentas) {
        this.pagosVentas = pagosVentas;
    }

    public boolean isBotonC() {
        return botonC;
    }


    public MainFrame(){
        //Init mainFrame
        setContentPane(mainPanel);
        setTitle("Deber 1");
        setSize(600,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Set the initial state of the mainframe
        Cliente primerCliente =  new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241",
                "xavier.tintin@epn.edu.ec", "Cuenca", "Ecuador", 1, 22, 2, 999,
                36, 500);
        Pagos primerPagos = new Pagos(1,1,100,"2022-10-10");
        Ventas primeraVenta= new Ventas(1, 1,100,true,"2022-10-10", "Aguacates");
        pyg=new PagosVentas();
        pyg.nuevoPago(contPagos,primerPagos);
        pyg.nuevoVentas(contVentas,primeraVenta);
        pagosVentas[0]=pyg;

        //Set components of the first state to visualize in GUI
        txaMensaje.setText(primerCliente.toString()+"\n"+
                pagosVentas[0].getPago(0).toString()+"\n"+
                pagosVentas[0].getVenta(0).toString());
        contPagos++;
        contVentas++;


        btnIngresarVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //el objeto que ya esta creado se pase al agente 3
                boolean rbnSelection=true;
                if (rbnNo.isSelected()){
                    rbnSelection=false;
                }
                Ventas venta = new Ventas(contVentas, 1, Double.parseDouble(txtValorVentas.getText()), rbnSelection, txtFechaVentas.getText(), txtDescripVentas.getText());
                pyg.nuevoVentas(contVentas,venta);
                contVentas++;
            }
        });
        btnIngresarPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //el objeto que ya esta creado se pase al agente 3
                Pagos pago = new Pagos(contPagos, 1, Double.parseDouble(txtValorPagos.getText()),txtFechaPagos.getText());
                pyg.nuevoPago(contPagos,pago);
                contPagos++;
            }
        });
        btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //se ingresan los datos del cliente una sola vez
//                cliente[0] =  new Cliente("Xavier", "Tintin", "Don Bosco", "0999345241", "xavier.tintin@epn.edu.ec", "Cuenca", "Ecuador", 1, 22, 2, 999, 36, 500);
//                PagosVentas pv = new PagosVentas(pagos,ventas);
//                pv1[0]=pv;
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llama al agente 4 para que se realicen los calculos
            }
        });
    }
}
