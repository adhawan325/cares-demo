create table CARES_ALLEGATION_ALLEGATION_TYPE_LINK (
    ALLEGATION_ID varchar(36) not null,
    ALLEGATION_TYPE_ID varchar(36) not null,
    primary key (ALLEGATION_ID, ALLEGATION_TYPE_ID)
);
