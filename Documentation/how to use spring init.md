***Spring initializer***

A tool which helps you create a spring boot project without doing the setup manually. 
Based on the kind of project you want (Maven, Gradle) or the kind of language (Java, Kotlin)


**Maven vs Gradle**
They are build tools which manage how your project compiles, runs, tests and includes dependencies. 

*Why do we need them?*
When you create a Java/spring boot project, there is a lot more than just writing hava code. We need to download teh right libraries, make sure all the correct versions are compatible together., 
compile the code, package code into .jar or .war files so that others can run it etc. 

Maven or Gradle do all of these on their own - like a kitchen assistant where your project is the food you're making
Maven is a little easier to start with but a little slower. Gradle is more advanced. 

*Which version of Spring boot to pick?*

If it says snapshot, that means it's still in development - don't use it. It's better to pick the highest version which is not snapshot
which means its stable for use and production. 

*What packaging to choose?*

JAR has an embedded server which means you can directly run your app from IntelliJ or command line. 
WAR needs to be deployed into a web container like Tomcat - its good if you want to deploy to an existing server. 

*Configuration*

Between properties and YAML, properties is used for smaller configs with older projects whereas yaml is sued for complex configs
for modern projects 

*How to understand what dependencies you need*

Am I building a web app? -> Need Spring Web
Am I connecting to a database? -> Need Spring Data JPA + driver
Am I securing my app -> Spring security
Am I building REST APIs? -> Spring web + Spring boot starter JSON

You can always add dependencies later in your project as you build

