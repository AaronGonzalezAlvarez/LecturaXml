package lecturaXml;

import java.io.File;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXml {

	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("C:\\Users\\DAW_M\\Documents\\xml\\peliculas.xml"));
			document.getDocumentElement().normalize();
			
			System.out.println("El elemento raiz: " + document.getDocumentElement().getNodeName());
			NodeList peliculas = document.getElementsByTagName("Pelicula");
			System.out.println("Nodos pelicula a recorrer: " + peliculas.getLength());
			
			for (int i = 0; i < peliculas.getLength(); i++) {
				Node film = peliculas.item(i);
				if(film.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) film;
					System.out.println("Titulo: " + elemento.getElementsByTagName("Titulo").item(0).getTextContent());
					System.out.println("Year: " + elemento.getElementsByTagName("Fecha").item(0).getTextContent());
					System.out.println("Director: " + elemento.getElementsByTagName("Director").item(0).getTextContent());
					System.out.println("Actor: " + elemento.getElementsByTagName("Actores").item(0).getTextContent());
					System.out.println("");
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
