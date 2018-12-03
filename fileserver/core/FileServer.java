package core;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class FileServer {
	
	private List<FileClient> clients = new ArrayList<>();
	
	public FileServer(int port) throws IOException {
		
		// On écoute sur le port TCP
		ServerSocket server = new ServerSocket(port);
		
		// Boucle infinie
		while (true) {
			// On accepte la connexion entrante
			Socket socket = server.accept();
			// On démarre un nouveau client
			FileClient client = new FileClient(socket, "C:/");
			clients.add(client);
			// On lance l'exécution du client (en Thread)
			client.start();
			

		}
	}

}
