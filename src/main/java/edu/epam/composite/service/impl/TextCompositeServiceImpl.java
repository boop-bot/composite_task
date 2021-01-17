package edu.epam.composite.service.impl;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;
import edu.epam.composite.service.TextCompositeService;
import edu.epam.composite.util.comparator.ParagraphComparator;

import java.util.ArrayList;
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
    public List<TextComponent> findSentencesWithLongestWord(TextComponent textComponent) {
        int maxLength = 0;
        List<TextComponent> sentenceList = new ArrayList<>();
        List<TextComponent> paragraphs = textComponent.getComponentList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponentList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getComponentList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsAndSymbols = lexeme.getComponentList();
                    for (TextComponent component : wordsAndSymbols) {
                        if (TextComponentType.WORD.equals(component.getTextComponentType())) {
                            if (component.getSize() > maxLength) {
                                maxLength = component.getSize();
                                sentenceList.clear();
                                sentenceList.add(sentence);
                            } else if (component.getSize() == maxLength) {
                                sentenceList.add(sentence);
                            }
                        }
                    }
                }
            }
        }
        return sentenceList;
    }

    @Override
    public TextComponent deleteSentencesByWordNumber(TextComponent textComponent, int number) {
        List<TextComponent> paragraphs = textComponent.getComponentList();
        int wordsNumber = 0;
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponentList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getComponentList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsAndSymbols = lexeme.getComponentList();
                    for (TextComponent component : wordsAndSymbols) {
                        if (TextComponentType.WORD.equals(component.getTextComponentType())) {
                            wordsNumber++;
                        }
                    }
                }
                if (wordsNumber < number) {
                    paragraph.remove(sentence);
                }
                wordsNumber = 0;
            }
        }
        return new TextComposite(paragraphs);
    }

    @Override
    public int findEqualWordsNumber(TextComponent textComponent, String word) {
        int count = 0;
        List<TextComponent> paragraphs = textComponent.getComponentList();
        for (TextComponent paragraph : paragraphs) {
            List<TextComponent> sentences = paragraph.getComponentList();
            for (TextComponent sentence : sentences) {
                List<TextComponent> lexemes = sentence.getComponentList();
                for (TextComponent lexeme : lexemes) {
                    List<TextComponent> wordsAndSymbols = lexeme.getComponentList();
                    for (TextComponent component : wordsAndSymbols) {
                        if (TextComponentType.WORD.equals(component.getTextComponentType())) {
                            String textWord = component.toString();
                            if (textWord.equalsIgnoreCase(word)) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
