-- begin CARES_PERSON
create table CARES_PERSON (
    ID varchar(36) not null,
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
    COUNTY_OF_RESIDENCE_ID varchar(36),
    --
    -- from cares$Reporter
    ANONYMOUS boolean,
    RELATIONSHIP_TO_CHILD_ID varchar(36),
    --
    primary key (ID)
)^
-- end CARES_PERSON
-- begin CARES_INCIDENT_REPORT
create table CARES_INCIDENT_REPORT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    IS_EMERGENCY boolean,
    CONTACT_METHOD_ID varchar(36),
    REPORTER_ID varchar(36) not null,
    IS_MANDATORY_REPORTER boolean,
    --
    primary key (ID)
)^
-- end CARES_INCIDENT_REPORT
-- begin CARES_ALLEGATION
create table CARES_ALLEGATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    INCIDENT_REPORT_ID varchar(36),
    DESCRIPTION longvarchar,
    --
    primary key (ID)
)^
-- end CARES_ALLEGATION

-- begin CARES_ALLEGATION_ALLEGATION_TYPE_LINK
create table CARES_ALLEGATION_ALLEGATION_TYPE_LINK (
    ALLEGATION_ID varchar(36) not null,
    ALLEGATION_TYPE_ID varchar(36) not null,
    primary key (ALLEGATION_ID, ALLEGATION_TYPE_ID)
)^
-- end CARES_ALLEGATION_ALLEGATION_TYPE_LINK
-- begin CARES_ALLEGATION_VICTIM_LINK
create table CARES_ALLEGATION_VICTIM_LINK (
    ALLEGATION_ID varchar(36) not null,
    VICTIM_ID varchar(36) not null,
    primary key (ALLEGATION_ID, VICTIM_ID)
)^
-- end CARES_ALLEGATION_VICTIM_LINK
-- begin CARES_ALLEGATION_PERPETRATOR_LINK
create table CARES_ALLEGATION_PERPETRATOR_LINK (
    ALLEGATION_ID varchar(36) not null,
    PERPETRATOR_ID varchar(36) not null,
    primary key (ALLEGATION_ID, PERPETRATOR_ID)
)^
-- end CARES_ALLEGATION_PERPETRATOR_LINK
