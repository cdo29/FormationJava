
public abstract class Couche extends Patisserie{
	Patisserie pat;
	String nom;
	
	public Couche(Patisserie p) {
		pat = p;

	}
	
	public String preparer() {
		String str = pat.preparer();
		return str + nom;
	}
	
	
	
	
}
