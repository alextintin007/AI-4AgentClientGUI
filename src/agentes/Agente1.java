package agentes;

import GUI.MainFrame;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Agente1 extends Agent{

    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{

        boolean terminado = false;

        @Override
        public void action() {
            //System.out.println(getName());
            //terminado=true;
            //Mensajes.enviar(ACLMessage.INFORM, "BuscarDatos", "56", "COD0102", getAgent());
            MainFrame t = (MainFrame)getArguments()[0];
            t.setVisible(true);
            //t.getBtnCliente().addActionListener(t.new BotonClienteListener());

            if(t.isBotonCliente()){
                System.out.println("Mensaje de GUI: "+t.getCliente().toString());
                //emviar al agente 2 los datos
                //Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", t.getClientes(), "COD0102", getAgent());
                t.setBotonCliente(false);
            }
            //System.out.println(t.getClientes());


//            Cliente cliente1 = new Cliente("test","Paz","Ladron de Guevara", "099999999", "henry.paz@epn.edu.ec", "Quito", "Ecuador", 1, 2, 170170, 15, 5000, 25);
//            Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", cliente1, "COD0102", getAgent());
//            ACLMessage msj = blockingReceive();
//            System.out.println(msj.getContent());
            //doDelete();
        }

        @Override
        public boolean done() {
            return terminado;
        }
    }
}
