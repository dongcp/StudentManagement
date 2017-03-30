package self.yue.studentmanagement.utils;

import java.util.List;

import self.yue.studentmanagement.data.Student;

/**
 * Created by yue on 3/30/17.
 */

public class SortUtil {

    public List<Student> insertionSort(List<Student> students, SortType sortType) {
        int numberOfStudents = students.size();

        if (numberOfStudents >= 2) {
            for (int i = 1; i < numberOfStudents; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (sortType == SortType.ASC) {
                        if (students.get(i).compareTo(students.get(j)) > 0) {
                            Student tmp = students.get(i);
                            students.get(i).swap(students.get(j));
                            students.get(j).swap(tmp);
                            i = j;
                        }
                    } else {
                        if (students.get(i).compareTo(students.get(j)) < 0) {
                            Student tmp = students.get(i);
                            students.get(i).swap(students.get(j));
                            students.get(j).swap(tmp);
                            i = j;
                        }
                    }
                }
            }
        }
        return students;
    }

    public enum SortType {
        ASC,
        DESC
    }
}
