package XML;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;

public class Parte1 implements Serializable{
	public static void main(String[] args) throws IOException {
		File nuevo = new File("myPeople.dat");
		nuevo.createNewFile();
		
		PrintStream ps = new PrintStream(nuevo);
		
		ps.print("Mar�a L�pez 36 Gustavo G�mez 1 Irene Salas 36 Roberto Morgade 63 Graciela Iglesias 60");
	
	}
}
