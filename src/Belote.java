
public class Belote {
	/**
	 * tableau des cartes du jeu
	 */
	private Carte[] cartes;
	
	/**
	 * tableau des joueurs du jeu
	 */
	private Joueur[] joueurs;

	/**
	 * Getters AND Setters des tableaux de cartes et de joueurs
	 */
	public Carte[] getCartes() {
		return cartes;
	}

	public void setCartes(Carte[] cartes) {
		this.cartes = cartes;
	}

	public Joueur[] getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Joueur[] joueurs) {
		this.joueurs = joueurs;
	}

	/**
	 * Constructeur de la classe Belote qui initialise les cartes et les joueurs
	 */
	public Belote() {
		/* initialisation de la taille des tableaux de cartes et de joueurs */
		this.setCartes(new Carte[52]);
		this.setJoueurs(new Joueur[4]);

		/* enregistrement des joueurs*/
		this.getJoueurs()[0] = new Joueur("MT98");
		this.getJoueurs()[1] = new Joueur("Faride");
		this.getJoueurs()[2] = new Joueur("Sebastian");
		this.getJoueurs()[3] = new Joueur("Remi");

		/* enregistrement des cartes */
		int i = 0;
		for (int carte = 1; carte <= 13; carte++) {
			for (int signe = 0; signe <= 3; signe++) {
				this.getCartes()[i] = new Carte(Integer.toString(carte), signe, carte);
				i++;
			}
		}

		/* melange des cartes */
		for (int j = 0; j < 50; j++) {
			int c1 = (int) (Math.random() * 51 + 0);
			int c2 = (int) (Math.random() * 51 + 0);

			Carte ech = this.getCartes()[c1];
			this.getCartes()[c1] = this.getCartes()[c2];
			this.getCartes()[c2] = ech;
		}

		/* distribution des cartes aux joueurs*/
		for (int j = 0; j < 13; j++) {
			this.getJoueurs()[0].ajoutCarte(this.getCartes()[4 * j]);
			this.getJoueurs()[1].ajoutCarte(this.getCartes()[4 * j + 1]);
			this.getJoueurs()[2].ajoutCarte(this.getCartes()[4 * j + 2]);
			this.getJoueurs()[3].ajoutCarte(this.getCartes()[4 * j + 3]);
		}

	}

	/**
	 * Methode qui renvoie l'index de la carte ayant la plus grande valeur sur les cartes jouees
	 * @param carteJoues
	 * @param numeroPremierJoueur
	 * @return int
	 */
	private int getIndexPlusGrandeCarte(Carte[] carteJoues, int numeroPremierJoueur) {
		int indexMax = numeroPremierJoueur;
		int signe = carteJoues[numeroPremierJoueur].getSigne();
		for (int i = 0; i < 4; i++) {
			if (i != numeroPremierJoueur && carteJoues[i].getSigne() == signe
					&& carteJoues[i].getValeur() > carteJoues[indexMax].getValeur()) {
				indexMax = i;
			}
		}

		return indexMax;
	}

	
	/**
	 * Methode qui renvoie l'index du joueur ayant gagné le jeu
	 * @return int
	 */
	private int getNumeroJoueurGagnant() {
		int numeroGagnant = 0;
		for (int i = 1; i < 4; i++) {
			if (this.getJoueurs()[i].getScore() > this.getJoueurs()[numeroGagnant].getScore()) {
				numeroGagnant = i;
			}
		}

		return numeroGagnant;
	}
	
	/**
	 * Methode privée permettant de faire une pause
	 * @param time
	 */
	private void sleep(int time)
	{
		try
		{
			Thread.sleep(time);
		}catch(Exception e)
		{
			System.out.println("error");
		}
	}
	
	private void waiting()
	{
		for(int i=0; i<10; i++)
		{
			System.out.print(". ");
			this.sleep(100);
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Belote belote = new Belote();
		
		/*On determine celui qui ouvre la partie grace à un random*/
		System.out.println("Debut de la partie ");
		belote.waiting();
		System.out.println("Nous allons déterminer qui ouvre la partie ");
		belote.waiting();
		int numeroPremierJoueur = (int) (Math.random() * 3 + 0);
		System.out.println(belote.getJoueurs()[numeroPremierJoueur].getNom()+":\" Ah! C'est Moi\"");
		belote.waiting();
		
		
		/*On joue tant qu'il reste des cartes aux joueurs*/
		do {
			System.out.println("\n\nTour numero "+ (13-belote.getJoueurs()[0].getCompteurDeCartes()+1));
			belote.waiting();
			
			/*On cree un tableau contenant les cartes que l'on va jouer dans ce tour */
			Carte[] carteJoues = new Carte[4];
			
			/* Ici l'indice du joueur correspond à son indice dans le tableau des cartes jouées */
			
			/* le premier joueur ouvre le tour */
			carteJoues[numeroPremierJoueur] = belote.getJoueurs()[numeroPremierJoueur].jouerEnPremier();
			System.out.println(belote.getJoueurs()[numeroPremierJoueur].getNom()+": \" "+belote.getJoueurs()[numeroPremierJoueur].jouer(carteJoues[numeroPremierJoueur])+" \"");
			belote.waiting();
			
			/* les autres jouent leurs cartes de même signe ou ... */ 
			for (int i = 0; i < 4; i++) {
				if (i != numeroPremierJoueur) {
					carteJoues[i] = belote.getJoueurs()[i].play(carteJoues[numeroPremierJoueur].getSigne());
					System.out.println(belote.getJoueurs()[i].getNom()+": \" "+belote.getJoueurs()[i].jouer(carteJoues[i])+" \"");
					belote.waiting();
				}
			}

			/* On cherche le gagnant du tour*/
			int numeroJoueurGagnant = belote.getIndexPlusGrandeCarte(carteJoues, numeroPremierJoueur);
		
			/* On met à jour le score du gagnant */
			int lastScore = belote.getJoueurs()[numeroJoueurGagnant].getScore();
			belote.getJoueurs()[numeroJoueurGagnant].tourGagnant(carteJoues);

			System.out.println(belote.getJoueurs()[numeroJoueurGagnant].getNom()+": \" Wesh! Suis le gagnant (+"+(belote.getJoueurs()[numeroJoueurGagnant].getScore()-lastScore)+") \"");
			
			/* On definit le gagnant en tant que premier joueur du tour prochain*/
			numeroPremierJoueur = numeroJoueurGagnant;
			
		} while (belote.getJoueurs()[0].getCompteurDeCartes() > 0);

		System.out.println("\nLa partie est terminée.");
		System.out.println("Nous allons afficher les résultats ");
		belote.waiting();
		
		System.out.println("");
		System.out.println("("+belote.getJoueurs()[0].getNom()+", "+belote.getJoueurs()[0].getScore()+")");
		System.out.println("("+belote.getJoueurs()[1].getNom()+", "+belote.getJoueurs()[1].getScore()+")");
		System.out.println("("+belote.getJoueurs()[2].getNom()+", "+belote.getJoueurs()[2].getScore()+")");
		System.out.println("("+belote.getJoueurs()[3].getNom()+", "+belote.getJoueurs()[3].getScore()+")");
		
		
		/*Une fois que la partie terminée, on cherche le gagnant*/
		int numeroJoueurGagnant = belote.getNumeroJoueurGagnant();

		
		/* On affiche son score et son nom */
		System.out.println("\n"+belote.getJoueurs()[numeroJoueurGagnant].getNom() + " est notre gagnant avec un score de "
				+ belote.getJoueurs()[numeroJoueurGagnant].getScore());

	}

}
