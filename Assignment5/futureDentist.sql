/*Select name of dentist working on upcoming treatments*/
select person.name, treatment.treatment, treatment.date_of_treatment
from person, employee, dentist, treatment
where treatment.DATE_OF_TREATMENT > '2016-10-24'
AND treatment.dentist_id = dentist.dentist_id
AND dentist.employee_ID = employee.employee_ID
AND employee.person_ID = person.person_id;