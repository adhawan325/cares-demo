alter table CARES_ALLEGATION_ALLEGATION_TYPE_LINK add constraint FK_ALLALLTYP_ON_ALLEGATION foreign key (ALLEGATION_ID) references CARES_ALLEGATION(ID);
alter table CARES_ALLEGATION_ALLEGATION_TYPE_LINK add constraint FK_ALLALLTYP_ON_REFERENCE_DATA foreign key (ALLEGATION_TYPE_ID) references NONRDA_REFERENCE_DATA(ID);
