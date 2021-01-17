package edu.epam.composite.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent textComponent);
    TextComponent getComponent(int index);
    List<TextComponent> getComponentList();
    boolean remove(TextComponent textComponent);
    public TextComponentType getTextComponentType();
    int getSize();
}
