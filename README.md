## StockCart
CitiBridge-Group 3
The service is responsible for authenticating a user , fetching the data of the NIFTY companies , saving the selected stocks in database  and retrieving them .   

## Installation

clone the project and open using a java supported environment . 


## Usage

This service accepts the username and password being entered by the user in the UI and checks it with the database User table .It returns a json list of top stocks from the YAHOO API . It also returns the pre saved stocks from the database SavedStocks table . 

To run the application - Run the java file DemoApplication which contains public static void main. and go to :

http://localhost:8081/swagger-ui.html

To sign in use username = "username" and password = "password" StockCart/src/main/java/ -- contains all the source code.

To check the swagger api go to -- >http://localhost:8081/swagger-ui.html
