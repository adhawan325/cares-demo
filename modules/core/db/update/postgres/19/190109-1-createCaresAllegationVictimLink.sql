create table CARES_ALLEGATION_VICTIM_LINK (
    VICTIM_ID uuid,
    ALLEGATION_ID uuid,
    primary key (VICTIM_ID, ALLEGATION_ID)
);
