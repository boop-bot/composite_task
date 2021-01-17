package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

public class TextParser extends AbstractParser {
    private final String PARAGRAPH_SEPARATOR = "\\t";

    public TextParser() {
        this.nextParser = new ParagraphParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent baseText = new TextComposite(TextComponentType.TEXT);
        String[] textParagraphs = text.split(PARAGRAPH_SEPARATOR);
        for (String textParagraph : textParagraphs) {
            if (textParagraph.length() > 0) {
                TextComponent sentences = nextParser.parse(textParagraph);
                baseText.add(sentences);
            }
        }
        return baseText;
    }
}
