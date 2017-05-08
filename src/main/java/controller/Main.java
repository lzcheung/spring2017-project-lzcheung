package main.java.controller;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    FileProcessor fp = new FileProcessor();
    System.out.println(fp.readFile(
        "/Users/lzcheung/Documents/CPE305/Project_workspace/SeatGenProject/resources/test.xlsx"));
  }
}
