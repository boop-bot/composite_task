package edu.epam.composite.parser;

import edu.epam.composite.entity.TextComponent;

public abstract class AbstractParser {
    protected AbstractParser nextParser;

    public abstract TextComponent parse(String text);
}
