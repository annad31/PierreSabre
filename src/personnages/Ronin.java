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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		int force=4*this.honneur;
		if (force>=adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza !");
			int gain=adversaire.perdre();
			this.gagnerArgent(gain);
			this.honneur=honneur+1;
		}
		else {
			int perte=this.getArgent();
			this.perdreArgent(perte);
			adversaire.gagner(perte);
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup");
		}
	}
}
