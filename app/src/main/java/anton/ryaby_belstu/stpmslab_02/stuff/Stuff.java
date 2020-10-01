package anton.ryaby_belstu.stpmslab_02.stuff;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import anton.ryaby_belstu.stpmslab_02.exception.EduException;
import anton.ryaby_belstu.stpmslab_02.units.Manager;
import anton.ryaby_belstu.stpmslab_02.units.Person;
import anton.ryaby_belstu.stpmslab_02.units.Student;

public class Stuff {
    private ArrayList<Student> studList = new ArrayList<Student>();

    public Stuff() {
    }

    public Stuff(ArrayList<Student> studList) {
        this.studList = studList;
    }

    public List<Student> getStudlist() {
        return studList;
    }

    public void setStudList(ArrayList<Student> studList) {
        this.studList = studList;
    }

    public boolean add(Person item) throws EduException {

        if (item instanceof Manager) {
            throw new EduException("Can't add a Manager");
        }
        return studList.add((Student) item);
    }

    public boolean remove(Person item) {
        return studList.remove(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public String toString() {
        String result = "";
        for (Person person : studList) {
            try {
                Student stud = (Student) person;
                result += ("\n" + "Name: " + person.getName() + " | Surname: " + person.getSurname() + " | Age: " + person.getAge()
                        + " | Organization: " + stud.getOrganization() + " | Mark: " + stud.getMark());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public List<Student> sortByMarks() {
        Collections.sort(studList, (Comparator<Person>) (person, t1) -> {
            if (person instanceof Student && t1 instanceof Student) {
                Integer mark1 = ((Student) person).getMark();
                Integer mark2 = ((Student) t1).getMark();
                return mark1.compareTo(mark2);
            }
            return 0;
        });
        return (List<Student>) studList.subList(6,10);
    }

    public List<Student> sortByAge1() {
        Collections.sort(studList, (Comparator<Person>) (person, t1) -> {
            if (person instanceof Student && t1 instanceof Student) {
                Integer age1 = ((Student) person).getAge();
                Integer age2 = ((Student) t1).getAge();
                return age1.compareTo(age2);
            }
            return 0;
        });
        return (List<Student>) studList.subList(6,10);
    }
}
