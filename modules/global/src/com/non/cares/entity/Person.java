package com.non.cares.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.non.rda.entity.ReferenceData;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "CARES_PERSON")
@Entity(name = "cares$Person")
public class Person extends StandardEntity {
    private static final long serialVersionUID = 6332221765884669549L;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Column(name = "APPROXIMATE_AGE")
    protected Integer approximateAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTY_OF_RESIDENCE_ID")
    protected ReferenceData countyOfResidence;


    public void setApproximateAge(Integer approximateAge) {
        this.approximateAge = approximateAge;
    }

    public Integer getApproximateAge() {
        return approximateAge;
    }


    public void setCountyOfResidence(ReferenceData countyOfResidence) {
        this.countyOfResidence = countyOfResidence;
    }

    public ReferenceData getCountyOfResidence() {
        return countyOfResidence;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }


}