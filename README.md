# Guide to Java Learning

## on the "Get Course" platform from "Reliability Technologies"

> [!NOTE]
> Readme file
still in the writing stage and not yet completed

1. [Git Commands](#a-idgit-commands--1-git-commands)
2. Java hacks
3. IDE`s hacks
   + IntelliJ IDEA`s hacks



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