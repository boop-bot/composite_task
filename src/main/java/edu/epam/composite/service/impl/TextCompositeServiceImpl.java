package edu.epam.composite.service.impl;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.impl.TextComposite;
import edu.epam.composite.service.TextCompositeService;
import edu.epam.composite.util.comparator.ParagraphComparator;

import java.util.Comparator;
import java.util.List;

public class TextCompositeServiceImpl implements TextCompositeService {
    @Override
    public TextComponent sortParagraphsBySentenceNumber(TextComponent textComponent) {
        List<TextComponent> paragraphList = textComponent.getComponentList();
        Comparator<TextComponent> comparator = new ParagraphComparator();
        paragraphList.sort(comparator);
        return new TextComposite(paragraphList);
    }

    @Override
    public TextComponent findSentenceWithLongestWord(TextComponent textComponent) {
        return null;
    }

    @Override
    public TextComponent deleteSentencesByWordNumber(TextComponent textComponent, int number) {
        return null;
    }

    @Override
    public int findEqualWordsNumber(TextComponent textComponent, String word) {
        return 0;
    }
}
