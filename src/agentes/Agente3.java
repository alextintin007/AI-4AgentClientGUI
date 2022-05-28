package agentes;

import GUI.MainFrame;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent{

    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour{

        int contVentas = 0;
        int contPagos = 0;
        boolean terminado=false;

        PagosVentas pyg = new PagosVentas();
        Ventas[] ventas = new Ventas[20];
        Pagos[] pagos = new Pagos[20];

        @Override
        public void action() {
            MainFrame t = (MainFrame)getArguments()[0];
            t.setVisible(true);

            if(t.isBotonVentas()){
                ventas[contVentas]=t.getVenta();
                contVentas++;
                t.setBotonVentas(false);
            }
            if(t.isBotonPagos()){
                pagos[contPagos]=t.getPago();
                contPagos++;
                t.setBotonPagos(false);
            }
            if(t.isBotonCalcular()){
                pyg = new PagosVentas(pagos, ventas);
                pyg.setContPagos(contPagos);
                pyg.setContVentas(contVentas);
                Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", pyg, "COD0302", getAgent());
                t.setBotonCalcular(false);
            }
        }

        @Override
        public boolean done() {
            return terminado;
        }
    }
}
