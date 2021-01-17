package edu.epam.composite.reader.impl;

import edu.epam.composite.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextReaderImpl implements TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);

    @Override
    public String readAll(String path) throws IOException {
        StringBuilder text = new StringBuilder();
        try (Stream<String> lines = (Files.lines(Path.of(path), StandardCharsets.UTF_8))) {
            lines.forEach(line->text.append(line).append("\n"));
            text.deleteCharAt(text.length() - 1);
        } catch (IOException e) {
            logger.error("File reading error " + path);
            throw new IOException("File reading error");
        }
        logger.info("file -> {} was read", path);
        return text.toString();
    }
}
