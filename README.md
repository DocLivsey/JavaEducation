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
   + Maven dependencies manager
   + Maven phases



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