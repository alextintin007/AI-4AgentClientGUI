package agentes;

import GUI.MainFrame;
import agentesc.Contenedor;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agente1 extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());

    }

    @Override
    protected void takeDown(){
        Contenedor c = (Contenedor)getArguments()[0];
        int i = Integer.parseInt(getArguments()[1].toString());
        i++;
        c.crearHijos("AgenteHijo"+i, new Object[]{c,i});
        System.out.println("Morir");
    }
    class Comportamiento extends Behaviour{
        boolean terminado = true;
        @Override
        public void action() {
            //System.out.println(getName());
            //terminado=true;
            //Mensajes.enviar(ACLMessage.INFORM, "BuscarDatos", "56", "COD0102", getAgent());
            MainFrame name = new MainFrame();
            String nombre= JOptionPane.showInputDialog("Ingrese ");
            Cliente cliente = new Cliente(nombre,"Paz","Ladron de Guevara", "099999999", "henry.paz@epn.edu.ec", "Quito"
            , "Ecuador", 1, 2, 170170, 15, 5000, 25);
            
            Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", cliente, "COD0102", getAgent());
            ACLMessage msj = blockingReceive();
            System.out.println(msj.getContent());

            //doDelete();
        }

        public String JOPtions(String entrada) {
            String var = "2";
            try {
                String cmd = "python src\\PanePython\\JOptionPane.py " + entrada;



                Process p = Runtime.getRuntime().exec(cmd);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                p.waitFor();
                p.destroy();
                var = br.readLine();



            } catch (IOException ex) {
                Logger.getLogger(Agente1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Agente1.class.getName()).log(Level.SEVERE, null, ex);
            }
            return var;
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
