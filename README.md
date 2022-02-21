# Assignment 3 - Eshop

B-OOP 2021

Your task is to create an application server using Java with the Spring framework.

Application server  enables management of goods, warehouse and shopping carts. Web Interface (API), and also the objects that are used to communicate with the outside world are defined in the specification and must be used to communicate through web services. Outside the web interface you can use any other objects according to your design, if you deem it appropriate.

Web interface specification that the application has to follow can be found here: https://app.swaggerhub.com/apis-docs/sk-stuba-fei-uim-oop/OOP_Zadanie_3/1.0.0

If the specification states that a 404 code should be returned, and the description does not say when, it is necessary to return if given ID does not exist in the system.

### System description

A detailed description of each operation is given in the API specification.

The system allows adding and removing of products from the store's selection of goods. Furthermore, it allows editing of existing products as well as increase the amount of products in stock.

The system allows you to create and delete orders (shopping carts). It is possible to add products into orders in the specified quantity (if there is enough of the product in stock). The system also allows the payment of yet unpaid orders. It is not possible to add additional items to paid orders.

## Automated tests
Project contains automated tests. Tests **DO NOT** run automatically on git push. If you want to verify how much of your implementation passes the tests, you must run them yourself. Tests can be run in 2 ways:

* using Maven, by launching lifecycle (side menu> maven> project> lifecycle> test)
* by running tests directly from the class that contains them (located in src/test/sk/.../oop/assignment3/Assignment3Tests.java)

## Evaluation

You can get 15 points for this assignment. **The program must be able to compile, otherwise 0 points are given for the assigment**.

The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.

Including, but not limited to:

* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),

* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes,

* the use of inheritance and polymorphism,

* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),

* don't use nested classes,

* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),

* don't put any logic into the main method and its class. The main method should only be used to initialize application using the Spring framework,

* you can use the lombok library and its annotations in your solution. The necessary dependency is already present in the _pom.xml_ file.

10 points are received by passing automated tests. For 9 or less passed tests 0 points are awarded. For each passed test above 9, 0.5 points is awarded. In special circumstances we can give fewer points for passed tests.

## Handing in the assigment

Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository, and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).

Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.

You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **21.5.2021 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**
