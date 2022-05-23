//package agentes;
//
//import GUI.MainFrame;
//import contenidoSerializado.Pagos;
//import contenidoSerializado.Ventas;
//import jade.core.behaviours.Behaviour;
//import jade.core.behaviours.CyclicBehaviour;
//import jade.gui.GuiAgent;
//import jade.gui.GuiEvent;
//import jade.lang.acl.ACLMessage;
//
//public class AgenteGUI extends GuiAgent {
//    public void setup(){
//        CyclicBehaviour cb = new Comportamiento(this);
//        addBehaviour(cb);
//        MainFrame Gui = new MainFrame(this);
//        Gui.setVisible(true);
//    }
//
//    class Comportamiento extends CyclicBehaviour {
//
//        boolean terminado=false;
//
//        public Comportamiento(GuiAgent ga) {
//            super(ga);
//        }
//
//        @Override
//        public void action() {
//        }
//    }
//
//    @Override
//    protected void onGuiEvent(GuiEvent ge) {
//        //GuiEvent ge = new GuiEvent(this, SENT_TYPE);
//        String Nombre=(String) ge.getParameter (0) ;
//        String Apellido= (String) ge.getParameter(1);
//        String Direccion = (String) ge.getParameter(2);
//        String Telefono= (String) ge.getParameter(3);
//        String Correo=(String) ge.getParameter(4);
//        String Ciudad=(String)ge.getParameter(5);
//        String Pais = (String) ge.getParameter(6);
//        String Id= (String) ge.getParameter(7);
//        String IdVendedor=(String) ge.getParameter(8);
//        String zip= (String) ge.getParameter(9);
//        String Plazo= (String) ge.getParameter (10) ;
//        String Monto= (String) ge.getParameter(11);
//        String IDpago = (String)ge.getParameter (12) ;
//        String IDclienteP=(String)ge.getParameter(13);
//        String valor = (String)ge.getParameter(14);
//        String fechaP=(String)ge.getParameter(15);
//        String IDventa=(String)ge.getParameter(16);
//        String IDclienteV = (String)ge.getParameter (17) ;
//        String NumFac=(String)ge.getParameter(18);
//        String Valorv=(String)ge.getParameter(19);
//        String IVA=(String)ge.getParameter(20);
//        String Fechav=(String)ge.getParameter(21);
//        String Desc=(String)ge.getParameter(22);
//        owner.
//    }
//}
