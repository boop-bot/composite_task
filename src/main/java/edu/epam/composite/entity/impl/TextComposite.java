package edu.epam.composite.entity.impl;

import edu.epam.composite.entity.TextComponent;
import edu.epam.composite.entity.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> textComponents = new ArrayList<>();
    private TextComponentType textComponentType;

    public TextComposite() {
    }

    public TextComposite(List<TextComponent> textComponents) {
        this.textComponents = textComponents;
    }

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public TextComponent getComponent(int index) {
        return  textComponents.get(index);
    }

    @Override
    public List<TextComponent> getComponentList() {
        return new ArrayList<>(textComponents);
    }

    @Override
    public boolean remove(TextComponent textComponent) {
        return textComponents.remove(textComponent);
    }

    @Override
    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    public void setTextComponentType(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    @Override
    public int getSize() {
        return textComponents.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : textComponents){
            if (TextComponentType.PARAGRAPH.equals(component.getTextComponentType())){
                sb.append("\n\t");
            }
            sb.append(component.toString());
            if (TextComponentType.LEXEME.equals(component.getTextComponentType())){
                sb.append(" ");
            }
        }
        if (TextComponentType.TEXT.equals(this.getTextComponentType())){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (!textComponents.equals(that.textComponents)) return false;
        return textComponentType == that.textComponentType;
    }

    @Override
    public int hashCode() {
        int result = textComponents.hashCode();
        result = 31 * result + textComponentType.hashCode();
        return result;
    }
}
