package test;

import java.io.IOException;

import core.FileServer;

public class TestServeur {
	
	public static final int PORT = 1234;

	public static void main(String[] args) throws IOException {
		new FileServer(PORT);
	}

}
