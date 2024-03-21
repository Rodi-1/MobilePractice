package com.example.pr3;


import android.os.Parcelable;
import android.os.Parcel;


public class Student implements Parcelable
{

    private String name;
    private int age;
    private String group;
    private int desired_mark;

    public Student(String name, int age, String group, int desired_mark)
    {
        this.name = name;
        this.age = age;
        this.group = group;
        this.desired_mark = desired_mark;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public int getDesired_mark() {
        return desired_mark;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(name);
        dest.writeString(group);
        dest.writeInt(age);
        dest.writeInt(desired_mark);
    }

    protected Student(Parcel in) {
        name = in.readString();
        group = in.readString();
        age = in.readInt();
        desired_mark = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in)
        {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size)
        {
            return new Student[size];
        }
    };
}
