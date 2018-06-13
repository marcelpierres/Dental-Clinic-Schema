/*Select salaries over 65000*/
SELECT person.name, employee.salary
FROM person, employee
WHERE salary > 65000
AND employee.person_id = person.person_id;