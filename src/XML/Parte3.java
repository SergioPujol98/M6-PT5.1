package XML;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parte3 {
	public static void main(String[] args) {

		try {
			File archivo = new File("Instituto.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
			Document document = (Document) documentBuilder.parse(archivo);
			document.getDocumentElement().normalize();

			System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
			NodeList listaEmpleados = document.getElementsByTagName("Persona");
			for (int temp = 0; temp < listaEmpleados.getLength(); temp++) {
				Node nodo = listaEmpleados.item(temp);
				System.out.println("\nElemento: " + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) nodo;
					System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
					System.out
							.println("Apellido: " + element.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.println("Edad: " + element.getElementsByTagName("edad").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}