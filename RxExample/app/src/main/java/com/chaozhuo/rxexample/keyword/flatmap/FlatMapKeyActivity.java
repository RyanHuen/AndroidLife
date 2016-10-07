package com.chaozhuo.rxexample.keyword.flatmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxexample.R;
import com.chaozhuo.rxexample.keyword.flatmap.entity.Course;
import com.chaozhuo.rxexample.keyword.flatmap.entity.Student;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class FlatMapKeyActivity extends AppCompatActivity {
    public static final String TAG = "FlatMapKeyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat_map_key);
        initStudents();
        subscriberUsingFlatMap();

    }

    private void subscriberUsingFlatMap() {
        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                Log.d(TAG, "onNext: CourseName is :" + course.getCourseName());
            }
        };
        final Observable<Student> observable = Observable.from(mStudents);
        observable.flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                return Observable.from(student.getCourses());
            }
        }).subscribe(subscriber);

    }

    List<Student> mStudents;

    private void initStudents() {
        mStudents = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student stu = new Student();
            stu.setName("course" + i);
            List<Course> courses = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Course course = new Course();
                course.setCourseName(course.toString());
                courses.add(course);
            }
            stu.setCourses(courses);
            mStudents.add(stu);
        }
    }
}
