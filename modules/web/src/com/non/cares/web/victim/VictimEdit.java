package com.non.cares.web.victim;

import com.haulmont.cuba.gui.components.AbstractEditor;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;
import com.non.cares.entity.Allegation;
import com.non.cares.entity.IncidentReport;
import com.non.cares.entity.Victim;
import com.non.rda.entity.ReferenceData;

import javax.inject.Inject;
import java.util.Map;

public class VictimEdit extends AbstractEditor<Victim> {
    @Inject
    private Table<IncidentReport> incidentsTable;
    @Inject
    private ComponentsFactory componentsFactory;

    @Override
    public void init(Map<String, Object> params) {
        incidentsTable.addGeneratedColumn("gAllegation", this::generateAllegationCell);
        super.init(params);
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
}