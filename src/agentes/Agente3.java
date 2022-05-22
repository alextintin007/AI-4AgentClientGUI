package agentes;

import agentesc.Contenedor;
import contenidoSerializado.Pagos;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    //global variables
    int pSUM = 0;
    
    @Override
    protected void takeDown(){
        Contenedor c = (Contenedor)getArguments()[0];
        int i = Integer.parseInt(getArguments()[1].toString());
        i++;
        c.crearHijos("AgenteHijo"+i, new Object[]{c,i});
        System.out.println("Morir");
    }
    class Comportamiento extends Behaviour{
        boolean terminado=true;

        @Override
        public void action() {
            //System.out.println(getName());
            //terminado=true;
            //Ventas[]  = new Ventas()[]{};

            //PagosVentas pv = new PagosVentas[][];

            Object[] pagosVentas = new Object[]{
                    new Pagos(1,1,100,"2022-10-10"),
                    new Ventas(1, 1,100,true,"2022-10-10", "Aguacates")};
            Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", pagosVentas, "COD0302", getAgent());
            ACLMessage msj = blockingReceive();
            //System.out.println(msj.getContent());
            doDelete();
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
