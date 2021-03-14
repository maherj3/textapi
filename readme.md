### Project spec 


Please write in Java an API to read the contents of a plain text file and enable the display of the total number of words, the average word length, the most frequently occurring word length and a list of the number of words of each length.

Submit your code along with unit tests and maven POM file, along with instructions for its installation and use along with any assumptions you have made about what defines a word (using as a basis the rules that can be deduced from the example below).

For example given a file that contains the following text:

	Hello world & good morning. The date is 18/05/2016

We would expect the following output:

Word count = 9
Average word length = 4.556
Number of words of length 1 is 1
Number of words of length 2 is 1
Number of words of length 3 is 1
Number of words of length 4 is 2
Number of words of length 5 is 2
Number of words of length 7 is 1
Number of words of length 10 is 1
The most frequently occurring word length is 2, for word lengths of 4 & 5

Note that we will test code submissions on a number of files of various lengths ranging from the above example through to the large books such as the Bible (http://janelwashere.com/files/bible_daily.txt).

##Approach

#####Front end

I have created a no thrills front end. I have used Thymeleaf template engine in order to output the needed data. 
A simple form with a text box input has been used in order for the user to put any url of a txt file to be processed.

#####Testing

I have used junit testing in order to test the output of the given url within the spec.

#####Architecture

I have an MVC architecture. I have abstraction from service using an interface to protect my code. As not much was needed of this application I have 1 model, 1 controller and 1 service.
with more functionality this would grow.

#####Data Storage

I have tried to keep this as simple as possible just using in memory H2 data storage, if this was an actual project I would 
probably use some better storage like postgres.

#####The code

I have tried to keep the code as simple at as readable as possible. I believe from functions are quite light-weight, as I have used a lot of
library functions rather than spending a lot of time trying to create my own.

I have tried to use an array of different methods to suit the task each function is tackling.

I tried to think of worst case scenarios especially with the frequency output, as there could be multiple frequently
occurring lengths. 

This is the first time I have used maven I tend to use gradle.

I have commented lots of the code in order to make it easier to understand.


