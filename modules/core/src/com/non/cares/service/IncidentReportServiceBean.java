package com.non.cares.service;

import com.non.cares.entity.IncidentReport;
import com.non.rda.entity.ReferenceData;
import com.non.rda.service.ReferenceDataService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(IncidentReportService.NAME)
public class IncidentReportServiceBean implements IncidentReportService {
    @Inject
    ReferenceDataService referenceDataService;
    private static final String INITIAL_STATUS = "status.Received";
    @Override
    public void updateStatus(IncidentReport report, String status)
    {
        report.setStatus(referenceDataService.getReferenceDataByCode(status));
    }

    @Override
    public void setInitialStatus(IncidentReport report)
    {
        updateStatus(report, INITIAL_STATUS);
    }
}