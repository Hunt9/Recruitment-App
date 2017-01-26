package com.example.hp.recruiment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentPostFragment extends Fragment {


    public StudentPostFragment() {
        // Required empty public constructor
    }

    private TextView name;
    private TextView email;
    private TextView age;
    private TextView dept;
    private TextView rollno;
    private TextView cgpa;
    private Button post;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_post, container, false);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Student");

        name = (TextView)view.findViewById(R.id.STDNAME);
        email = (TextView)view.findViewById(R.id.STDEMAIL);
        age = (TextView)view.findViewById(R.id.STDAGE);
        dept = (TextView)view.findViewById(R.id.STDDEPT);
        rollno = (TextView)view.findViewById(R.id.STDROLLNO);
        cgpa = (TextView)view.findViewById(R.id.STDCGPA);

        post = (Button)view.findViewById(R.id.POST);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student student = new Student(name.getText().toString(),email.getText().toString(),age.getText().toString(),dept.getText().toString(),rollno.getText().toString(),cgpa.getText().toString(),null);
                databaseReference.push().setValue(student);

            }
        });






    return  view;
    }

}
