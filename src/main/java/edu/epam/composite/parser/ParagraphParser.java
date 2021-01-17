package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

public class ParagraphParser extends AbstractParser {
    private final String PARAGRAPH_REGEX = new String("\\\t");

    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent baseText = new TextComposite(TextComponentType.TEXT);
        String[] textParagraphs = text.split(PARAGRAPH_REGEX);
        for (String textParagraph : textParagraphs) {
            if (textParagraph.length() > 0) {
                TextComponent sentences = nextParser.parse(textParagraph);
                baseText.add(sentences);
            }
        }
        return baseText;
    }
}
