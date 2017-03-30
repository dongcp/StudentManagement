package self.yue.studentmanagement.data;

import self.yue.studentmanagement.utils.Comparator;

/**
 * Created by yue on 3/30/17.
 */

public class Student implements Comparator<Student> {
    private String mId;
    private String mClassId;
    private String mName;
    private float mAverageScore;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getClassId() {
        return mClassId;
    }

    public void setClassId(String classId) {
        mClassId = classId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getAverageScore() {
        return mAverageScore;
    }

    public void setAverageScore(float averageScore) {
        mAverageScore = averageScore;
    }

    public void swap(Student student) {
        mId = student.getId();
        mClassId = student.getClassId();
        mName = student.getName();
        mAverageScore = student.getAverageScore();
    }

    @Override
    public int compareTo(Student object) {

        return 0;
    }
}
