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
);
