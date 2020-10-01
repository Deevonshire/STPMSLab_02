package anton.ryaby_belstu.stpmslab_02;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import anton.ryaby_belstu.stpmslab_02.educationmanager.Manager;
import anton.ryaby_belstu.stpmslab_02.stuff.Stuff;
import anton.ryaby_belstu.stpmslab_02.units.Person;
import anton.ryaby_belstu.stpmslab_02.units.Student;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LabOOP_2", "/*------------------ Random generated collection ------------------*/");

        Manager manager = new Manager();
        Stuff stuff = manager.generarteCourse(10);
        for (Person student : stuff.getStudlist()) {
            Student stud = (Student) student;
            try {
                Log.d("LabOOP_2", "Name: " + stud.getName() + " | Surname: " + stud.getSurname() + " | Age: " + stud.getAge()
                        + " | Organization: " + stud.getOrganization() + " | Mark: " + stud.getMark());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d("LabOOP_2", "/*------------------ Sort by marks  ------------------*/");

        List<Student> personsList1 = stuff.sortByMarks();
        for (Person student : personsList1) {
            Student stud = (Student) student;
            try {
                Log.d("LabOOP_2",  "Name: " + stud.getName() + " | Surname: " + stud.getSurname() + " | Age: " + stud.getAge()
                        + " | Organization: " + stud.getOrganization() + " | Mark: " + stud.getMark());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Log.d("LabOOP_2", "/*------------------ Sort by age  ------------------*/");

        List<Student> personsList2 = stuff.sortByAge1();
        for (Person student : personsList2) {
            Student stud = (Student) student;

            try {
                Log.d("LabOOP_2",  "Name: " + stud.getName() + " | Surname: " + stud.getSurname() + " | Age: " + stud.getAge()
                        + " | Organization: " + stud.getOrganization() + " | Mark: " + stud.getMark());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Log.d("LabOOP_2", "/*------------------ Serialization / Deserialization ------------------*/");

        manager.writeToFile(this, stuff, "Students.json");
        Log.d("LabOOP_3", manager.readFromFile("Students.json", this).toString());

    }
}
