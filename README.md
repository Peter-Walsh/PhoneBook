# PhoneBook
Sorts/searches a phonebook using different searching and sorting algorithms. Also implements a hashtable and uses that instead.

# Goal
The goal of this project was for me to implement several of the basic searching and sorting algorithms and get a better 
understanding of the Big-O notation. In my data structures course, we looked at Big-O notation, however we never worked 
with data sets large enough to really see it's affects.

# Functionality
- Storing/Searching for elements in a hashtable
- Sorting/Searching for elements using quicksort/binary-search
- Sorting/Searching using bubblesort/jump-search (I don't recommend doing this)
- Searching using linear search

# What I learned
- Big-O notation and its affect on the runtime of algorithms
- Implementation of hashtables (chaining method)
- Implementation of basic searching and sorting algorithms
- Object-oriented design
- Experience using Java

# How to get started
In order for the application or program to run, you need to have Java installed on your machine. If I had to guess, anything later
than Java 8 will be fine, but to be safe use Java 15.0.1

To run the application, navigate to the Main.java file located here:
```
src >>> main >>> Main.java
```
From there you should be able to run the program, if it's running properly, the following output should appear in the console:
```
Collecting data from files...
Data collection successful!

1. Linear Search
2. Jump Search / Bubble Sort
3. Jump Search / Quick Sort
4. Binary Search / Quick Sort
5. Construct HashTable
Your choice:
```

To select a searching/sorting method option, enter the number that corresponnds to the searching/sorting method want to use. 
For instance, to search with Linear Search, enter "1". After selecting an option the program will terminate.
