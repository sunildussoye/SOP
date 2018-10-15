# SOP
Sales Order Processing

A Spring Boot application covering the main functionalities in a SOP. This project is about a Sports Shop selling sports items to customers around the world . It involves placing orders, creating the orderlines with all the products that have been ordererd . Invoicing and deliveries are handled together with returns from customers . It provides endpoints to query various functionalities together with some basic reporting capabilities , especially a deliveryNote matching at the end of a specified period. All data are ouputted in JSON format , ready to be consumed by the UI, possibly an Angular front End that can be added at a later stage. The data are held in an H2 DB, and Unit tests using JUNIT ,Mockito and Postman . Enhancement : This can be enhanced to include Stock Control capabilities , currency conversion as Customers would be able to pay in their own currency .

The main aspects covered :
- basic design patterns (factory, builder), composite / association aspect .
- MVC - segration of functionalities.
- encapsulation (getters/setters mainly).
- polymorphism (overriding methods, no overloading is relevant at the moment).
- JPA - embedded entities (Address, productAttributes) , in embedeable entities , Customer & Product
- JPA - Entity relationship.
- h2 Memory DB ( see application.properties) ; name of db = sop
- Validation & Custom Validator implementation.
- Custom Exception handling.
- Implementation of native SQL queries .
- Documentation implementation using Swagger (More work required to document Entities). (http:localhost:8080/seagger-ui.html)
- Unit test using Rest-Assured approach , Junit , Mockito & Postman.
- lambda V8 (used in datasetup)
- Implementation of basic endpoints (controller).

Outstanding ..
to complete the endpoints regarding reporting , order , products , more on documentation ..
- adding functionalty regarding deliverynotematching reporting .
- more SQL queries to satify those above requirements.
- finally a nice frontend to capture the jason output for display ..


