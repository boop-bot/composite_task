package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private final String LEXEME_REGEX = new String("(\\S+)");

    public LexemeParser() {
        this.nextParser = new WordParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite sentences = new TextComposite(TextComponentType.SENTENCE);
        Pattern pattern = Pattern.compile(LEXEME_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String textLexeme = matcher.group();
            TextComponent wordsAndSymbols = nextParser.parse(textLexeme);
            sentences.add(wordsAndSymbols);
        }
        return sentences;
    }
}
