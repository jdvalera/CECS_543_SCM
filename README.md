# CECS_543_SCM
Source Code Management Project for CECS 543-02
Part 1

## Introduction

The finished product will be an SCM (Source Code Management) project. The first part of the project implemented will be the initial use-case: Create Repo. To get working software quickly, we will code using MVP (Minimum Viable Product) and code with a focus on the "success path" of a user scenario. The SCM repository will eventually hold multiple versions of a given file which is why a weighted checksum is used to give a each file (artifact) a unique ID. 


## File List
* Artifact.java
* Manifest.java
* ManifestFields.java
* Repository.java

## Running the Program
The main class of the program is Repository.java

1. To run the program copy the files listed above
2. Compile Repository.java

   ```
   javac Repository.java
   ```
3. Run the Repository class with the first argument as the src directory path and the second argument as the dest directory path. (You can use an absolute or relative path)
  ```
  java Repository ./sourcePath ./destPath
  ```
  
## Bugs
If you are using Windows file paths, you will have to use double slashes '//' instead of single slashes '/' in the command.

For example, instead of writing:
```
java Repository C:\Users\John\Desktop\learn C:\Users\John\Desktop\destTest
```

Write this instead:
```
java Repository C:\\Users\\John\\Desktop\\learn C:\\Users\\John\\Desktop\\destTest
```
