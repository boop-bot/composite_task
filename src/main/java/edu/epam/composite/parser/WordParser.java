package edu.epam.composite.parser;

import edu.epam.composite.entity.impl.Symbol;
import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

public class WordParser extends AbstractParser {

    @Override
    public TextComponent parse(String text) {
        TextComposite words = new TextComposite(TextComponentType.WORD);
        char textSymbols[] = text.toCharArray();
        for (Character character : textSymbols) {
            TextComponent symbol = new Symbol(character);
            words.add(symbol);
        }
        return words;
    }
}
