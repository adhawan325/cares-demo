alter table CARES_ALLEGATION_VICTIM_LINK add constraint FK_ALLVIC_ON_VICTIM foreign key (VICTIM_ID) references CARES_PERSON(ID);
alter table CARES_ALLEGATION_VICTIM_LINK add constraint FK_ALLVIC_ON_ALLEGATION foreign key (ALLEGATION_ID) references CARES_ALLEGATION(ID);
