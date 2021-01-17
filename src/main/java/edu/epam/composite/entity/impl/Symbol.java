package edu.epam.composite.entity.impl;


import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;

import java.util.List;

public class Symbol implements TextComponent {
    private Character character;
    private TextComponentType textComponentType = TextComponentType.SYMBOL;

    public Symbol(Character character){
        this.character = character;
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponent getComponent(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getComponentList() {
        return null;
    }

    @Override
    public boolean remove(TextComponent textComponent){
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public String toString(){
        return String.valueOf(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol = (Symbol) o;

        return character.equals(symbol.character);
    }

    @Override
    public int hashCode() {
        return character.hashCode();
    }
}
