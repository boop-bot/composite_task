package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private final String SENTENCE_REGEX = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent paragraphs = new TextComposite(TextComponentType.PARAGRAPH);
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String textSentence = matcher.group();
            TextComponent lexemes = nextParser.parse(textSentence);
            paragraphs.add(lexemes);
        }
        return paragraphs;
    }
}
