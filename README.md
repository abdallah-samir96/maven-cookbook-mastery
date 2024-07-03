# maven-cookbook-mastery

Apache Maven is a popular tool for build automation, primarily Java projects,
which is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
---
## Downloading & Installing
1. we can download maven from this [link](https://maven.apache.org/download.cgi).
2. we need to set the JAVA_HOME path to the environment variables.
3. Set Maven bin directory containing the batch files to the environment variables 
4. check maven using `mvn -version` and it will show the maven version like
``` dtd
mvn -version
Apache Maven 3.9.6 (bc0240f3c744dd6b6ec2920b3cd08dcc295161ae)
Maven home: C:\Program Files\devtools\apache-maven-3.9.6\apache-maven-3.9.6
Java version: 17.0.10, vendor: Eclipse Adoptium, runtime: C:\Program Files\devtools\java\Eclipse Adoptium\jdk-17.0.10.7-hotspot
Default locale: en_US, platform encoding: Cp1256
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
 ```
---
## Maven Directory Structure
- Maven contains mainly 4 folders
  - bin folder contains the batch files and shell scripts to run Maven on various platforms.
  - boot folder contains the jars required for Maven to start(plexus-classworlds-2.7.0.jar).
  - conf folder contains the default settings.xml file used by Maven.
  - lib folder contains the libraries used by Maven. It also contains an ext folder
    in which third-party extensions, which can extend or override the default Maven
    implementation, can be placed.


When we type mvn command the patch file in the bin directory will be run.
The batch file search about JAVA_HOME and runs its main class {{org.codehaus.plexus.classworlds.launcher.Launcher}}

`mvn -version` to check the version of maven

---
## Changing the JDK for Maven
we can change the JDK for maven, when we have multiples JDKs using
`set JAVA_HOME=C:\Program Files\devtools\java\Eclipse Adoptium\jdk-17.0.10.7-hotspot`

---

## Creating first App using maven Archetypes
maven has a lot of built-in archetypes to build our own projects for example
- [x] maven-archetype-quickstart An archetype to generate a sample Maven project.
- [ ] maven-archetype-webapp An archetype to generate a sample Maven Webapp project.
- [ ] maven-archetype-plugin An archetype to generate a sample Maven plugin.

we used the **maven-archetype-quickstart** to generate simple project structure
```dtd
mvn archetype:generate 
-DgroupId=com.packt.cookbook 
-DartifactId=simple-project 
-DarchetypeArtifactId=mavenarchetype-quickstart 
-DinteractiveMode=false
```

---

## Project Structure


- **Project Root**
  - **src**
    - **main**
      - java
      - resources
    - **test**
      - java
      - resources
  - **pom.xml**

pom.xml is the project object modes, central piece of information.

---
## Maven repositories

##### There are three types of Maven repositories
- **Local**: This is the repository in your computer filesystem.
- **Remote**: This is the repository from where the required Maven files get downloaded.
- **Mirrors**: These are repository managers, such as Nexus and Artifactory, that mirror various repositories.

All Dependencies & Plugin downloaded from maven central and other repositories are stored locally on `/users/user/.m2`

.m2 folder may be hidden, so we can show it from directories options

.m2 contains all dependencies, plugins downloaded from repositories

The plugins stored in `~/.m2/repository/org/apache/maven/plugins`

The dependencies are stored based on the group as the groupId will be converted to tree of directory structure.

Maven will use **settings.xml** in the user's **.m2** folder, if not found will get the settings info from the default
**settings.xml**, present in the conf folder of the Maven installation.


We can change the location of repository in .m2 folder to be on any location on your machine using the **localRepository** tag in settings.xml

```dtd
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository>C:/software/maven</localRepository>
    </settings>
```
Here the plugins, dependencies will be stored in the C:/software/maven path instead of **.m2**

**Note** these settings could be in **.m2** directory in **settings.xml** file or in **maven/conf/settings.xml** as public settings.

---
## Understanding the standard directory layout

- **Project Root**
    - **target**
        - **classes**
        - **test-classes**
        - **surefire-reports**
        - **.jar file**
        - **maven-archiver**
        - **maven-status**
    - **pom.xml**

- **classes**           -> contains the src/main/java compiled classes, src/main/resources files.
- **test-classes**      -> contains the src/test/java compiled classes, src/test/resources files.
- **surefire-reports**  -> Test reports are separately placed in this folder.
  Typically, both XML and HTML report formats are available.
- **The output .jar file** -> The generated project artifact is also present in this folder.
- **maven-archiver and maven-status** hold information used by Maven during the build.
