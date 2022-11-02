package de.faktorzehn.model;

import java.util.List;
import java.util.Objects;

public class Group {

    public static final String PROPERTY_NAME = "name";
    public static final String ASSOCIATION_PEOPLE = "people";

    private String name;
    private List<Person> people;

    public Group() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Group group = (Group)o;

        if (!Objects.equals(name, group.name))
            return false;
        return Objects.equals(people, group.people);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (people != null ? people.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", people=" + people +
                '}';
    }
}
