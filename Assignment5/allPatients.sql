/*Select all patients in the clinic*/
select person.name
from person, patient, clinic
where person.clinic_id = clinic.clinic_id
and patient.person_id = person.person_id;