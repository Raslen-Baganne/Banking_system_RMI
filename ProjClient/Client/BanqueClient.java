import Server.BanqueInterface;
import Server.Compte;
import java.rmi.Naming;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BanqueClient {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException{
        String url = "rmi://localhost:1099/RMI";
        BanqueInterface banque = (BanqueInterface) Naming.lookup(url);
        System.out.println("Client Connected");
        Scanner scanner = new Scanner(System.in);
        int iterations = 10; 
        for (int i = 0; i < iterations; i++) {
            System.out.println("\n=== Menu Banque ===");
            System.out.println("1. Créer un compte");
            System.out.println("2. Consulter un compte");
            System.out.println("3. Convertir un montant (EUR -> TND)");
            System.out.println("4. Modifier un compte");
            System.out.println("5. Supprimer un compte");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            switch (choix) {
                case 1 -> {
                    System.out.print("Entrez le code du compte : ");
                    int code = scanner.nextInt();
                    System.out.print("Entrez le nom du titulaire du compte : ");
                    String nom = scanner.next();
                    System.out.print("Entrez le prénom du titulaire du compte : ");
                    String prenom = scanner.next();
                    System.out.print("Entrez le solde initial : ");
                    double solde = scanner.nextDouble();
                    Compte compte = new Compte(code,nom, prenom, solde, new java.util.Date());
                    String resultat = banque.creerCompte(compte);
                    System.out.println(resultat);
                }
                case 2 -> {
                    System.out.print("Entrez le code du compte : ");
                    int code = scanner.nextInt();
                    Compte compte = banque.consulterCompte(code);
                    if (compte != null) {
                        System.out.println("Détails du compte : " + compte);
                    } else {
                        System.out.println("Compte introuvable.");
                    }
                }
                case 3 -> {
                    System.out.print("Entrez le montant en EUR : ");
                    double montant = scanner.nextDouble();
                    double montantConverti = banque.convertirMontant(montant);
                    System.out.println("Montant en TND : " + montantConverti);
                }
                case 4 -> {
                    System.out.print("Entrez le code du compte à modifier : ");
                    int codeModification = scanner.nextInt();
                    System.out.print("Entrez le nouveau solde : ");
                    double nouveauSolde = scanner.nextDouble();
                    System.out.print("Entrez le nouveau nom : ");
                    String nouveauNom = scanner.next();
                    System.out.print("Entrez le nouveau prénom : ");
                    String nouveauPrenom = scanner.next();
                    String resultatModification = banque.modifierCompte(codeModification, nouveauSolde, nouveauNom, nouveauPrenom);
                    System.out.println(resultatModification);
                }
                case 5 ->{
                    System.out.print("Entrez le code du compte à supprimer : ");
                    int codeSuppression = scanner.nextInt();
                    String resultatSuppression = banque.supprimerCompte(codeSuppression);
                    System.out.println(resultatSuppression);
                }
                case 6 -> {
                    System.out.println("Au revoir !");
                    System.exit(0);
                }
                default -> System.out.println("Choix invalide.");
            }
        }
        scanner.close();
    }
}

    
        
           
            


            

                


                        



                        

                        














