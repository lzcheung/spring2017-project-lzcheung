package main.java.controller;

import java.util.ArrayList;
import java.util.List;

import main.java.model.Exam;
import main.java.model.Student;

public class DataSingleton {
  private static final DataSingleton INSTANCE = new DataSingleton();
  private ArrayList<Student> students;
  private ArrayList<Exam> exams;
  
  private DataSingleton() {
    this.students = new ArrayList<>();
    this.exams = new ArrayList<>();
  }
  
  public static DataSingleton getInstance() {
    return INSTANCE;
  }
  
  public void addStudent(Student student) {
    students.add(student);
  }
  
  public void addExam(Exam exam) {
    exams.add(exam);
  }

  public int getNumOfStudents() {
    return students.size();
  }
  
  public int getNumOfExams() {
    return exams.size();
  }

  public List<Student> getStudents() {
    return students;
  }

  public List<Exam> getExams() {
    return exams;
  }
}
