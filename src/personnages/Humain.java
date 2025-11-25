package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	
	public Humain(String nom, String boisson, int argent) {
		super();
		this.nom = nom;
		this.boisson = boisson;
		this.argent = argent;
	}
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	public void parler(String texte) {
		System.out.println("(" + getNom() +") -" + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + this.nom + " et j'aime boire du " + this.boisson + ".");
	}
	
	public void boire() {
		parler("Mmmmm, un bon verre de " + this.boisson + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix<=argent) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir un.e " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
		else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un.e " + bien + " à " + prix + " sous.");
		}
	}
	
	private void perdreArgent(int perte) {
		this.argent=this.argent-perte;
	}
	
	private void gagnerArgent(int gain) {
		this.argent=this.argent+gain;
	}
}
