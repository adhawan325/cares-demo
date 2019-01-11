create table NONDTA_RULE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    STATUS integer,
    DESCRIPTION text,
    BASE_RECORD_TYPE varchar(255),
    MATCHING_RECORD_TYPE varchar(255),
    CASE_SENSITIVE boolean,
    --
    primary key (ID)
);
