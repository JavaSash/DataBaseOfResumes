package com.urise.webapp.model;

public class TextSection extends AbstractSection<StringBuilder> {
    TextSection(){
        super(new StringBuilder());
    }

    @Override
    public void setInfo(Object element) {
        info.append(element + System.getProperty("line.separator"));
    }

    @Override
    public void deleteInfo() {
        info.delete(0, info.length());
    }

    @Override
    public final String toString(){
        return info.toString();
    }
}
