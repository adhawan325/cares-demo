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
    --
    primary key (ID)
);
