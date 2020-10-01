package anton.ryaby_belstu.stpmslab_02.educationmanager;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import anton.ryaby_belstu.stpmslab_02.exception.EduException;
import anton.ryaby_belstu.stpmslab_02.organization.Organizations;
import anton.ryaby_belstu.stpmslab_02.stuff.Stuff;
import anton.ryaby_belstu.stpmslab_02.units.Student;

public class Manager implements IAction {


    public Stuff readFromFile(String fileName, Context context) {

        InputStreamReader streamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = context.openFileInput(fileName);
            streamReader = new InputStreamReader(fileInputStream);
            Gson gson = new Gson();
            Stuff stuff = gson.fromJson(streamReader, Stuff.class);
            return stuff;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void writeToFile(Context context, Stuff stuff, String FILE_NAME) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(stuff);

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fileOutputStream.write(jsonString.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Stuff generarteCourse(int countOfStudents) {


        int min = 17;
        int max = 35;
        int diff = max - min;
        Random random = new Random();

        //Integer id, String name, String surname, int age, int year, int mark,Organizations organization
        Stuff stuff = new Stuff();
        Random rand = new Random();
        try {
            while (countOfStudents != 0) {

                int i = random.nextInt(diff + 1);
                i += min;

                stuff.add(new Student(countOfStudents,
                        RandomStringUtils.randomAlphabetic(10),
                        RandomStringUtils.randomAlphabetic(10),
                        i,
                        2020 - i ,
                        rand.nextInt(10) + 1,
                        Organizations.getRandom()
                ));
                countOfStudents--;

            }
        } catch (EduException e) {
            e.printStackTrace();
        }
        return stuff;
    }
}
