package Server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueInterface extends Remote {
    String creerCompte(Compte c) throws RemoteException;
    Compte consulterCompte(int code) throws RemoteException;
    String getInfoCompte(int code) throws RemoteException;
    double convertirMontant(double mt) throws RemoteException;
    String modifierCompte(int code, double solde, String nom, String prenom) throws RemoteException;
    String supprimerCompte(int code) throws RemoteException;
}



