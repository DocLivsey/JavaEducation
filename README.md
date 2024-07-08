# Guide to Java Learning

## on the "Get Course" platform from "Reliability Technologies"

> [!NOTE]
> Readme file
still in the writing stage and not yet completed

1. [Git Commands](#a-idgit-commands--1-git-commands)
2. Java hacks
3. IDE`s hacks
   + IntelliJ IDEA`s hacks
4. [Maven](#a-idmaven--4-maven)
   + [Structure of Maven project](#a-idstructure-structure-of-maven-project)
   + [Maven dependencies manager](#a-iddep-manager-maven-dependencies-manager)
   + [Maven phases](#maven-phases)



### <a id="git-commands" /> 1. Git Commands

To create a local repository, we will use Git Bash: 
via Git or built into the IDE
using the `ls/dir` and `cd` commands we move through the directories 
and go to the one where we want to create a local repository

Next we write the commands: 
>+ `git init` to create local repository
>+ `git status` to check the files status 
**_(untracked | modified | staged | committed)_**
>+ `git add` to add file/files into git`s "index"
>  + `git add .` to add all files, equals to `git add --all` 
>  + `git add <file/files>` to add selected file/files. 
>  Here you can use regular expressions to add according to 
>  some pattern. For example, `git add *.java` this means that 
>  you only need to add files with the java extension
>+ `git commit` to commit changes in selected files. 
After entering the command, switches to the default editor 
selected in `git config` (local >> global)
>  + `git commit -m '<some description>'` a commit is immediately 
  created with the entered description without going to the default editor




###  <a id="maven" /> 4. Maven

#### <a id="structure"> Structure of Maven project

[maven project structure screenshot](https://fs-thb01.getcourse.ru/fileservice/file/thumbnail/h/9973be9f91a02d2af69d3c7301ab1447.png/s/f1200x/a/320990/sc/147)

This is the standard structure for a Maven project:

+ the src/main/java folder contains java classes;
+ in src/main/resources - resources that our application uses (HTML pages, pictures, style sheets, etc.);
+ src/test - for tests.

Also pay attention to the file called pom.xml. This is the main file for managing Maven. The entire project description is contained here. There is not too much information there yet, but we will add it now.

#### <a id="dep-manager"> Maven dependencies manager

You may have come across the phrase “dependency manager” or “dependency manager”. 
Maven can do it all. Thanks to Maven, you don’t need to spend a lot of time searching for the required library 
on the Internet, downloading it, and then connecting it to the project: just add the required one to the list 
of Maven dependencies. Dependencies are written to the dependencies XML node.\
Let's say you need the Apache Commons IO library in your project for simplified work with files. 
To add a library, write five lines in pom.xml:
```xml
<dependency>
   <groupId>commons-io</groupId>
   <artifactId>commons-io</artifactId>
   <version>2.6</version>
</dependency>
```
All subsequent dependencies should also be written inside the <dependencies> tag. You might be wondering: how do you know what information you need to include about a library inside the <dependency> tag? Everything is simple here. In such cases, three parameters are always specified: groupId, artifactId and version. You can find out these parameters in two ways:
1. On the library website. If we need Apache Commons IO, go to the official website and select the Dependency Information tab. All the necessary information is here - you can simply copy it and add it to our dependencies section.
2. In the Maven repository. Enter “apache commons io” in the search and you will see all available versions of the library.

### Maven phases

The process of building an application is called the life cycle of a Maven project, and it consists of phases. You can look at them in IDEA by clicking on Maven>example>Lifecycle in the upper right corner:

As you can see, there are 9 phases:

>clean - removes all compiled files from the target directory (the place where finished artifacts are saved);

>validate - checking whether all information is available for building the project;

>compile - files with source code are compiled;

>test — tests are launched;

>package - compiled files are packaged (into jar, war, etc. archive);

>verify — checks are performed to confirm the readiness of the packed file;

>install - the package is placed in the local repository. Now it can be used by other projects as an external library;

>site - project documentation is created;

>deploy - the collected archive is copied to a remote repository.

All phases are executed sequentially: you cannot start, say, the fourth phase until phases 1-3 are completed. There are two ways to start a phase:

via command line:
mvn package

using Intellij IDEA:

Before the package is launched, the validate, compile, and test phases are performed. The exception is the clean phase. It is advisable to call it before each new project build. Phases can be listed separated by spaces:
mvn clean package.