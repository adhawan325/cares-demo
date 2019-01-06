create table CARES_ALLEGATION_PERPETRATOR_LINK (
    ALLEGATION_ID varchar(36) not null,
    PERPETRATOR_ID varchar(36) not null,
    primary key (ALLEGATION_ID, PERPETRATOR_ID)
);
