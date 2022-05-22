package agentesc;

import agentes.Agente1;
import agentes.Agente2;
import agentes.Agente3;
import contenidoSerializado.Cliente;
import contenidoSerializado.PagosVentas;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenedor {
    AgentContainer agentContainer;
    private PagosVentas[] pagosVentas;
    private Cliente[] clientes;

    public Contenedor(PagosVentas[] pagosVentas, Cliente[] clientes) {
        this.pagosVentas=pagosVentas;
        this.clientes=clientes;
    }

    public void contenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile P = new ProfileImpl(null, 1099, null);
        agentContainer=runtime.createMainContainer(P);
        agregarAgentes();
    }
    
    private void agregarAgentes(){
        try{
            agentContainer.createNewAgent("ReceptorInfoClientePagosVentas", Agente3.class.getName(), null).start();
            agentContainer.createNewAgent("ReceptorInfoCliente", Agente1.class.getName(), new Object[]{this,1}).start();
            agentContainer.createNewAgent("UnirInfo", Agente2.class.getName(), new Object[]{this,1}).start();
        } catch(StaleProxyException ex){
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearHijos(String alias, Object[] conocimiento){
        try{
            agentContainer.createNewAgent(alias, Agente1.class.getName(), conocimiento).start();
        } catch(StaleProxyException ex){
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
