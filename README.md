# MavenDeployFXdb

This is a JavaFX program with fxml and an embedded H2 database that has been configured to run outside of the IDE using Maven. 

[Video walkthrough](https://youtu.be/PwvHmXgtK0o)

## Create Maven JavaFX Database Program

 1. Create new Maven project in IntelliJ IDEA (Ultimate required for database component). Alternatively, you could add Maven to an existing project by right clicking the project folder and clicking Add Framework Support. 
 2. Enable auto-import
 3. Right click the *java* folder to add new JavaFX Application (Main.java, Controller.java, sample.fxml)
 4. Add code to fxml. I added a GridPane and TextArea. With the fxml file in the *resources* folder the code to link it in Main.java is `Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));`
 5. Add code to Controller to connect to database. `DB_URL = "jdbc:h2:./folder_name/database_name";`
 6. Add code to pom.xml within dependencies tag
	 1. H2 dependency [Source](http://www.h2database.com/html/cheatSheet.html) 
 7. Create the folder and database using the names from the DB URL or run the program to create the folder and database automatically.  
 8. Use the database tab to connect to the database. Use SQL to create and populate tables. The SQL used in this project: [HR SQL](https://drive.google.com/open?id=1sA3knK6-MF13_yZ_xnemz0Dv0ieusTxO)
 9. Disconnect from database within IntelliJ.
 10. Database integration works in IntelliJ!
 
 ### CSS
 
A css file could be placed in the resources folder within src/main and linked with `<URL value="@filename.css" />` in fxml. 

## Depolyment

 1. Create META-INF folder containing MANIFEST.MF file in resources folder.
 2. Add `Main-Class: Main` to MANIFEST.MF. If Main is in a package you would write `Main-Class: package_name.Main`
 3. Add code to pom.xml within plugins tag
	 1. maven-jar-plugin to make this application into a jar [Source](https://maven.apache.org/plugins/maven-jar-plugin/)
	 2. maven-shade-plugin to bundle the H2 driver jar with it into one jar. [Source](https://stackoverflow.com/questions/4443192/how-to-embed-h2-database-into-jar-file-delivered-to-the-client)
 4. Use the Maven tab | Lifecycle | install to create the executable jar in the project's *target* folder.
 5. Run the executable jar to create the database and its folder (or just make the folder).  
 6. Copy the 2 database files from the resources folder in the project into the resources folder in the target folder, replacing any existing database files (or connect through Database tab in IntelliJ to create and populate tables as done before). 
 7. The executable jar and resources folder allow the program to run outside of the IDE!
