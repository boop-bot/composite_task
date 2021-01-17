package edu.epam.composite.main;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.parser.AbstractParser;
import edu.epam.composite.parser.TextParser;
import edu.epam.composite.reader.TextReader;
import edu.epam.composite.reader.impl.TextReaderImpl;
import edu.epam.composite.service.TextCompositeService;
import edu.epam.composite.service.impl.TextCompositeServiceImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextReader textReader = new TextReaderImpl();
        String text = textReader.readAll("src/main/resources/data/data.txt");
        AbstractParser textParser = new TextParser();
        TextComponent textComponent = textParser.parse(text);
        TextCompositeService service = new TextCompositeServiceImpl();
        TextComponent sortedComponent = service.sortParagraphsBySentenceNumber(textComponent);
        System.out.println(sortedComponent.toString());
    }
}
