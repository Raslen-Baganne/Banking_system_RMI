package Server;
import java.rmi.registry.LocateRegistry;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.io.IOException;


public class BanqueServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, IOException {
        
            
            BanqueImpl banque = new BanqueImpl();

            
            LocateRegistry.createRegistry(1099);

           
            Naming.rebind("rmi://localhost:1099/RMI", banque);

            System.out.println("Serveur Banque démarré et en attente de connexions...");
         
        
    }
}



