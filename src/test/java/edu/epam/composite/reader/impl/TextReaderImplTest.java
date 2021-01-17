package edu.epam.composite.reader.impl;

import edu.epam.composite.reader.TextReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class TextReaderImplTest {
    private TextReader textReader;

    @BeforeMethod
    public void setUp() {
        textReader = new TextReaderImpl();
    }

    @Test
    public void testReadAll() throws IOException {
        String expected = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?\n" +
                "\tIt is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\tBye бандерлоги.";
        String actual = textReader.readAll("src/main/resources/data/data.txt");
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        textReader = null;
    }
}