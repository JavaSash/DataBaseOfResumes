package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends AbstractSection<List<Organization>> {
    public OrganizationSection() {
        super(new ArrayList<>());
    }

    @Override
    public void setInfo(Object element) {
        info.add((Organization) element);
    }

    public final String toString(){
        StringBuilder sb = new StringBuilder();
        for(Organization org : info) {
            sb.append(" * ").append(org).append("\n");
        }
        return sb.toString();
    }
}
