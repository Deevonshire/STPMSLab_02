package anton.ryaby_belstu.stpmslab_02.educationmanager;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

public interface IAction {
    @RequiresApi(api = Build.VERSION_CODES.N)
    default void print()
    {
        Log.d("LabOOP_2","Default method of interface");
    }
    static boolean isNull(String str) {
        Log.d("LabOOP_2", "Check on the null string");;

        return str == null ? true : false;
    }
}
