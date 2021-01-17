package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.Symbol;
import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.impl.TextComposite;

public class WordParser extends AbstractParser {
    private final String WORD_REGEX = new String("([A-Za-zА-Яа-я0-9])");

    public WordParser() {
        this.nextParser = new SymbolParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent lexemes = new TextComposite(TextComponentType.LEXEME);
        StringBuilder textWord = new StringBuilder("");
        int i = 0;
        while (i < text.length()) {
            if (String.valueOf(text.charAt(i)).matches(WORD_REGEX)) {
                while (String.valueOf(text.charAt(i)).matches(WORD_REGEX) && i < text.length()) {
                    textWord.append(text.charAt(i));
                    i++;
                    if (i == text.length()) {
                        break;
                    }
                }
                TextComponent symbols = nextParser.parse(textWord.toString());
                lexemes.add(symbols);
                textWord = new StringBuilder("");
            } else {
                TextComponent symbol = new Symbol(text.charAt(i));
                lexemes.add(symbol);
                i++;
            }
        }
        return lexemes;
    }
}
