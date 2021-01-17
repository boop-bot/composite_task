package edu.epam.composite.service;

import edu.epam.composite.entity.TextComponent;

public interface TextCompositeService {
    TextComponent sortParagraphsBySentenceNumber(TextComponent textComponent);
    TextComponent findSentenceWithLongestWord(TextComponent textComponent);
    TextComponent deleteSentencesByWordNumber(TextComponent textComponent, int number);
    int findEqualWordsNumber(TextComponent textComponent, String word);
}
