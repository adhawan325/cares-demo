package com.non.cares.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.non.rda.entity.ReferenceData;
import com.haulmont.chile.core.annotations.Composition;
import java.util.List;
import javax.persistence.OneToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s %s|contactMethod,reporter,allegation")
@Table(name = "CARES_INCIDENT_REPORT")
@Entity(name = "cares$IncidentReport")
public class IncidentReport extends StandardEntity {
    private static final long serialVersionUID = -3521422477301599770L;

    @Column(name = "IS_EMERGENCY")
    protected Boolean isEmergency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACT_METHOD_ID")
    protected ReferenceData contactMethod;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REPORTER_ID")
    protected Reporter reporter;

    @Column(name = "IS_MANDATORY_REPORTER")
    protected Boolean isMandatoryReporter;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "incidentReport")
    protected List<Allegation> allegation;

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }


    public void setIsMandatoryReporter(Boolean isMandatoryReporter) {
        this.isMandatoryReporter = isMandatoryReporter;
    }

    public Boolean getIsMandatoryReporter() {
        return isMandatoryReporter;
    }


    public void setAllegation(List<Allegation> allegation) {
        this.allegation = allegation;
    }

    public List<Allegation> getAllegation() {
        return allegation;
    }


    public void setContactMethod(ReferenceData contactMethod) {
        this.contactMethod = contactMethod;
    }

    public ReferenceData getContactMethod() {
        return contactMethod;
    }


    public void setIsEmergency(Boolean isEmergency) {
        this.isEmergency = isEmergency;
    }

    public Boolean getIsEmergency() {
        return isEmergency;
    }


}