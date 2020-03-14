
class Carte {

	/**
	 * Attribut désignant le signe de la carte
	 * 0 -> trefle
	 * 1 -> pique
	 * 2 -> coeur
	 * 3 -> carreau
	 */
	private int signe;

	/**
	 * Attribut déignant le nom de la carte
	 *  "11" <-> "valet"
	 * "12" <-> "reine"
	 * "13" <-> "roi" 
	 */
	private String nom;
	
	/**
	 * Attribut désignant la valeur de la carte
	 */
	private int valeur;
	
	/* getters et setters de chaque attribut*/
	
	public int getSigne() {
		return signe;
	}

	public void setSigne(int signe) {
		this.signe = signe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	/**
	 * Constructeur de la classe Carte
	 * @param nom
	 * @param signe
	 * @param valeur
	 */
	public Carte(String nom, int signe, int valeur) {
		this.signe = signe;
		this.nom = nom;
		this.valeur = valeur;
	}
	
	/**
	 * Methode qui affiche la carte
	 */
	public void printOut()
	{
		String phrase = "Je suis la carte ";
		switch(this.nom)
		{
			case "11": phrase += "'valet'";
			break;
			
			case "12": phrase += "'dame'";
			break;
			
			case "13": phrase += "'roi'";
			break;
			
			default: phrase += "'"+this.nom+"'";
			
		}
		phrase += " ,";
		
		switch(this.signe)
		{
			case 0: phrase += "trèfle";
			break;
			
			case 1: phrase += "pique";
			break;
			
			case 2: phrase += "coeur";
			break;
			
			case 3: phrase += "carreau";
			break;
			
			default: break;
			
		}
		
		System.out.println(phrase + " ,"+ this.valeur);
	}
}
