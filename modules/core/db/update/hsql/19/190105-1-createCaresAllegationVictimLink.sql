create table CARES_ALLEGATION_VICTIM_LINK (
    ALLEGATION_ID varchar(36) not null,
    VICTIM_ID varchar(36) not null,
    primary key (ALLEGATION_ID, VICTIM_ID)
);
