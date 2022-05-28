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

        boolean terminado=false;
        private Cliente m1;
        private PagosVentas m2;
        private Pagos[] pagos;
        private Ventas[] ventas;
        double sumPagos=0;
        double sumVentas=0;
        double monto;
        double montoFinal;
        private String info;

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
                sumPagos=0;
                sumVentas=0;
                //Pagos
                for (int i = 0; i<m2.getContPagos(); i++){
                    sumPagos+=pagos[i].getValorPago();
                }
                //Ventas
                for (int i = 0; i<m2.getContVentas(); i++){
                    if(ventas[i].isIsIva()){
                        sumVentas+=(ventas[i].getValor()*1.12);
                    }
                    else {
                        sumVentas+=ventas[i].getValor();
                    }
                }
                //Calcular cupoVenta
                montoFinal=monto+sumVentas-sumPagos;

                //Mensaje de salida
                info=m1.toString()+"\nNumero de Ventas: "+m2.getContVentas()+"\nNumero de Pagos: "+m2.getContPagos();
                if(montoFinal<0){
                    t.setTxaMensaje(info+"\nTiene deuda de: "+montoFinal);
                }
                else {
                    t.setTxaMensaje(info+"\nMonto final: "+montoFinal);
                }
            } catch (UnreadableException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public boolean done() {
            return terminado;
        }
    }
}
