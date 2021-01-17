package edu.epam.composite.service.impl;

import edu.epam.composite.entity.TextComponentType;
import edu.epam.composite.entity.impl.TextComposite;
import edu.epam.composite.parser.AbstractParser;
import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.parser.TextParser;
import edu.epam.composite.service.TextCompositeService;
import org.testng.annotations.*;


import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TextCompositeServiceImplTest {
    private TextCompositeService textCompositeService;
    private TextComponent textComponent;

    @BeforeMethod
    public void setUp() {
        textCompositeService = new TextCompositeServiceImpl();
        String text = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\tBye бандерлоги.";
        AbstractParser parser = new TextParser();
        textComponent = parser.parse(text);
    }

    @Test
    public void testFindEqualWordsNumber() {
        int expected = 6;
        int actual = textCompositeService.findEqualWordsNumber(textComponent, "It");
        assertEquals(actual, expected);
    }

    @Test
    public void testFindSentencesWithLongestWord() {
        List<TextComponent> expected = Arrays.asList(textComponent.getComponent(1).getComponent(1));
        List<TextComponent> actual = textCompositeService.findSentencesWithLongestWord(textComponent);
        assertEquals(actual, expected);
    }

    @Test
    public void testSortParagraphsBySentenceNumber() {
        TextComponent expexted = new TextComposite(
                Arrays.asList(textComponent.getComponent(2), textComponent.getComponent(3),
                        textComponent.getComponent(0), textComponent.getComponent(1)));
        TextComponent actual = textCompositeService.sortParagraphsBySentenceNumber(textComponent);
        assertEquals(actual, expexted);
    }

    @Test
    public void testDeleteSentencesByWordNumber() {
        TextComponent expexted = new TextComposite(TextComponentType.TEXT);
        expexted.add(new TextComposite(TextComponentType.PARAGRAPH));
        expexted.getComponent(0).add(textComponent.getComponent(1).getComponent(1));
        
        TextComponent actual = textCompositeService.deleteSentencesByWordNumber(textComponent, 35);
        assertEquals(actual, expexted);
    }

    @AfterMethod
    public void tearDown() {
        textCompositeService = null;
    }
}