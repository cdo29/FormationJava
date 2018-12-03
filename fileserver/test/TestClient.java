package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", TestServeur.PORT);

		// Lancement d'un thread de façon ad hoc pour lire les donn�es en parall�le de l'�criture
		new Thread(new Runnable() {
			public void run() {
				try {
					// Création d'un lecteur bufferisé
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String line = null;

					// On affiche tout ce qu'on re�oit
					while ((line = in.readLine()) != null) System.out.println(">>> " + line);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		// Cr�ation d'un Writer bufferis�
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		Scanner scanner = new Scanner(System.in);

		// Tant qu'on lit des lignes sur l'entr�e standard, on les envoie sur la Socket
		while (true) {
			String line = scanner.nextLine();
			out.write(line + "\n");
			out.flush();
		}


	}

}
