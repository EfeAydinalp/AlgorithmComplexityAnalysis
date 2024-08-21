# BBM204 - Programming Assignment 1: Algorithm Complexity Analysis

## Assignment Overview

This repository contains the implementation and analysis of various sorting and searching algorithms as part of the first programming assignment for the BBM204 Software Laboratory II course. The main objective of the assignment is to demonstrate the relationship between the running time of algorithm implementations and their theoretical asymptotic complexities.

### Implemented Algorithms
The following algorithms are implemented in Java:

#### Sorting Algorithms
1. **Insertion Sort** - A comparison-based sorting algorithm.
2. **Merge Sort** - A comparison-based sorting algorithm.
3. **Counting Sort** - A non-comparison-based sorting algorithm.

#### Searching Algorithms
1. **Linear Search**
2. **Binary Search**

### Datasets
The algorithms are tested on a subset of a real-world dataset, `TrafficFlowDataset.csv`, which includes more than 250,000 communication packet captures. The sorting and searching operations are performed on the "Flow Duration" feature in the dataset.

### Experiment Details
Experiments were conducted to evaluate the performance of the algorithms under various conditions:
- **Sorting Algorithms**: Tested with random, sorted, and reverse-sorted data of varying sizes.
- **Searching Algorithms**: Tested with random and sorted data of varying sizes.

### Results
The results include the running times of each algorithm for different input sizes and conditions. These results are presented in tables and visualized in plots to illustrate the relationship between the empirical data and the theoretical complexities.

## Repository Structure
- `src/`: Contains the Java source code for the implemented algorithms.
- `data/`: Contains the dataset files used for testing.
- `results/`: Includes the tables and plots generated from the experiments.
- `report/`: The analysis report discussing the results and findings.
- `README.md`: This file, providing an overview of the project.

## How to Run
1. Clone the repository:
    ```bash
    git clone https://github.com/EfeAydinalp/AlgorithmComplexityAnalysis.git
    cd AlgorithmComplexityAnalysis
    ```
2. Compile the Java files:
    ```bash
    javac src/*.java -d bin/
    ```
3. Run the experiments:
    ```bash
    java -cp bin/ MainClass
    ```

### Compilation and Execution
For testing your code on **Linux-based** systems:

**Compilation:**
```bash
javac -cp *.jar *.java -d .
```

**Execution:**
```bash
java -cp .:* Main TrafficFlowAll.csv
```

### Compilation and Execution
For testing your code on Windows systems (Powershell):

**Compilation:**
```bash
javac -cp *.jar *.java -d .

```

**Execution:**
```bash
java -cp '.;*' Main .\TrafficFlowAll.csv
```

How to increase the heap memory size in JVM so you can perform all the wanted tests:
The solution is to increase the heap size with command line argument:

-Xmxn:


Specifies the maximum size, in bytes, of the memory allocation pool. This value must a multiple of 1024 greater than 2 MB. Append the letter k or K to indicate kilobytes, or m or M to indicate megabytes. The default value is chosen at runtime based on system configuration.

For server deployments, -Xms and -Xmx are often set to the same value. See Garbage Collector Ergonomics at


http://docs.oracle.com/javase/7/docs/technotes/guides/vm/gc-ergonomics.html

Examples:
```bash
-Xmx83886080
-Xmx81920k
-Xmx2048M (2 gigs)
```


Reference: https://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html#nonstandard

You can download the .jar file for the XChart library using the following link:

https://knowm.org/open-source/xchart/

Check this out for adding .jar files to an eclipse project:

https://www.edureka.co/community/4028/how-to-import-a-jar-file-in-eclipse

Check these out for adding .jar files to an IntelliJ IDEA project:

https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project

https://www.jetbrains.com/help/idea/library.html#lib_levels

