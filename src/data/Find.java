package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public final class Find {

    private static final String filename = "data/find.txt";
    private List<Person> people;

    public Find() {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return this.people;
    }

    public void collect() {
        File file = new File(filename);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String[] next = scan.nextLine().split(" ");
                Person person;
                if (next.length == 1) {
                    person = new Person(next[0], "");
                } else {
                    person = new Person(next[0], next[1]);
                }
                people.add(person);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        }
    }
}
