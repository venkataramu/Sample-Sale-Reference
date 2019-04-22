Flash Sale
--------------------------------------------
Flash Sale is a backend system for Sale offers to Users. It is a Restful API with below features.

Application uses MYSQL DB to persist data 

Assuming users are already available in the system
1.Users need to register for flash sale 
2. Purchase an item in Flash Sale by Registered Users

Running  the Application 
---------------------------------------------
Please execute SampleSaleReferenceApplication.java to start the embeded Tomcat server

Below are the URLS to purchase an item in flash sale

#1. POST API call to Register an User :

    URL : http://localhost:8080/api/register/{userId}
    Method : POST
    
    O/P : {
            "userId": 13846,
            "registerTime": "2019-04-22T13:59:56.07"
          }
 
 #2. Purchase an item in Flash Sale 
    URL : http://localhost:8080/api/purchase?userId={userId}&productId={productId}
          userId : userId means registered userId.
          productId : Product Id of Item which is under sale
          
     Method : POST
     Headers : accept : application/json
               contentType : application/json
               
     Posting an Successful message to Registered User from an API call.
     
 ## ER Diagram
 
 ![erdiagram](https://user-images.githubusercontent.com/8840659/56484593-f14ea280-64ed-11e9-87ce-edabffce070b.png)
