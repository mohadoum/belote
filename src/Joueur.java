
class Joueur {
	
	/**
	 * Nom du joueur
	 */
	private String nom;

	/**
	 * Score du joueur
	 */
	private int score;
	
	/**
	 * Compteur de cartes que dispose le joueur
	 */
	private int compteurDeCartes;
	
	/**
	 * tableau des cartes de base detenues par le joueur
	 */
	private Carte[] mainDuJoueur;
	
	
	/* getters and setters de chaque attribut*/	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCompteurDeCartes() {
		return compteurDeCartes;
	}

	public void setCompteurDeCartes(int compteurDeCartes) {
		this.compteurDeCartes = compteurDeCartes;
	}

	public Carte[] getMainDuJoueur() {
		return mainDuJoueur;
	}

	public void setMainDuJoueur(Carte[] mainDuJoueur) {
		this.mainDuJoueur = mainDuJoueur;
	}

	
	/**
	 * Constructeur de la classe Joueur
	 * @param nom
	 */
	public Joueur(String nom) {
		this.nom = nom;
		this.score = 0;
		this.compteurDeCartes = 0;
		this.mainDuJoueur = new Carte[13];
	}
	
	/**
	 * Methode qui ajoute une carte à la main du joueur
	 * @param carte
	 */
	public void ajoutCarte(Carte carte)
	{
		this.mainDuJoueur[this.compteurDeCartes] = carte;
		this.compteurDeCartes++;
	}
	
	/**
	 * Methode qui renvoie la carte que devrait jouer celui-ci en premier
	 * @return
	 */
	public Carte jouerEnPremier()
	{
		 int i=0;
		 do
		 {
			 if(this.getMainDuJoueur()[i] != null)
			 {
				 Carte c = this.getMainDuJoueur()[i];
				 this.getMainDuJoueur()[i] = null;
				 this.compteurDeCartes--;
				 return c;
			 }else
			 {
				 i++;
			 }
		 }while (i<13);
		 
		 return null;
	
	}
	
	/**
	 * Methode qui renvoie la carte que devrait jouer celui-ci par rapport à la carte du premier joueur
	 * @param signe
	 * @return
	 */
	public Carte play(int signe)
	{
		int i=0;
		do
		{
			Carte c = this.getMainDuJoueur()[i];
			if(c != null && c.getSigne() == signe)
			{
				this.getMainDuJoueur()[i] = null;
				this.compteurDeCartes--;
				return c;		
			}
		
			i++;
		}while(i<13);
		
		/* s'il n'a aucune carte du même signe */
		/* On renvoie la première carte dispo */
		return this.jouerEnPremier();
	}
	
	/**
	 * Methode qui actualise le score de celui-ci s'il gagne
	 * @param carte
	 */
	public void tourGagnant(Carte[] carte)
	{
		int score=0;
		for(int i=0; i<carte.length; i++)
		{
			score += carte[i].getValeur();
		}
		this.setScore(this.getScore() + score);
	}
	
	/**
	 * Methode qui affiche la carte en parametre
	 * @param c
	 */
	public String jouer(Carte c)
	{
		String phrase = "Je joue la carte ";
		switch(c.getNom())
		{
			case "11": phrase += "'valet'";
			break;
			
			case "12": phrase += "'dame'";
			break;
			
			case "13": phrase += "'roi'";
			break;
			
			default: phrase += "'"+c.getNom()+"'";
			
		}
		phrase += " ,";
		
		switch(c.getSigne())
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
		
		return phrase;
	}
	
}
