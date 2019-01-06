package com.non.cares.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import com.non.rda.entity.ReferenceData;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "cares$Reporter")
public class Reporter extends Person {
    private static final long serialVersionUID = -206395952198569909L;

    @Column(name = "ANONYMOUS")
    protected Boolean anonymous;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATIONSHIP_TO_CHILD_ID")
    protected ReferenceData relationshipToChild;

    public void setRelationshipToChild(ReferenceData relationshipToChild) {
        this.relationshipToChild = relationshipToChild;
    }

    public ReferenceData getRelationshipToChild() {
        return relationshipToChild;
    }


    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }


}