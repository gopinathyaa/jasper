1.Add the Jasper reports dependency in pom.xml
2.create a database entity 
3.create a repository interface
4.Design your report template using Jaspersoft Studio .This template will 
be in .jrxml format, which is an XML file containing the report structure.
Compile the .jrxml file into a .jasper file which will be provided in the src/main/resources 
5.Write a service method to load the compiled report template.
6.Create a REST controller to expose the report generation as an API

7.Export Formats: Besides PDF, you can export reports to other formats 
like HTML, Excel, etc
[employees.pdf](https://github.com/user-attachments/files/16710812/employees.pdf)
