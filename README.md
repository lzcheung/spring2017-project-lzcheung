# Auto-Seat Generator [![Build Status](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung.svg?branch=master)](https://travis-ci.org/cpe305Spring17/spring2017-project-lzcheung)

## Introduction

Everyday, Cal Poly's Disability Resource Center hosts anywhere from 25 to 100 exams a day. This number jumps to the hundreds during finals week. At the moment, each exam is manually assigned a seat.

The purpose of this program is to automatically generate a seating chart for a testing day at the Disability Resource Center. Given an excel file with a list of exam on a given day, the program should provide each student with a seat without any time conflicts. Once the user is satisfied, the user will be able to export the seating chart to an excel file.

## Getting Started
First clone this repository.
```bash
$ git clone https://github.com/cpe305Spring17/spring2017-project-lzcheung.git
```

Then build the project with:
```bash
$ mvn clean install
```

And finally run the project with:
```bash
TODO
```

## Application Usage
  1. Input the room information and click the import button to choose the excel file you wish process.
  2. Select the appropriate excel file.
  3. The program will automatically assign each exam a seat based on the given room information.
  4. Export the seating assignment to a new excel sheet.

More information can be found on [Github Pages](https://cpe305spring17.github.io/spring2017-project-lzcheung/).