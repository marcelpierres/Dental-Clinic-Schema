/*Select everyone that has had a cleaning*/
select person.name, treatment.date_of_treatment
from person, patient, treatment
where treatment.PATIENT_ID = patient.PATIENT_ID
AND patient.PERSON_ID = person.PERSON_ID
AND treatment.treatment = 'Cleaning'
AND treatment.DATE_OF_TREATMENT < '2016-10-24';