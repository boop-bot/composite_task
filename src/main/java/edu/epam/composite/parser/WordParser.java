package edu.epam.composite.parser;

import edu.epam.composite.entity.impl.Symbol;
import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser extends AbstractParser {
    private static final Logger logger = LogManager.getLogger(WordParser.class);

    @Override
    public TextComponent parse(String text) {
        TextComposite words = new TextComposite(TextComponentType.WORD);
        char textSymbols[] = text.toCharArray();
        for (Character character : textSymbols) {
            TextComponent symbol = new Symbol(character);
            words.add(symbol);
        }
        logger.info("Word parsed into symbols");
        return words;
    }
}
