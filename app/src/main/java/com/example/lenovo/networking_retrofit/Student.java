package com.example.lenovo.networking_retrofit;

import com.google.gson.annotations.SerializedName;

public class Student {

  private String  studentname;
  private String xx;

    public Student(String studentname, String xx) {
        this.studentname = studentname;
        this.xx = xx;
    }

    public String getStudentname() {
        return studentname;
    }

    public String getXx() {
        return xx;
    }
}
