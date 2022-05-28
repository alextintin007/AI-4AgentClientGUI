package agentes;

import GUI.MainFrame;
import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.PagosVentas;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

public class Agente4 extends Agent{
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends Behaviour{

        boolean terminado=true;
        private Cliente m1;
        private PagosVentas m2;
        private Pagos[] pagos;
        private Ventas[] ventas;
        double sumPagos=0;
        double sumVentas=0;
        double monto;
        double montoFinal;

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            try {
                MainFrame t = (MainFrame)getArguments()[0];
                Object[] obj = (Object[]) msj.getContentObject();
                m1 = (Cliente) obj[0];
                m2 = (PagosVentas) obj[1];
                pagos = m2.getPagos();
                ventas = m2.getVentas();
                //Monto
                monto=m1.getMonto();
                //Pagos
                for (int i= 0; i<m2.getContPagos(); i++){
                    sumPagos+=pagos[i].getValorPago();
                }
                //Ventas
                for (int i= 0; i<m2.getContVentas(); i++){
                    sumVentas+=ventas[i].getValor();
                }
                //Calcular cupoVenta
                montoFinal=monto+sumVentas-sumPagos;
                if(montoFinal<0){

                }
                else {
                    t.setTxaMensaje("Monto final: "+montoFinal);
                }
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }

            //Mensajes.enviar(ACLMessage.INFORM, "BuscarDatos", "Ata", "COD0302", getAgent());
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
