package com.urise.webapp.model;

public class TextSection extends AbstractSection<StringBuilder> {
    public TextSection(){
        super(new StringBuilder());
    }

    @Override
    public void setInfo(Object element) {
        info.append(element + System.getProperty("line.separator"));
    }

    @Override
    public final String toString(){
        return info.toString();
    }
}
