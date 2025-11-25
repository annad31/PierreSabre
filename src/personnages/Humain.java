package personnages;

public class Humain {
	private String nom;
	private String boisson;
	private int argent;
	protected int nbConnaissances;
	protected Humain[] memoire = new Humain[30];
	
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
	
	protected void parler(String texte) {
		System.out.println("(" + getNom() +") - " + texte);
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
	
	protected void perdreArgent(int perte) {
		this.argent=this.argent-perte;
	}
	
	protected void gagnerArgent(int gain) {
		this.argent=this.argent+gain;
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	private void memoriser(Humain humain) {
		if (this.nbConnaissances==30) {
			for(int i=1;i<this.nbConnaissances;i++) {
				memoire[i-1]=memoire[i];
			}
			this.memoire[nbConnaissances-1]=humain;
		}
		
		else {
			this.memoire[nbConnaissances]=humain;
			this.nbConnaissances+=1;
		}
		
	}
	
	public void listerConnaissance() {
		this.parler("Je connais beaucoup de monde dont : ");
		for (int i=0;i<this.nbConnaissances;i++) {
			System.out.print(memoire[i].getNom());
			if(i+1<this.nbConnaissances) {
				System.out.print(", ");
			}
		}
		System.out.println("");
	}
}
