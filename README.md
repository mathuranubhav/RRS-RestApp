# RRS-RestApp

Restaurant Reservation System using REST and AngularJS

This project was created using Angular JS, HTML, CSS, Bootstrap, Javascript. 

Features: 

This project was created to be a customizable Restaurant Reservation System.  

1) All reservations stored on the database and data is transferred using RESTFul API.  
2) Fully Customizable: Admin Settings Panel included in which variables can be changed.
3) Each reservation generates a random 5 digit confirmation code.
4) Edit Reservations using Confirmation Code.


User Roles: 
Administrator 
 - Basic Authentication

1) Reservations
 - View existing reservations
 - Add, edit, delete and search a reservation

2) Seating
 - View seating arrangement in tabular format
 - Graphical representation of tables and seating arrangement

3) App Settings
4) Contacts

Future work: 
1) Improve administrator login security (password hashing) 
2) UI Improvements
3) Change Project File structure
4) Form Validations
5) Display Tables Logic
5) Contacts Table Unique
6) Angular Testing
  

Instructions to run the Project: 

1) Run the given Database Scripts in the /DBScripts folder to install the dummy data onto the database. (MySQL Workbench)
2) Install Eclipse IDE
3) Load the project in eclipse. 
4) Run the index.html file

Database Creation: 
Run the file SQLDump.sql

Default Username: admin@admin.com
Default Password: password

Details about RESTFul API: 

The RESTFul API for this application was built using Jersey-Jackson

The REST calls made by this application are: 

http://localhost:8080/RRS-RESTApp/api/settings/all