package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

public class SentenceParser extends AbstractParser {
    private final String LEXEME_SEPARATOR = "(\\s+)";

    public SentenceParser() {
        this.nextParser = new LexemeParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite sentences = new TextComposite(TextComponentType.SENTENCE);
        String textLexemes[] = text.split(LEXEME_SEPARATOR);
        for (String textLexeme : textLexemes) {
            TextComponent wordsAndSymbols = nextParser.parse(textLexeme);
            sentences.add(wordsAndSymbols);
        }
        return sentences;
    }
}
