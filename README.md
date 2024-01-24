### A Spring boot application to shorten longURL sent from OscarEMR

#Use Springboot Initializr (https://start.spring.io/) to start up a Springboot project:
  1. Spring Web
  2. Spring Data JPA (connect with MariaDB)
  3. Lombok (a Java library that provides annotations to simplify Java development by automating the generation of boilerplate code. Key features include automatic generation of getters, setters, equals, hashCode, and toString methods,..)
  4. Spring starter logging
  5. Thymeleaf (optional: just to verify if we can see homepage)

#Flow:
Our API receives longURL from OscarEMR (SendSMS feature) then create a simple database table includes 4 columns: id (auto-generate), longURL(from OscarEMR), shortURL (create a logic to generate this), createdAt.
Then send shortURL back to OscarEMR and display on document/lab page. 
Once patient click on shortURL, a request will be sent to our API again, then retrieve the longURL that was stored in database. And boom, patient can be redirected to OnlineBooking to make appointment.
