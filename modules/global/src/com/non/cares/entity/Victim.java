package com.non.cares.entity;

import javax.persistence.Entity;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s %s|firstName,lastName,approximateAge")
@Entity(name = "cares$Victim")
public class Victim extends Person {
    private static final long serialVersionUID = 4032427172940500240L;

    @JoinTable(name = "CARES_ALLEGATION_VICTIM_LINK",
        joinColumns = @JoinColumn(name = "VICTIM_ID"),
        inverseJoinColumns = @JoinColumn(name = "ALLEGATION_ID"))
    @ManyToMany
    protected List<Allegation> allegations;

    public void setAllegations(List<Allegation> allegations) {
        this.allegations = allegations;
    }

    public List<Allegation> getAllegations() {
        return allegations;
    }


}