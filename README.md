# Guide to Java Learning

## on the "Get Course" platform from "Reliability Technologies"

> [!NOTE]
> Readme file
still in the writing stage and not yet completed

1. [Git Commands](#a-idgit-commands--1-git-commands)
2. [Java hacks](#2-java-hacks)
   + [Java built-in exceptions](#java-built-in-exceptions)
   + [Your own exceptions](#your-own-exceptions)
3. IDE`s hacks
   + IntelliJ IDEA`s hacks
4. [Maven](#a-idmaven--4-maven)
   + [Structure of Maven project](#a-idstructure-structure-of-maven-project)
   + [Maven dependencies manager](#a-iddep-manager-maven-dependencies-manager)
   + [Maven phases](#maven-phases)
5. [Spring and etc](#5-spring-and-etc)
   + [Spring Core](#spring-core)


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


### 2. Java hacks

#### Java built-in exceptions

Standard exceptions described in JAVA.
+ ArithmeticException - arithmetic error, for example, division by zero
+ ArrayIndexOutOfBoundsException - index goes beyond the array boundary
+ ArrayStoreException - assigning an object of an incompatible type to an array element
+ ClassCastException - invalid cast
+ EnumConstantNotPresentException - an attempt to use an undefined enumeration value
+ IllegalArgumentException - invalid argument when calling a method
+ IllegalMonitorStateException - invalid monitoring operation
+ IllegalStateException - incorrect application state
+ IllegalThreadStateException - the requested operation is incompatible with the current thread
+ IndexOutofBoundsException - the index type is out of acceptable limits
+ NegativeArraySizeException - an array of negative size was created
+ NullPointerException - incorrect use of a null reference
+ NumberFormatException - invalid conversion of string to number format
+ SecurityException - attempt to violate security
+ StringIndexOutOfBounds - attempt to use an index outside the string
+ TypeNotPresentException - type not found
+ UnsupportedOperationException - an unsupported operation was detected
+ A list of checked system exceptions that can be included in the throws list.
+ ClassNotFoundException - class not found
+ CloneNotSupportedException - an attempt to clone an object that does not implement the Cloneable interface
+ IllegalAccessException - access to the class is denied
+ InstantiationException - an attempt to create an object of an abstract class or interface
+ InterruptedException - the thread was interrupted by another thread
+ NoSuchFieldException - the requested field does not exist
+ NoSuchMethodException - the requested method does not exist
+ ReflectiveOperationException - exception associated with reflection

#### Your own exceptions

The system cannot provide for all exceptions; sometimes you will have to create your own exception type for your application. You need to inherit from Exception (let me remind you that this class inherits from Throwable) and override the necessary methods of the Throwable class. Or you can inherit from an already existing type that is closest in logic to your exception. Also, when choosing a parent class, you must understand what type of exception you want to generate, whether checked or not; if you need to create an unchecked exception, you must select RuntimeException as the ancestor

+ final void addSuppressed(Throwable exception) - adds an exception to the list of suppressed exceptions (JDK 7)
+ Throwable fillInStackTrace() - Returns a Throwable object containing the complete stack trace.
+ Throwable getCause() - returns the exception underlying the current exception or null
+ String getLocalizedMessage() - returns the localized description of the exception
+ String getMessage() - returns a description of the exception
+ StackTraceElement[] getStackTrace() - returns an array containing the stack and state traces from elements of the StackTraceElement class
+ final Throwable[] getSuppressed() - gets suppressed exceptions (JDK 7)
+ Throwable initCause(Throwable exception) - associates the exception with the causing exception. Returns a reference to the exception.
+ void printStackTrace() - displays the stack trace
+ void printStackTrace(PrintStream stream) - sends a stack trace to the specified stream
+ void setStackTrace(StackTraceElement elements[]) - sets the stack trace for elements (for specialized applications)
+ String toString() - returns a String class object containing a description of the exception.

The easiest way is to create a class with a default constructor. But there are also constructors:

>`Exception(String message)` - Allows you to specify a message

>`Exception(Throwable cause)` - Allows you to specify the root cause

>`Exception(String message, Throwable cause)` - Allows you to specify the message and root cause

>`Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)` - Allows you to 
> specify the message, root cause, suppression capability, and write stacktrace flag.

Let’s look at the latter in a little more detail; recording a stack trace is a labor-intensive task, 
and if the developer generates his own exception, then he may not need to disable the stack trace output. 
You should also know that the JVM can optimize by removing the stacktrace output for errors that are often generated, 
to prevent this from happening, you must specify the flag -XX:-OmitStackTraceInFastThrow implementation in 
native code https://hg.openjdk.java.net/jdk/jdk /file/tip/src/hotspot/share/opto/graphKit.cpp, 
the stacktrace stops being displayed after PerMethodTrapLimit (default value 100).


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

Before the package is launched, the validate, compile, and test phases are performed. The exception is the clean phase. It is advisable to call it before each new project build. Phases can be listed separated by spaces:\
mvn clean package.


### 5. Spring and etc

#### Spring Core

Spring consists of several core technologies:

+ **IOC container**

Inversion of control (IOC) is a software design principle in which control over the creation and life cycle of objects passes from the developer to the container. This means that instead of explicitly creating objects in code, we define the configuration of objects in the IoC container, which then creates and manages those objects.
  Spring uses the expression Dependency Injection, which is a special form of IOC whereby an object in a container is itself a dependency, and the fields (external dependencies) it requires to operate are set on the object instance after it is created or returned from the factory. method (not by us, but by the IOC container itself).

To get to know the IOC container in more detail, you can try running your own container. Generate a basic project https://start.spring.io/ Java, Maven, specify Spring WEB in the dependencies. Then download the project to your computer.

The project's launch point will be the DemoApplication class, on which you will see the @SpringBootApplication annotation. Try running your project and thereby raising the context.