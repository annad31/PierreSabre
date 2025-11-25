package personnages;
import personnages.Commercant;

public class Yakuza extends Humain {
	private String clan;
	private int reputation=4;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom,boisson,argent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant victime) {
		String nomVictime=victime.getNom();
		parler(nomVictime + " si tu tiens à la vie, donne moi ta bourse !");
		int gain=victime.seFaireExtorquer();
		this.gagnerArgent(gain);
		parler("J'ai piqué les " + gain + " sous de " + nomVictime + ", ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
		this.reputation=this.reputation+1;
	}
	
	public int perdre() {
		int perte=this.getArgent();
		this.perdreArgent(perte);
		this.reputation=this.reputation-1;
		parler("J'ai perdu le duel et mes " + perte + " sous, snif ... J'ai déshonoré le clan de "+ this.clan + ".");
		return perte;
	}
	
	public int gagner(int gain) {
		this.gagnerArgent(gain);
		this.reputation=this.reputation+1;
		parler("Ce ronin pensait vraiment battre " + this.getNom() + " du clan de " + this.clan + ". Je l'ai dépouillé de ses " + gain + " sous.");
		return this.getArgent();
	}
}
