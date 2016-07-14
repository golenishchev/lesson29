package com.example.lesson29;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class SAXHandler extends DefaultHandler {

    boolean bTitle = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("computer")) {
            String id = attributes.getValue("id");
            System.out.print("id: " + id + " - ");
        } else if (qName.equalsIgnoreCase("title")) {
            bTitle = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bTitle) {
            System.out.println("title: "
                    + new String(ch, start, length));
            bTitle = false;
        }
    }
}