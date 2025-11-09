package ca.udem.maville;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String nom;
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return this.accounts;
    }
    public String getNom() {
        return nom;
    }

    public Bank(String nom) {
        this.nom = nom;
    }

    public void createAccount(Account account){
        accounts.add(account);
    }

    public void transaction(String numCompte1, String numCompte2, int montant){
        /*
        Account compte1 = accounts.get(numCompte1);
        Account compte2 = accounts.get(numCompte2);
        compte1.setSolde(compte1.getSolde() - montant);
        compte2.setSolde(compte2.getSolde() + montant);*/
    }

    private Account trouverCompte(String numCompte) {
        for (Account account : accounts) {
            if (numCompte.equals(account.getNumCompte())) {
                return account;
            }
        }
        return null;
    }

    public int retrait(String numCompte, int montant) {
        Account compte = this.trouverCompte(numCompte);
        if (montant < 0) {
            throw new IllegalArgumentException("Montant invalide");
        }
        if (compte.getSolde() < montant) {
            throw new RuntimeException();
        }
        compte.setSolde(compte.getSolde() - montant);
        return compte.getSolde();
    }

    public void supprimerComptes(){
        this.accounts.clear();
    }

    public boolean isLuhn(String numCompte) {
        int somme = 0;
        boolean doubler = false;

        // on parcourt de droite à gauche
        for (int i = numCompte.length() - 1; i >= 0; i--) {
            int num = numCompte.charAt(i) - '0'; // conversion correcte

            if (doubler) {
                num *= 2;
                if (num > 9) num -= 9;
            }

            somme += num;
            doubler = !doubler; // alterne vrai/faux
        }

        return somme % 10 == 0;
    }

}
