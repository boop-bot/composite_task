package edu.epam.composite.util.comparator;

import edu.epam.composite.entity.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        return o1.getSize() - o2.getSize();
    }
}
