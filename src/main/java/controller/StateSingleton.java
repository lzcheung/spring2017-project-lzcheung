package main.java.controller;

import java.util.ArrayList;

import main.java.model.Exam;
import main.java.model.Student;

public class StateSingleton {
  private static final StateSingleton INSTANCE = new StateSingleton();
  private ArrayList<Student> students;
  private ArrayList<Exam> exams;
  
  public StateSingleton() {
    this.students = new ArrayList<>();
    this.exams = new ArrayList<>();
  }
  
  public static StateSingleton getInstance() {
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
  
  public void printExams() {
    for (Exam exam: exams) {
      System.out.println(exam.toString());
    }
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  public ArrayList<Exam> getExams() {
    return exams;
  }
}
