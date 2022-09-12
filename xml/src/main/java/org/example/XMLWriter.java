package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriter {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        Element company = document.createElement("company");
        root.appendChild(company);

        Element offices = document.createElement("offices");
        company.appendChild(offices);

        Element office = document.createElement("office");
        office.setAttribute("floor", "1");
        office.setAttribute("room", "2");
        offices.appendChild(office);

        Element office2 = document.createElement("office");
        office2.setAttribute("floor", "2");
        office2.setAttribute("room", "1");
        offices.appendChild(office2);

        Element employees = document.createElement("employees");
        office.appendChild(employees);

        Element employees2 = document.createElement("employees");
        office2.appendChild(employees2);

        Element employee11 = document.createElement("employee");
        employee11.setAttribute("name", "Михаил");
        employee11.setAttribute("job", "Middle Software Developer");
        employees.appendChild(employee11);

        Element employee21 = document.createElement("employee");
        employee21.setAttribute("name", "Сергей");
        employee21.setAttribute("job", "Junior Software Developer");
        employees2.appendChild(employee21);

        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("xml_dir/new_company.xml"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
    }
}
