package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.Symbol;
import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.impl.TextComposite;

public class LexemeParser extends AbstractParser {
    private final String WORD_REGEX = "[А-Яа-я\\w]+";

    public LexemeParser() {
        this.nextParser = new WordParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent lexemes = new TextComposite(TextComponentType.LEXEME);
        StringBuilder textWord = new StringBuilder("");
        StringBuilder textSb = new StringBuilder(text);
        while (textSb.length() != 0) {
            if (String.valueOf(textSb.charAt(0)).matches(WORD_REGEX)) {
                while (String.valueOf(textSb.charAt(0)).matches(WORD_REGEX)) {
                    textWord.append(textSb.charAt(0));
                    textSb.deleteCharAt(0);
                    if (textSb.length() == 0) {
                        break;
                    }
                }
                TextComponent word = nextParser.parse(textWord.toString());
                lexemes.add(word);
                textWord = new StringBuilder("");
            } else {
                TextComponent symbol = new Symbol(textSb.charAt(0));
                lexemes.add(symbol);
                textSb.deleteCharAt(0);
            }
        }
        return lexemes;
    }
}
