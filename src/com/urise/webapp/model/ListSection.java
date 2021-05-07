package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection extends AbstractSection<List<String>> {
    public ListSection() {
        super(new ArrayList<>());
    }

    @Override
    public void setInfo(Object element) {
        info.add((String) element);
    }

    //TODO: перенос строки при N символов в строке
    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : info) {
            sb.append(" * ").append(str).append("\n\n");
        }
        return sb.toString();
    }
}
