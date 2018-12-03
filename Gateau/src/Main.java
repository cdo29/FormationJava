import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {


	public static void main(String[] args) throws FileNotFoundException {
		Patisserie pat = new CoucheChocolat(
				new CoucheCaramel(
						new CoucheBiscuit(
								new CoucheChocolat(
										new Gateau()))));
		
		System.out.println(pat.preparer());
		Patisserie pat2 = (new CoucheBiscuit( new Gateau()));
		System.out.println(pat2.preparer());		
	}


}
