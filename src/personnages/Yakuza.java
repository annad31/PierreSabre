package personnages;
import personnages.Commercant;

public class Yakuza extends Humain {
	private String clan;
	private int reputation;
	
	public Yakuza(String nom, String boisson, int argent, String clan) {
		super(nom,boisson,argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		String nomVictime=victime.getNom();
		parler(nomVictime + " si tu tiens à la vie, donne moi ta bourse !");
		int gain=victime.seFaireExtorquer();
		this.gagnerArgent(gain);
		parler("J'ai piqué les " + gain + " sous de " + nomVictime + ", ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
		this.reputation++;
	}
}
