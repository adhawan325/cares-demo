-- begin CARES_PERSON
alter table CARES_PERSON add constraint FK_CARES_PERSON_ON_COUNTY_OF_RESIDENCE foreign key (COUNTY_OF_RESIDENCE_ID) references NONRDA_REFERENCE_DATA(ID)^
alter table CARES_PERSON add constraint FK_CARES_PERSON_ON_RELATIONSHIP_TO_CHILD foreign key (RELATIONSHIP_TO_CHILD_ID) references NONRDA_REFERENCE_DATA(ID)^
create index IDX_CARES_PERSON_ON_COUNTY_OF_RESIDENCE on CARES_PERSON (COUNTY_OF_RESIDENCE_ID)^
create index IDX_CARES_PERSON_ON_RELATIONSHIP_TO_CHILD on CARES_PERSON (RELATIONSHIP_TO_CHILD_ID)^
-- end CARES_PERSON
-- begin CARES_INCIDENT_REPORT
alter table CARES_INCIDENT_REPORT add constraint FK_CARES_INCIDENT_REPORT_ON_CONTACT_METHOD foreign key (CONTACT_METHOD_ID) references NONRDA_REFERENCE_DATA(ID)^
alter table CARES_INCIDENT_REPORT add constraint FK_CARES_INCIDENT_REPORT_ON_REPORTER foreign key (REPORTER_ID) references CARES_PERSON(ID)^
alter table CARES_INCIDENT_REPORT add constraint FK_CARES_INCIDENT_REPORT_ON_STATUS foreign key (STATUS_ID) references NONRDA_REFERENCE_DATA(ID)^
create index IDX_CARES_INCIDENT_REPORT_ON_CONTACT_METHOD on CARES_INCIDENT_REPORT (CONTACT_METHOD_ID)^
create index IDX_CARES_INCIDENT_REPORT_ON_REPORTER on CARES_INCIDENT_REPORT (REPORTER_ID)^
create index IDX_CARES_INCIDENT_REPORT_ON_STATUS on CARES_INCIDENT_REPORT (STATUS_ID)^
-- end CARES_INCIDENT_REPORT
-- begin CARES_ALLEGATION
alter table CARES_ALLEGATION add constraint FK_CARES_ALLEGATION_ON_INCIDENT_REPORT foreign key (INCIDENT_REPORT_ID) references CARES_INCIDENT_REPORT(ID)^
create index IDX_CARES_ALLEGATION_ON_INCIDENT_REPORT on CARES_ALLEGATION (INCIDENT_REPORT_ID)^
-- end CARES_ALLEGATION
-- begin CARES_ALLEGATION_PERPETRATOR_LINK
alter table CARES_ALLEGATION_PERPETRATOR_LINK add constraint FK_ALLPER_ON_ALLEGATION foreign key (ALLEGATION_ID) references CARES_ALLEGATION(ID)^
alter table CARES_ALLEGATION_PERPETRATOR_LINK add constraint FK_ALLPER_ON_PERPETRATOR foreign key (PERPETRATOR_ID) references CARES_PERSON(ID)^
-- end CARES_ALLEGATION_PERPETRATOR_LINK
-- begin CARES_ALLEGATION_ALLEGATION_TYPE_LINK
alter table CARES_ALLEGATION_ALLEGATION_TYPE_LINK add constraint FK_ALLALLTYP_ON_ALLEGATION foreign key (ALLEGATION_ID) references CARES_ALLEGATION(ID)^
alter table CARES_ALLEGATION_ALLEGATION_TYPE_LINK add constraint FK_ALLALLTYP_ON_REFERENCE_DATA foreign key (ALLEGATION_TYPE_ID) references NONRDA_REFERENCE_DATA(ID)^
-- end CARES_ALLEGATION_ALLEGATION_TYPE_LINK
-- begin CARES_ALLEGATION_VICTIM_LINK
alter table CARES_ALLEGATION_VICTIM_LINK add constraint FK_ALLVIC_ON_VICTIM foreign key (VICTIM_ID) references CARES_PERSON(ID)^
alter table CARES_ALLEGATION_VICTIM_LINK add constraint FK_ALLVIC_ON_ALLEGATION foreign key (ALLEGATION_ID) references CARES_ALLEGATION(ID)^
-- end CARES_ALLEGATION_VICTIM_LINK
