package anton.ryaby_belstu.stpmslab_02.units;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Listener extends Person {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Listener(Integer id, String name, String surname, int age, int year) {
        super(id, name, surname, age, year);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Listener(String name, String surname, int age) {
        super(name, surname, age);
    }

    @Override
    public String toString() {
        return "Listener{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
