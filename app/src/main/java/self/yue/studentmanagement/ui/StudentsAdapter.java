package self.yue.studentmanagement.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import self.yue.studentmanagement.R;
import self.yue.studentmanagement.data.Student;

/**
 * Created by dongc on 4/6/2017.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ItemHolder> {
    private List<Student> mStudents;

    public StudentsAdapter(List<Student> students) {
        mStudents = students;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.textName.setText(mStudents.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mStudents != null ? mStudents.size() : 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        public TextView textName;

        public ItemHolder(View itemView) {
            super(itemView);
            textName = (TextView) itemView.findViewById(R.id.text_name);
        }
    }
}
