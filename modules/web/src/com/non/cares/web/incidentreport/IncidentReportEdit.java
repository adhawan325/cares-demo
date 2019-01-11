package com.non.cares.web.incidentreport;

import com.haulmont.bpm.gui.procactions.ProcActionsFrame;
import com.haulmont.bpm.service.ProcessRuntimeService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.non.cares.entity.IncidentReport;

import javax.inject.Inject;

public class IncidentReportEdit extends AbstractEditor<IncidentReport> {
    @Inject
    private ProcActionsFrame procActionsFrame;
    private static String PROCESS_CODE = "incidentReportProcess";
    private boolean isNewItem = false;
    @Override
    protected void initNewItem(IncidentReport item) {
        isNewItem = true;
        super.initNewItem(item);
    }

    @Override
    protected void postInit() {
        if( !isNewItem )
        {
            procActionsFrame.initializer()
                    .standard()
                    .init(PROCESS_CODE, getItem());
        }
    }
}
