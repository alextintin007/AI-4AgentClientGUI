package agentesc;

import GUI.MainFrame;
import agentes.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contenedor {
    AgentContainer agentContainer;

    public void contenedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile P = new ProfileImpl(null, 1099, null);
        agentContainer=runtime.createMainContainer(P);
        agregarAgentes();
    }
    
    private void agregarAgentes(){
        try{
            MainFrame mainFrame = new MainFrame();
            agentContainer.createNewAgent("ReceptorPagosVentas", Agente3.class.getName(), new Object[]{mainFrame}).start();
            agentContainer.createNewAgent("ReceptorCliente", Agente1.class.getName(), new Object[]{mainFrame}).start();
            //agentContainer.createNewAgent("UnirInfo", Agente2.class.getName(), new Object[]{this,1}).start();
            //agentContainer.createNewAgent("EmisorGUI", Agente4.class.getName(), new Object[]{this,1}).start();
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
