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
    public boolean remove(TextComponent textComponent) {
        return textComponents.remove(textComponent);
    }

    @Override
    public int getSize() {
        return textComponents.size();
    }

    @Override
    public TextComponentType getTextComponentType() {
        return textComponentType;
    }

    @Override
    public List<TextComponent> getComponentList() {
        return new ArrayList<>(textComponents);
    }

    public void setTextComponentType(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
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
        return sb.toString();
    }
}
