package agentes;

import GUI.MainFrame;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Agente3 extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour{

        int contVentas = 0;
        int contPagos = 0;
        boolean terminado=false;

        @Override
        public void action() {

            //PagosVentas pv = new PagosVentas[];
            MainFrame t = (MainFrame)getArguments()[0];
            t.setVisible(true);

            if(t.isBotonVentas()){
                System.out.println("Venta: Mensaje de GUI: "+t.getVenta().toString());
                //enviar al agente 2 los datos
                System.out.println(contVentas);
                contVentas++;
                //Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", t.getClientes(), "COD0102", getAgent());
                t.setBotonVentas(false);
            }
            if(t.isBotonPagos()){
                System.out.println("Pago: Mensaje de GUI: "+t.getPago().toString());
                System.out.println(contPagos);
                contPagos++;
                t.setBotonPagos(false);
            }



//            Object[] pagosVentas = new Object[]{
//                    new Pagos(1,1,100,"2022-10-10"),
//                    new Ventas(1, 1,100,true,"2022-10-10", "Aguacates")};
//            Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", pagosVentas, "COD0302", getAgent());
//            ACLMessage msj = blockingReceive();
//            //System.out.println(msj.getContent());
//            doDelete();
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
