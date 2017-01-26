# Garage Database
This is my third year project for Data Centric RAD.<br/>
This web app allows users to query a relational garage database.
<hr/>

### Technologies Used
* MySQL Relational Database
* Java Database Connectivity (JDBC)
* Java Server Faces (JSF)

### How it Works
This project follows a Model-View-Controller design pattern.<br/>
There exists a **DAO** (Data Access Object) that allows Java to speak to the Database. This class is used to process all queries to the database.
It's seperate to ensure independance from any database. The results from queries are displayed
on views. **Views** act as a Graphical User Interface (GUI). The views simply project the
results from the queries. **Bean Classes** are used to store and retrieve data for our views.
This data is stored using logical statements carried out by our **Controllers**, who contain
methods that can call other methods in the DAO to retrieve query results.
