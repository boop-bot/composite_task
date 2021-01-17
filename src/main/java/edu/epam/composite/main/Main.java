package edu.epam.composite.main;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.parser.AbstractParser;
import edu.epam.composite.parser.ParagraphParser;

public class Main {
    public static void main(String[] args) {
        String text = new String("\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! " +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English? " +
                "\tIt is a established fact that a reader will be of a page when looking at its layout... ");
        AbstractParser textParser = new ParagraphParser();
        TextComponent textComponent = textParser.parse(text);
        System.out.println(textComponent.toString());
    }
}
