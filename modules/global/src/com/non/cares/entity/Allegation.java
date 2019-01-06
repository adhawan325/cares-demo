package com.non.cares.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.non.rda.entity.ReferenceData;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("  %s %s|type,createTs")
@Table(name = "CARES_ALLEGATION")
@Entity(name = "cares$Allegation")
public class Allegation extends StandardEntity {
    private static final long serialVersionUID = 8204179429840229806L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INCIDENT_REPORT_ID")
    protected IncidentReport incidentReport;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @JoinTable(name = "CARES_ALLEGATION_ALLEGATION_TYPE_LINK",
        joinColumns = @JoinColumn(name = "ALLEGATION_ID"),
        inverseJoinColumns = @JoinColumn(name = "ALLEGATION_TYPE_ID"))
    @ManyToMany
    protected List<ReferenceData> type;

    @JoinTable(name = "CARES_ALLEGATION_VICTIM_LINK",
        joinColumns = @JoinColumn(name = "ALLEGATION_ID"),
        inverseJoinColumns = @JoinColumn(name = "VICTIM_ID"))
    @ManyToMany
    protected List<Victim> victim;

    @JoinTable(name = "CARES_ALLEGATION_PERPETRATOR_LINK",
        joinColumns = @JoinColumn(name = "ALLEGATION_ID"),
        inverseJoinColumns = @JoinColumn(name = "PERPETRATOR_ID"))
    @ManyToMany
    protected List<Perpetrator> perpetrator;

    public void setVictim(List<Victim> victim) {
        this.victim = victim;
    }

    public List<Victim> getVictim() {
        return victim;
    }


    public List<Perpetrator> getPerpetrator() {
        return perpetrator;
    }

    public void setPerpetrator(List<Perpetrator> perpetrator) {
        this.perpetrator = perpetrator;
    }




    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setType(List<ReferenceData> type) {
        this.type = type;
    }

    public List<ReferenceData> getType() {
        return type;
    }



    public void setIncidentReport(IncidentReport incidentReport) {
        this.incidentReport = incidentReport;
    }

    public IncidentReport getIncidentReport() {
        return incidentReport;
    }


}