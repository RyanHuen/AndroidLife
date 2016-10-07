package com.chaozhuo.rxexample.keyword.flatmap.entity;

import java.util.List;

/**
 * Created by ryanhuen on 16-10-6.
 */
public class Student {
    private String mName;
    private List<Course> mCourses;



    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<Course> getCourses() {
        return mCourses;
    }

    public void setCourses(List<Course> courses) {
        mCourses = courses;
    }
}
