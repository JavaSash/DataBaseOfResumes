package com.urise.webapp.model;

public class TextSection extends AbstractSection<String> {
    public TextSection(){
        super("");
    }

    @Override
    public void setInfo(Object element) {
        info = info + element.toString() + "\n";
    }

    @Override
    public final String toString(){
        return info;
    }
}
