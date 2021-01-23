package utilities;

import algorithms.SearchingAlg;
import algorithms.SortingAlg;
import data.Person;
import java.util.List;

public class Searcher {
    Counter counter;
    SortingAlg<Person> sorter;
    SearchingAlg<Person> searcher;
    List<Person> people;
    int count;

    public Searcher(SortingAlg<Person> sorter, SearchingAlg<Person> searcher, List<Person> people) {
        this.counter = new Counter();
        this.sorter = sorter;
        this.searcher = searcher;
        this.people = people;
        this.count = 0;
    }

    public void execute() {
        counter.start();
        sorter.sort();
        count = searcher.search(people);
        printResult();
    }

    private void printResult() {
        System.out.println("" + count + " / 500 items found");
        System.out.println("Time taken: " + counter.getTimeTaken());
    }
}
