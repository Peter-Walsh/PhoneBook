package data;

public class Person implements Comparable<Person>{

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
        this.phoneNumber = phoneNumber;
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    public int compareTo(Person person) {
        String name1 = firstName + lastName;
        String name2 = person.firstName + person.lastName;
        return name1.compareTo(name2);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode() + lastName.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person temp = (Person) object;
        return temp.firstName.equals(this.firstName) &&
                temp.lastName.equals(this.lastName);
    }

    @Override
    public String toString() {
        return firstName + "-" + lastName;
    }

}
