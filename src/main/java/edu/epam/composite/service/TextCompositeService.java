package edu.epam.composite.service;

import edu.epam.composite.entity.TextComponent;

import java.util.List;

public interface TextCompositeService {
    TextComponent sortParagraphsBySentenceNumber(TextComponent textComponent);
    List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent);
    TextComponent deleteSentencesByWordNumber(TextComponent textComponent, int number);
    int findEqualWordsNumber(TextComponent textComponent, String word);
}
