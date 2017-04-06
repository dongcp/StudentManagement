package self.yue.studentmanagement.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import self.yue.studentmanagement.R;
import self.yue.studentmanagement.data.Student;
import self.yue.studentmanagement.utils.FileUtil;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecylerStudents;

    private List<Student> mStudents;
    private StudentsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        try {
            populateData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        mRecylerStudents = (RecyclerView) findViewById(R.id.recycler_students);
        mRecylerStudents.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.fab_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newIntent(AddStudentActivity.class));
            }
        });
    }

    private void populateData() throws IOException {
        String data = FileUtil.getInstance().readFromFile();

        if (!TextUtils.isEmpty(data)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Student>>() {
            }.getType();
            mStudents = gson.fromJson(data, type);
        }

        mAdapter = new StudentsAdapter(mStudents);
        mRecylerStudents.setAdapter(mAdapter);
    }

    private Intent newIntent(Class activity) {
        return new Intent(this, activity);
    }
}
