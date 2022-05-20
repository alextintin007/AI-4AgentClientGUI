/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import contenidoSerializado.Cliente;
import contenidoSerializado.Pagos;
import contenidoSerializado.Ventas;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agente2 extends Agent{

    private String h[]={"",""};

    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    class Comportamiento extends CyclicBehaviour{
        int recEnv=0;
        String cont[]= new String[2];

        @Override
        public void action() {
            //System.out.println(getName());
            ACLMessage msj = blockingReceive();
            String idC = msj.getConversationId();
            if(idC.equalsIgnoreCase("COD0102")){
                try {
                    Cliente cliente = (Cliente) msj.getContentObject();
                    System.out.println(cliente);

                    //guardar en un arreglo el cliente
                    recEnv=1;
                    cont[0]="Datos del Cliente";
                } catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if(idC.equalsIgnoreCase("COD0302")){
                try{
                    Object[] pagosVentas = (Object[])msj.getContentObject();
                    //System.out.println(pagosVentas.length);
                    Pagos pago = (Pagos)pagosVentas[0];
                    Ventas venta = (Ventas)pagosVentas[1];
                    System.out.println(venta);
                    System.out.println(pago);
                    if(recEnv==1){
                        recEnv=2;
                        cont[1]="";
                    }
                }catch (UnreadableException ex) {
                    Logger.getLogger(Agente2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            /*else if(recEnv==2){
                //Mensajes.enviar(ACLMessage.INFORM, "Ag4", "REVISAR PH", "COD0204", getAgent());
                recEnv=0;
            }*/
        }
    }
}
