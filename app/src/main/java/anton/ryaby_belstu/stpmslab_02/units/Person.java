package anton.ryaby_belstu.stpmslab_02.units;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Optional;

public abstract class Person implements Comparable<Person> {
    protected Integer id;
    private static int countOfObjects;
    protected String name;
    Optional<String> surname;
    protected int age;
    protected int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Person(Integer id, String name, String surname, int age, int year) {
        this.id = id;
        this.name = name;
        this.surname= Optional.of(surname);
        this.age = age;
        this.year = year;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = Optional.of(surname);
        this.age = age;
        countOfObjects++;
        id=countOfObjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.id.compareTo(person.id);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getSurname() throws Exception {
        if(surname.isPresent())
        {
            return surname.get();
        }
        else
        {
            throw new Exception("null string");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setSurname(String surname) {
        this.surname = Optional.of( surname);
    }

    public int getAge() {
        return age;
    }

    public Person() {
    }

    public void setAge(int age) {
        this.age = age;
    }

}
