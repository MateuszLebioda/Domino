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

# Ambushes 
Recommended / optimal area to try application is 4 x 4, 4 x 6. To bigger areas time is incomparably longer. 
\
\
For example time to finish algorithm for area 4 x 4 is less then one second, to area 4 x 6 is about a second. But to area 6 x 6 time is about a 45 min. 
###### So dont be surprised ;) 


# Results interpretation

As a result of application you will get time, number of solutions and graphical representation of any combination.

The first two issues, I don't think i need to explain. \
\
Third issue need little one.\
You will get list of tables like this:

0  	2 	4 	6 	\
0 	2 	4 	6 	\
1 	3 	5 	7 	\
1 	3 	5 	7   

Two same number, next to each other symbolize one domino cube. So in above example, we have all Dominoes put vertically. 

##### And one more example:

0 	2 	4 	8 	\
0 	2 	4 	8 	\
1 	3 	6 	6 	\
1 	3 	7 	7   

In this case in extreme right bottom we have two horizontal dominos cube, rest are vertical.
