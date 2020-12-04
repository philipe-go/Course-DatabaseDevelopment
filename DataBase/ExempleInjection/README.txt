
1. Créez la base de donées, en exécutant le script ExempleInjection.sql dans MySQL.

2. Exécutez l'application.

3.Pour faire une "SQL injection", entrez exactement dans le champs "Employee Id" : 

E004', 45000.00); update sal set salaire =105000.00 where Id_Emp = 'E003'; -- 

et dans le champs "Salary", n'importe quel valeur VALIDE de salaire.





