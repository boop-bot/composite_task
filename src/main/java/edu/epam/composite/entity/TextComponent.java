package edu.epam.composite.entity;

public interface TextComponent {
    void add(TextComponent textComponent);
    TextComponent getComponent(int index);
    boolean remove(TextComponent textComponent);
    public TextComponentType getTextComponentType();
    int getSize();
}
