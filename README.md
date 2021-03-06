
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

## External Requirements
You have to have the Java Development Kit (JDK) installed to compile and run the java code.

## Setup
If you do not have the JDK installed, go to the Oracle website and download the JDK to compile and run the program.
[JDK download link](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

## Running the Program
The main class of the program is Repository.java

1. To run the program copy the files listed above into a directory
2. Go into the directory that you copied the files to
3. Compile Repository.java

   ```
   javac Repository.java
   ```
4. Run the Repository class with the first argument as the src directory path and the second argument as the dest directory path. (You can use an absolute or relative path)
  ```
  java Repository ./sourcePath ./destPath
  ```
  
## Checking in new files

1. Copy the files listed above into a directory
2. Go into the directory that you copied the files to
3. Compile Repository.java

```
javac Repository.java
```
4. Run the Repository class with the first argument as `check-in`, the second argument is the source directory path, and the third argument is the destination directory path.

```
java Repository check-in ../sourcePath ../destPath
```

## Checking out files

1. Copy the files listed above into a directory
2. Go into the directory that you copied the files to
3. Compile Repository.java

```
javac Repository.java
```
4. Run the Repository class with the first argument as `check-out`, the second argument is the source directory path, the third argument is the destination directory path, and the fourth argument is the manifest date.

```
java Repository check-out ../repoPath ../destPath 05-10-2017-20-22
```

## Running on Eclipse

1. Clone the repository
2. Open Eclipse and import the cloned folder
3. Go to the file `TestSuite.java` and run it
4. Running the folder will create a directory `destTest` in the project directory

## Bugs
If you are using Windows file paths, you will have to use double slashes '\\' instead of single slashes '\' in the command.

For example, instead of writing:
```
java Repository C:\Users\John\Desktop\learn C:\Users\John\Desktop\destTest
```

Write this instead:
```
java Repository C:\\Users\\John\\Desktop\\learn C:\\Users\\John\\Desktop\\destTest
```
