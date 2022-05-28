package agentes;

import contenidoSerializado.Cliente;
import contenidoSerializado.PagosVentas;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agente2 extends Agent{

    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour{
        private int check=0;
        private Cliente m1;
        private PagosVentas m2;

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();
            if(idC.equalsIgnoreCase("COD0102")){
                try {
                    m1 = (Cliente) msj.getContentObject();
                    check++;
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(idC.equalsIgnoreCase("COD0302")){
                try{
                    m2 = (PagosVentas)msj.getContentObject();
                    check++;
                }catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(check>=2){
                System.out.println("Enviar al agente 4");
                Mensajes.enviarS(ACLMessage.INFORM, "EmisorGUI", new Object[] {m1,m2}, "COD0204", getAgent());
            }
        }
    }
}
