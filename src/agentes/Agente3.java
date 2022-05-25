package agentes;

import GUI.MainFrame;
import agentesc.Contenedor;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Agente3 extends Agent{
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
        boolean terminado=false;

        @Override
        public void action() {
            //System.out.println(getName());
            //terminado=true;
            //Ventas[]  = new Ventas()[]{};

            //PagosVentas pv = new PagosVentas[][];
            MainFrame t = (MainFrame)getArguments()[0];
            t.setVisible(true);
            //t.getBtnCliente().addActionListener(t.new BotonClienteListener());

            if(t.isBotonCliente()){
                System.out.println("Mensaje de GUI: "+t.getCliente().toString());
                //emviar al agente 2 los datos
                //Mensajes.enviarS(ACLMessage.INFORM, "UnirInfo", t.getClientes(), "COD0102", getAgent());
                t.setBotonCliente(false);
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
