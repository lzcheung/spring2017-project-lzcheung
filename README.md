# Auto-Seat Generator
[![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung)

## Table of Contents
 * [Introduction](#introduction)
  * [Application Usage](#application-usage)
  * [System Architecture](#system-architecture)
    + [Model](#model)
    + [View](#view)
    + [Controller](#controller)
  * [Class Diagram](#class-diagram)
  * [Demo](#demo)

## Introduction

Everyday, Cal Poly's Disability Resource Center hosts anywhere from 25 to 100 exams a day. This number jumps to the hundreds during finals week. At the moment, each exam is manually assigned a seat.

The purpose of this program is to automatically generate a seating chart for a testing day at the Disability Resource Center. Given an excel file with a list of exam on a given day, the program should provide each student with a seat without any time conflicts. Once the user is satisfied, the user will be able to export the seating chart to an excel file.

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

### View
- The GUI.

### Controller
- Room Controller
- File input/output

## Class Diagram
![Alt text](Content/ClassDiagram.png?raw=true "Class Diagram")

## Demo
### Excel Sheet Before
![Alt text](Content/excel_before.png?raw=true "Class Diagram")

### Adding Rooms and Selecting Excel File
<img src='http://i.imgur.com/tcXs6eA.gif' title='Scene 1' width='' alt='Scene 1' />

GIFs created with [LiceCap](http://www.cockos.com/licecap/).

### Excel Sheet After
![Alt text](Content/excel_after.png?raw=true "Class Diagram")
