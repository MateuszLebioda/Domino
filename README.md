# Student project

Recursive algorithm for placing dominoes

# Java

Application is written in Java  using OpenJDK 12.0.1 - redchat 2019-04-16

# Run Application 

To run application you will need Maven and Java (recommended: OpenJDK 12.0.1 redchat)
\
\
Build application using command: `mvn clean package`. After that, you should find .jar file in {project_directory}\target\target
\
\
To lunch application use command: `java -jar {jar_name}.jar`

##### Application need parameters! 
Use -x and -y to set width and height.

For example, to build area 4 x 4 you will use command: `java -jar {jar_name.jar} -x 4 -y 4`.

# Exceptions 
When you pass as parameters strings, double, char or something which is not a decimal number, you will get and error: *NumberFormatException*
\
\
Algorithm work only for areas which has height and weight size divisible by two. For example 4 x 4, 2 x 4, 2 x 6. When you pass difference values, you will get an error: *CannotCreateAreaException* 
