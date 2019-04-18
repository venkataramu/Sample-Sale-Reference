Flash Sale
--------------------------------------------
Flash Sale is a backend system for Sale offers to Users. It is a Restful API with below features.

Application uses MYSQL DB to persist data 

1. Register Users for flash sale
2. Purchase an item in Flash Sale by Registered Users

Running  the Application 
---------------------------------------------
Please execute SampleSaleReferenceApplication.java to start the embeded Tomcat server

Below are the URLS to purchase an item in flash sale

1. POST API call to Register an User :

    URL : http://localhost:8080/api/users/register
    Method : POST
    
    Request Body : {
                      "name": "Rajesh",
                      "emailId": "rajesh@gmail.com",
                      "phone": 12345678,
                      "address": "Hyd"
                  }
                  
 2. Check how many users are registered :
    API call : http://localhost:8080/api/users
    METHOD :   GET
    
    
 3. Purchase an item in Flash Sale 
    URL : http://localhost:8080/api/users/{userId}/purchase/sale
          In above userId is mandatory to purchase an Item
          
     Method : POST
     Headers : accept : application/json
               contentType : application/json
               
     Posting an Successful message to Registered User from an API call.
     
    
