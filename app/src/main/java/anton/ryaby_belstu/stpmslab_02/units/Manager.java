package anton.ryaby_belstu.stpmslab_02.units;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Manager extends Person {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Manager(String name, String surname, int age) {
        super(name, surname, age);
    }

}
