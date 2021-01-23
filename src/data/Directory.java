package data;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public final class Directory {

    private static final String filename = "data/directory.txt";
    private final List<Person> people;

    public Directory() {
        this.people = new ArrayList<>();
    }

    public List<Person> getPeople() {
        return people;
    }

    public void collect() {
        File file = new File(filename);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String[] next = scan.nextLine().split(" ");
                Person person;
                if (next.length == 2) {
                    person = new Person(next[1], "");
                } else {
                    person = new Person(next[1], next[2]);
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
