package agentes;

import GUI.MainFrame;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente1 extends Agent{

    @Override
    protected void setup(){ addBehaviour(new Comportamiento());}

    class Comportamiento extends Behaviour{
        boolean terminado = false;

        @Override
        public void action() {
            MainFrame t = (MainFrame)getArguments()[0];
            t.setVisible(true);

            if(t.isBotonCliente()){
                System.out.println(t.getCliente().toString());
                Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", t.getCliente(), "COD0102", getAgent());
                t.setBotonCliente(false);
            }
        }

        @Override
        public boolean done() {
            return terminado;
        }
    }
}
