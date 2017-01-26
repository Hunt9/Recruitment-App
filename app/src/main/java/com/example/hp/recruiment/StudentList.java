package com.example.hp.recruiment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StudentList extends Fragment {


    private FirebaseDatabase mfirebaseDatabase;
    private DatabaseReference mdatabaseReference;
    private ChildEventListener childEventListener;
    private StudentAdapter mStudentAdapter;
    private ListView listView;

    public StudentList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        mfirebaseDatabase = mfirebaseDatabase.getInstance();
        mdatabaseReference = mfirebaseDatabase.getReference().child("Student");

        listView = (ListView)view.findViewById(R.id.StudentList);

        List<Student> studentz = new ArrayList<>();
        mStudentAdapter = new StudentAdapter(view.getContext(), R.layout.item_list, studentz);
        listView.setAdapter(mStudentAdapter);

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Student student = dataSnapshot.getValue(Student.class);
                mStudentAdapter.add(student);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };


        //mMessageDatabaseRefrence.addChildEventListener(mChildEventListner);

        mdatabaseReference.addChildEventListener(childEventListener);

        return view;

    }

}
