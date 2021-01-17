package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;
import edu.epam.composite.service.impl.TextCompositeServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser extends AbstractParser {
    private static final Logger logger = LogManager.getLogger(TextParser.class);
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
        logger.info("Text parsed into paragraphs");
        return baseText;
    }
}
