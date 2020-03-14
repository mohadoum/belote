
public class JoueurTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Joueur j1 = new Joueur("MT98");
		
		j1.ajoutCarte(new Carte("1", 0, 1));
		j1.ajoutCarte(new Carte("2", 1, 2));
		j1.ajoutCarte(new Carte("5", 2, 5));
		j1.ajoutCarte(new Carte("10", 3, 10));
		j1.ajoutCarte(new Carte("7", 3, 7));
		
		System.out.println(j1.getNom()+ " va jouer en premier la carte qui se présente ci-dessous.");
		j1.jouerEnPremier().printOut();
		
		System.out.println();
		
		System.out.println("Si le premier joueur joue une carte de signe carreau(3), "+ j1.getNom()+ " va jouer en premier la carte qui se présente ci-dessous.");
		j1.play(3).printOut();
		
		
		
	}

}
