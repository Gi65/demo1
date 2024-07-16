Feature: Login with invalid creds
  
  


 Scenario Outline: Invalid test
   Given Navigate to baseUrl
   When Login with username <name> and password <password>
   Then verify the url of current page
   
   
   
   
   Examples:
     | name               | password  | 
     | nadmin@gmail.com   | Admi      | 
