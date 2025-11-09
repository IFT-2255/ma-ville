package ca.udem.maville;

public class Account {
    private String numCompte;
    private int solde;

    public Account(String numCompte) {
        this.numCompte = numCompte;
        this.solde = 0;
    }

    public Account(String numCompte, int solde) {
        this.numCompte = numCompte;
        this.solde = solde;
    }

    public String getNumCompte() {
        return numCompte;
    }
    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
    public int getSolde() {
        return solde;
    }
    public void setSolde(int solde) {
        this.solde = solde;
    }
}
