# _Band Tracker_

#### _Basic Java program focused on Advaced Databases, 5/13/2016_

#### By _**DJ Roychoudhury**_

## Description

_This is a basic Java based web application that is designed mainly for demonstration of understanding of advanced SQL database concepts. The main focus of this application is to utilize a "join-table" to link two classes with eachother to allow interaction between data from the database. This application will allow a user to create venue objects that will contain a title for the venue and its address. Users can also create band objects that will contain a name and description for the band. The bands and venues are linked through a join table in the database. Users can see what bands have played at a certain venue or what venues a band has played in. _

## Setup/Installation Requirements

* Clone this repository to your desktop, or desired directory.
* In the command line, enter: `$ postgres`, or install and run the postgress application here :http://postgresapp.com/.
* Open another terminal window or tab once postgres is running and run psql with the following: `$ psql`.
* In psql, create the following database: `CREATE DATABASE band_tracker;`
* Either quit psql with `\q` or open another terminal window or tab and enter the following: `$ psql band_tracker < band_tracker.sql`.
* 
* Open your terminal/command line and navigate to the directory that the clone was saved in(desktop or what ever directory you chose).
* Once you are in the parent direntory (should be WordPuzzle), enter `$ gradle run`.
* Once gradle runs from the terminal/command line, open a new tab/window in your desired web browser.
* Enter the following in address bar: localhost:4567



## Support and contact details

_Please report and issues or bugs in the Epicodus forums (http://forum.epicodus.com/top/all) or send me an email._

## Technologies Used

_Java, Velocity, Spark, JUnit, Bootstrap, CSS, Google Fonts, Gradle_

### License

* MIT License

Copyright (c) [2016] [DJ Roychoudhury]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.*
