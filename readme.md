## **Overview**
- Calculates total price for items
- Supports offers:
  - Buy One Get One Free (Apples)
  - 3 for 2 (Oranges)
  - For example: [ Apple, Apple, Orange, Apple ] => £2.05
## **Technologies Used**
        Java 21
        Maven
        JUnit5
        IDE Used:: IntelliJ
## **How to Run Steps**
### Prerequisites
    Before running the project ensure the following are installed on your system
    1. Java 21 (javac -version to check the version)
    2. Apache Maven ( use mvn -version to check)
    (Note: To check Java installed or not mvn -v)
### Console 
    1. Open terminal in the project root folder (For Example:: D:\ShoppingCart)
    2. Compile the project using Maven
            mvn clean install
            mvn exec:java -Dexec.mainClass="com.shop.checkout.Checkout"
            mvn clean test
    
## **Input**
Items: [Apple, Apple, Orange, Apple]
## **Sample Output**
Total price after discount: £1,45

