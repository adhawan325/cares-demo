package com.non.cares.web.incidentreport;

import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.non.cares.entity.Allegation;
import com.non.cares.entity.IncidentReport;
import com.non.cares.entity.Victim;
import com.non.rda.entity.ReferenceData;

import javax.inject.Inject;

public class IncidentReportBrowse extends AbstractLookup {
    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private GroupTable<IncidentReport> incidentReportsTable;

    @Override
    public void ready() {
        incidentReportsTable.addGeneratedColumn("gAllegation", this::generateAllegationCell);
        incidentReportsTable.addGeneratedColumn("gVictim", this::generateVictimCell);
    }

    public Component generateAllegationCell(IncidentReport entity) {
        Label label = (Label) componentsFactory.createComponent(Label.NAME);
        StringBuffer value = new StringBuffer();
        for( Allegation allegation : entity.getAllegation())
        {
            for(ReferenceData type: allegation.getType() )
            value.append( type.getReferenceValue() ).append("; ");
        }
        label.setValue(value);
        return label;
    }

    public Component generateVictimCell(IncidentReport entity) {
        Label label = (Label) componentsFactory.createComponent(Label.NAME);
        StringBuffer value = new StringBuffer();
        for( Allegation allegation : entity.getAllegation())
        {
            for(Victim victim: allegation.getVictim() )
                value.append( victim.getFirstName() ).append(" ").append( victim.getLastName() ).append("; ");
        }
        label.setValue(value);
        return label;
    }
}