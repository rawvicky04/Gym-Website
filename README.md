# Gym-Website
It is a website of Fitness and Muscle Studio Gym. Here users can register themselves and book their demo classes. Also, Admin has given some additonal powers as admin can register any client and also view the client details.
#Setup
Firstly, Create a database called GymDatabse[Please be cautious here its GymDatabse NOT GymDatabase]
Then, Create a table inside this called Client.
Create table client(
      client_id int,
      First_Name varchar (30),
      Last_Name varchar (30),
      Email Varchar (50),
      Password varchar (20));
      
Then, Insert admin details..
Insert into client(1,'admin', 'admin', 'admin@gmail.com', 'password');

Then, inside all the servlet class type your Sql password at the place of password inside the Connection con... Statement.

Run homepage.html at your Server.

Voila..

Contact me if you need any help...https://www.linkedin.com/in/prabhat-kumar-17257a146?lipi=urn%3Ali%3Apage%3Ad_flagship3_profile_view_base_contact_details%3Bkw5X3gZHQWWftZWYGvXkHw%3D%3D
