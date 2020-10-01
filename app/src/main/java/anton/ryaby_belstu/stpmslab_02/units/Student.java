package anton.ryaby_belstu.stpmslab_02.units;

import android.os.Build;

import androidx.annotation.RequiresApi;

import anton.ryaby_belstu.stpmslab_02.organization.Organizations;

public class Student extends Person {
    protected int mark;
    Organizations organization;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Student(Integer id, String name, String surname, int age, int year, int mark, Organizations organization) {
        super(id, name, surname, age, year);
        this.mark = mark;
        this.organization=organization;
    }

    public Student() {
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Student(String name, String surname, int age, int mark) {
        super(name, surname, age);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public Organizations getOrganization() {
        return organization;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "mark=" + mark +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
