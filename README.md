# Auto-Seat Generator [![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung)

## Introduction

Everyday, Cal Poly's Disability Resource Center hosts anywhere from 25 to 100 exams a day. This number jumps to the hundreds during finals week. At the moment, each exam is manually assigned a seat.

The purpose of this program is to automatically generate a seating chart for a testing day at the Disability Resource Center. Given an excel file with a list of exam on a given day, the program should provide each student with a seat without any time conflicts. Once the user is satisfied, the user will be able to export the seating chart to an excel file.

## Table of Contents
  * [Application Usage](#application-usage)
  * [System Architecture](#system-architecture)
    + [Model](#model)
    + [View](#view)
    + [Controller](#controller)
  * [Demo](#demo)
  * [What I Liked Best](#what-i-liked-best)
  * [What I Learned](#what-i-learned)

## Application Usage
  1. Input the room information and click the import button to choose the excel file you wish process.
  2. Select the appropriate excel file.
  3. The program will automatically assign each exam a seat based on the given room information.
  4. Export the seating assignment to a new excel sheet.

## System Architecture

Model-View-Controller

### Model

- Student
- Exam
- Seat
- Room

![Alt text](Content/Model.png?raw=true "Class Diagram")

### View
- The GUI.

![Alt text](Content/View.png?raw=true "Class Diagram")

### Controller
- Room Controller
- File input/output
- Data Manager

![Alt text](Content/Controller.png?raw=true "Class Diagram")

## Design Patterns

### Singleton
- Keeps track of the data regarding students and exams.
- Allows access to students and exams in multiple classes.
- All changes in data is maintained between classes.

### State
- Easily switch between different JavaFX scenes.

## Demo

### Excel Sheet Before
![Alt text](Content/excel_before.png?raw=true "Excel Before")

### Adding Rooms and Selecting Excel File
<img src='http://i.imgur.com/tcXs6eA.gif' title='Scene 1' width='' alt='Scene 1' />

### Sorted Excel File and Filtering
<img src='http://i.imgur.com/IAb0A8f.gif' title='FilterGIF' width='' alt='FilterGIF' />

### Expanding a Table Section
![Alt text](Content/ExamDetails.png?raw=true "Exam Details")

### Finish Screen
![Alt text](Content/FinishScreen.png?raw=true "Finish")

### Excel Sheet After
![Alt text](Content/excel_after.png?raw=true "Excel After")

GIFs created with [LiceCap](http://www.cockos.com/licecap/).

## What I Liked Best.
- The use of the Singleton Pattern allowed me to access the data easily without having to pass them as arguments everytime I called a function that processes the data.
- I found many external libraries that had functions I wanted so I didn't have to rewrite the functions myself.
    - i.e Apache POI, ControlFX

## What I Learned.
- JavaFX
- The value of using meaningful variable names and design patterns to organize code.
- There are external libraries for everything.
