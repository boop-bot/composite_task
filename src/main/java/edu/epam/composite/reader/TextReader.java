package edu.epam.composite.reader;

import java.io.IOException;

public interface TextReader {
    String readAll(String path) throws IOException;
}
