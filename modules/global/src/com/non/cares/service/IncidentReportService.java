package com.non.cares.service;


import com.non.cares.entity.IncidentReport;

public interface IncidentReportService {
    String NAME = "cares_IncidentReportService";

    void updateStatus(IncidentReport report, String status);

    void setInitialStatus(IncidentReport report);
}