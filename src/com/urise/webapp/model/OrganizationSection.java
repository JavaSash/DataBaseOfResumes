package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizationSection extends AbstractSection<List<Organization>> {
    private static final long serialVersionUID = 1L;

    public OrganizationSection(Organization... organizations) {
        super(new ArrayList<>(Arrays.asList(organizations)));
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
