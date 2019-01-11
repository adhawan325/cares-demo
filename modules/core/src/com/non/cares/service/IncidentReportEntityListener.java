package com.non.cares.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.non.rda.entity.ReferenceData;
import com.non.rda.service.ReferenceDataService;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.AfterInsertEntityListener;
import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.non.cares.entity.IncidentReport;

import javax.inject.Inject;

@Component("cares_IncidentReportEntityListener")
public class IncidentReportEntityListener implements BeforeInsertEntityListener<IncidentReport> {

    @Inject
    private IncidentReportService incidentReportService;

    @Inject
    ReferenceDataService referenceDataService;

    @Inject
    private Persistence persistence;

    @Override
    public void onBeforeInsert(IncidentReport entity, EntityManager entityManager) {
        if( entity.getStatus() == null )
        {
            incidentReportService.setInitialStatus(entity);
            entityManager.persist(entity);
        }
    }

    public void updateState(UUID entityId, String status)
    {
        System.out.println("Setting status to:" + status);
        try (Transaction tx = persistence.getTransaction()) {
            IncidentReport report = persistence.getEntityManager().find(IncidentReport.class, entityId);
            if (report != null) {
                report.setStatus(referenceDataService.getReferenceDataByCode(status));
            }
            tx.commit();
        }
    }
}