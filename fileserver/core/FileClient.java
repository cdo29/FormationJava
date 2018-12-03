package core;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class FileClient extends Thread {

	private Socket socket;

	private BufferedReader reader;


	private BufferedWriter writer;

	private File dir;
	
	public FileClient(Socket socket, String directory) throws IOException {
		this.socket = socket;
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		this.dir = new File(directory);
	}

	public void run() {
		try {
			DataInputStream i = new DataInputStream(null);
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(">>> " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String string) throws IOException {
		writer.write(string + "\n");
		writer.flush();
	}

	public void terminate() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public File getDir() {
		return dir;
	}

	public void setDir(File newDir) {
		this.dir = newDir;
	}


}
