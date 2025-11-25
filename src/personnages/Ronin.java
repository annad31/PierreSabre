package personnages;

public class Ronin extends Humain {
	private int honneur=1;
	
	public Ronin(String nom, String boisson, int argent) {
		super(nom,boisson,argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int don = (10*this.getArgent())/100;
		parler(beneficiaire.getNom() + " prend ces " + don + " sous.");
		this.perdreArgent(don);
		beneficiaire.recevoir(don);
	}
}
