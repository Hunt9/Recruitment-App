package com.example.hp.recruiment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by hp on 1/27/2017.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_list, parent, false);
        }

        TextView nTextView = (TextView) convertView.findViewById(R.id.iName);
        TextView eTextView = (TextView) convertView.findViewById(R.id.iEmail);
        TextView aTextView = (TextView) convertView.findViewById(R.id.iAge);
        TextView dTextView = (TextView) convertView.findViewById(R.id.iDept);
        TextView rTextView = (TextView) convertView.findViewById(R.id.iRollNo);
        TextView cTextView = (TextView) convertView.findViewById(R.id.iCGPA);

        Student student = getItem(position);

        nTextView.setText(student.getName().toString());
        eTextView.setText(student.getEmail().toString());
        aTextView.setText(student.getAge().toString());
        dTextView.setText(student.getDeptName().toString());
        rTextView.setText(student.getRollNo().toString());
        cTextView.setText(student.getCgpa().toString());


        return convertView;
    }
}
