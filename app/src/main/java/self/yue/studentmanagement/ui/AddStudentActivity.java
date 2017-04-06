package self.yue.studentmanagement.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import self.yue.studentmanagement.R;
import self.yue.studentmanagement.data.Student;
import self.yue.studentmanagement.utils.FileUtil;

/**
 * Created by dongc on 4/6/2017.
 */

public class AddStudentActivity extends AppCompatActivity {
    private EditText mEditClassId;
    private EditText mEditId;
    private EditText mEditName;
    private EditText mEditAverageScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        initViews();
    }

    private void initViews() {
        mEditClassId = (EditText) findViewById(R.id.edit_class_id);
        mEditId = (EditText) findViewById(R.id.edit_id);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditAverageScore = (EditText) findViewById(R.id.edit_average_score);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String classId = mEditClassId.getText().toString();
                String id = mEditId.getText().toString();
                String name = mEditName.getText().toString();
                String averageScore = mEditAverageScore.getText().toString();
                if (!TextUtils.isEmpty(classId) && !TextUtils.isEmpty(id)
                        && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(averageScore)) {
                    Student student = new Student(id, classId, name, Float.parseFloat(averageScore));
                    Gson gson = new Gson();
                    String data = gson.toJson(student);
                    try {
                        FileUtil.getInstance().saveToFile(data, FileUtil.WriteOption.APPEND);
                        showSnackbar("Successful");
                    } catch (IOException e) {
                        showSnackbar(e.getMessage());
                    }
                }
            }
        });
    }

    public void showSnackbar(String message) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }
}
