package com.non.cares.entity;

import javax.persistence.Entity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s %s %s|firstName,lastName,approximateAge")
@Entity(name = "cares$Perpetrator")
public class Perpetrator extends Person {
    private static final long serialVersionUID = -1258006338077646425L;

}