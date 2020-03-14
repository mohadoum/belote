
public class CarteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carte[] listeCarte = new Carte[52];
		
		int i=0;
		for(int carte=1; carte<=13; carte++)
		{
			for(int signe=0; signe <=3; signe++)
			{
				listeCarte[i] = new Carte(Integer.toString(carte), signe, carte);
				listeCarte[i].printOut();
				i++;
			}
		}
	}

}
                    