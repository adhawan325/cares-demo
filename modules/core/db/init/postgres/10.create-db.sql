-- begin CARES_PERSON
create table CARES_PERSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    APPROXIMATE_AGE integer,
    COUNTY_OF_RESIDENCE_ID uuid,
    --
    -- from cares$Reporter
    ANONYMOUS boolean,
    RELATIONSHIP_TO_CHILD_ID uuid,
    --
    primary key (ID)
)^
-- end CARES_PERSON
-- begin CARES_INCIDENT_REPORT
create table CARES_INCIDENT_REPORT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IS_EMERGENCY boolean,
    CONTACT_METHOD_ID uuid,
    REPORTER_ID uuid not null,
    IS_MANDATORY_REPORTER boolean,
    STATUS_ID uuid,
    --
    primary key (ID)
)^
-- end CARES_INCIDENT_REPORT
-- begin CARES_ALLEGATION
create table CARES_ALLEGATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INCIDENT_REPORT_ID uuid,
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end CARES_ALLEGATION
-- begin CARES_ALLEGATION_PERPETRATOR_LINK
create table CARES_ALLEGATION_PERPETRATOR_LINK (
    ALLEGATION_ID uuid,
    PERPETRATOR_ID uuid,
    primary key (ALLEGATION_ID, PERPETRATOR_ID)
)^
-- end CARES_ALLEGATION_PERPETRATOR_LINK
-- begin CARES_ALLEGATION_ALLEGATION_TYPE_LINK
create table CARES_ALLEGATION_ALLEGATION_TYPE_LINK (
    ALLEGATION_ID uuid,
    ALLEGATION_TYPE_ID uuid,
    primary key (ALLEGATION_ID, ALLEGATION_TYPE_ID)
)^
-- end CARES_ALLEGATION_ALLEGATION_TYPE_LINK
-- begin CARES_ALLEGATION_VICTIM_LINK
create table CARES_ALLEGATION_VICTIM_LINK (
    VICTIM_ID uuid,
    ALLEGATION_ID uuid,
    primary key (VICTIM_ID, ALLEGATION_ID)
)^
-- end CARES_ALLEGATION_VICTIM_LINK
