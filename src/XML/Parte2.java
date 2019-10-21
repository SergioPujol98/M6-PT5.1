package XML;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Parte2 implements Serializable {
	public static void main(String[] args) throws IOException {
		File archivo = new File("myPeople.dat");
		File contadr = new File ("myPeopleContador.dat");
		Scanner n1 = new Scanner(archivo);
		Scanner n2 = new Scanner(contadr);

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("Esteve_Terradas");
			doc.appendChild(rootElement);

			// M6 element
			Element departamento = doc.createElement("Ciclos");
			rootElement.appendChild(departamento);

			Attr attr = doc.createAttribute("Nombre");
			attr.setValue("DAM");
			departamento.setAttributeNode(attr);
			int  contador = 0;
			while (n2.hasNext()) {
				n2.next();
				n2.next();
				n2.next();
			contador ++;
			}
			
			for (int i = 0; i < contador; i++) {
				Element persona = doc.createElement("Persona");
				rootElement.appendChild(persona);

				Element eNombre = doc.createElement("nombre");
				eNombre.appendChild(doc.createTextNode(n1.next()));
				persona.appendChild(eNombre);

				Element eApellido = doc.createElement("apellido");
				eApellido.appendChild(doc.createTextNode(n1.next()));
				persona.appendChild(eApellido);

				Element eEdad = doc.createElement("edad");
				eEdad.appendChild(doc.createTextNode(n1.next()));
				persona.appendChild(eEdad);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Instituto.xml"));
			transformer.transform(source, result);

			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
			
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	
	}

}
