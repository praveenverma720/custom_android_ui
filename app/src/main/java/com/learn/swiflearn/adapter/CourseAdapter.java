package com.learn.swiflearn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.swiflearn.R;
import com.learn.swiflearn.models.CourseResModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseItem> {


    private final Context context;
    CourseResModel courseResModel;

    public CourseAdapter(Context context, CourseResModel courseResModel){

        this.context = context;
        this.courseResModel = courseResModel;
    }

    @NonNull
    @Override
    public CourseItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.course_recycler_item,parent,false);
        return new CourseItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseItem holder, int position) {

        holder.courseTitleTV.setText(courseResModel.getData().get(position).getSubjectTitle());
        holder.lessionTitleTV.setText(courseResModel.getData().get(position).getLessionTitle());
        holder.lessionDescTV.setText(courseResModel.getData().get(position).getLessionShortDesc());
        holder.dateTV.setText(courseResModel.getData().get(position).getTakenDate());
        holder.studentTV.setText(courseResModel.getData().get(position).getTakenBy());
    }

    @Override
    public int getItemCount() {
        return courseResModel.getData().size();
    }

    class CourseItem extends RecyclerView.ViewHolder{

        private TextView courseTitleTV,lessionTitleTV,lessionDescTV,dateTV,studentTV;
         public CourseItem(@NonNull View itemView) {
             super(itemView);
             courseTitleTV  = itemView.findViewById(R.id.courseTitleTV);
             lessionTitleTV = itemView.findViewById(R.id.lessionTitleTV);
             lessionDescTV = itemView.findViewById(R.id.lessionDescTV);
             dateTV = itemView.findViewById(R.id.dateTV);
             studentTV = itemView.findViewById(R.id.studentTV);

         }
     }
}
