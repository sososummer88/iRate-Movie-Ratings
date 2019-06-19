# iRate-Movie-Ratings
## Project Overview
This is the capstone project for Database Management System course in Northeastern University - Silicon Valley Campus. The iRate project is a portion of an application that enables registered movie theater customers to rate a movie that they saw at the theater, and for other registered customers to vote for reviews.


This project is made by [Xun Wang](https://xw321.github.io/), [Yan Zhao](https://yzhao430.github.io/), and [Fang Hong](https://sososummer88.github.io/).

## Technology
During the development, we utilized following technologies:
* Java
* Derby

## Features of of The Project
* iRate is a social media application that encourages theater customers to rate a movie that they saw at the theater in the past week and write a short review.
* Other customers can vote one review of a particular movie as "helpful" each day.
* The writer of the top rated review of a movie written three days earlier receives a free movie ticket, and voting is closed for all reviews of the movie written three days ago. 
* Someone who voted one or more movie reviews as "helpful" on a given day will be chosen to receive a free concession item. 

## Project Details
This project is to develop and document a data model for representing entities and relationships in this promotial social media application, provide DDL for creating the tables, DML for editing entries in the tables, and DQL for making commonly used queries to retrieve information about the status of reviews and votes from the database. 
### 1. Entities
* Movie
* Customer
* Review

* Movie table contains two attributes:
1) movie_title: title of the movie as varchar and not null;
2) movie_id (primary key): self-generated identity of the movie as int (start with 1, increment by 1);

* Customer table contains five attributes:
1) customer_id (primary key): self-generated id of customer as int (start with 1, increment by 1);
2) customer_Name: name of customers as varchar and not null;
3) email: customer's email as varchar and not null;
4) address: customer's address as varchar and not null;
5) join_date: date customer registered as date and not null;

* Review table contains six attributes
1) review_id (primary key): self-generated id of review as int (start with 1, increment by 1);
2) customer_id: a foreign key references customer_id in the Customer table. If a customer is deleted, all of his/her reviews and endorsement are deleted;
3) movie_id: a foreign key references movie_id in the Movie table. If a movie is deleted, all of its reviews are also deleted;
4) review_date: date the review is created as date and not null;
5) rating (check between 0 and 5): rating of the movie that is given by customer as int and not null;
6) review (text): review that is writen by customer as varchar and not nulll;


### 2. Relationship
* Attendance
* Endorsement

* Attendance table contains three attributes:
1)
2)
3)

* Endorsement table contains three attributes:
1)
2)

(Insert graphes)

## Reference to the Class with Link:
For more information about the class, please go to this page:
http://www.ccis.northeastern.edu/home/pgust/classes/cs5200/2019/Summer1/index.html
