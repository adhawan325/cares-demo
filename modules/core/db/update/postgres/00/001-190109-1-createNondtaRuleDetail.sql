create table NONDTA_RULE_DETAIL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BASE_RECORD_FIELD varchar(255) not null,
    MATCHING_RECORD_FIELD varchar(255) not null,
    MATCH_TYPE integer not null,
    USE_ID boolean,
    RULE_ID uuid,
    --
    primary key (ID)
);
