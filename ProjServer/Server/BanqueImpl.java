package Server;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
public class BanqueImpl extends UnicastRemoteObject implements BanqueInterface {
    private Compte[] comptes; 
    private int nbComptes;  
    private final int MAX_COMPTES = 100; 
    public BanqueImpl() throws RemoteException {
        super();
        comptes = new Compte[MAX_COMPTES];
        nbComptes = 0;
    }
    @Override
    public String creerCompte(Compte c) throws RemoteException {
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getCode() == c.getCode()) {
                return "Status : Compte déjà existant.";
            }
        }
        if (nbComptes < MAX_COMPTES) {
            comptes[nbComptes++] = c;
            return "Status :Compte créé avec succès.";
        } else {
            return "Status :Capacité maximale atteinte. Impossible de créer un nouveau compte.";
        }
    }
    @Override



    public Compte consulterCompte(int code) throws RemoteException {
        for (int i = 0; i < comptes.length; i++) {
            if (comptes[i] != null && comptes[i].getCode() == code) {
                
                return comptes[i];  
            }
        }
        
        System.out.println("Compte non trouvé ou supprimé.");
        return null;
    }
    

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        
        for (int i = 0; i < nbComptes; i++) {
            if (comptes[i].getCode() == code) {
                return comptes[i].toString();
            }
        }
        return "Status :Compte introuvable.";
    }
    public String modifierCompte(int code, double solde, String nom, String prenom) {
        
        for (int i = 0; i < comptes.length; i++) {
            if (comptes[i].getCode() == code) {
                comptes[i].setSolde(solde);
                comptes[i].setNom(nom);
                comptes[i].setPrenom(prenom);
                return "Status : Compte modifié avec succès.";
            }
        }
        return "Status : Compte non trouvé.";
    }
    public String supprimerCompte(int code) {
        
        for (int i = 0; i < comptes.length; i++) {
            if (comptes[i].getCode() == code ) {
                
                comptes[i] = null;
                return "Status : Compte supprimé avec succès.";
            }
        }
        return "Status : Compte non trouvé.";
    }

    @Override
    public double convertirMontant(double mt) throws RemoteException {
        double tauxConversion = 3.3; 
        return mt * tauxConversion;
    }
}



        
        

