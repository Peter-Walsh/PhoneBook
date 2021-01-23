package main;
import java.util.Scanner;
import java.util.List;

import algorithms.searching.BinarySearch;
import algorithms.searching.JumpSearch;
import algorithms.searching.LinearSearch;
import algorithms.sorting.BubbleSort;
import algorithms.sorting.QuickSort;
import algorithms.*;

import data.*;
import hashtables.ChainedHashTable;
import utilities.*;


public class Menu {

    private List<Person> phoneBook;
    private List<Person> people;

    public Menu() {
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Collecting data from files...");

        Directory phoneBook = new Directory();
        phoneBook.collect();
        this.phoneBook = phoneBook.getPeople();

        Find names = new Find();
        names.collect();
        this.people = names.getPeople();

        System.out.println("Data collection successful!");
        System.out.println();
        printMenu();
        int choice = scan.nextInt();
        System.out.println();

        switch (choice) {

            case 1:
                doLinearSearch();
                break;
            case 2:
                doBubbleSortJumpSearch();
                break;
            case 3:
                doQuickSortJumpSearch();
                break;
            case 4:
                doQuickSortBinarySearch();
                break;
            case 5:
                doHashTable();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    private void printMenu() {
        System.out.println("1. Linear Search");
        System.out.println("2. Jump Search / Bubble Sort");
        System.out.println("3. Jump Search / Quick Sort");
        System.out.println("4. Binary Search / Quick Sort");
        System.out.println("5. Construct HashTable");
        System.out.print("Your choice: ");
    }

    public void doLinearSearch() {
        SearchingAlg<Person> searcher = new LinearSearch<>(phoneBook);
        Counter counter = new Counter();
        counter.start();
        int count = searcher.search(people);
        counter.stop();
        System.out.println("" + count + " / 500 items found");
        System.out.println("Time taken: " + counter.getTimeTaken());
    }

    public void doQuickSortJumpSearch() {
        SortingAlg<Person> sorter = new QuickSort<>(phoneBook);
        SearchingAlg<Person> searcher = new JumpSearch<>(phoneBook);
        Searcher search = new Searcher(sorter, searcher, people);
        search.execute();
    }


    public void doQuickSortBinarySearch() {
        SortingAlg<Person> sorter = new QuickSort<>(phoneBook);
        SearchingAlg<Person> searcher = new BinarySearch<>(phoneBook);
        Searcher search = new Searcher(sorter, searcher, people);
        search.execute();
    }

    public void doBubbleSortJumpSearch() {
        SortingAlg<Person> sorter = new BubbleSort<>(phoneBook);
        SearchingAlg<Person> searcher = new JumpSearch<>(phoneBook);
        Searcher search = new Searcher(sorter, searcher, people);
        search.execute();
    }

    public void doHashTable() {
        Counter counter = new Counter();
        counter.start();
        ChainedHashTable<Person> table = new ChainedHashTable<>(phoneBook);
        int count = 0;
        for (Person person : people) {
            if (table.contains(person)) {
                count++;
            }
        }
        counter.stop();
        System.out.println("" + count + " / 500 items found");
        System.out.println("Time taken: " + counter.getTimeTaken());
    }
}
