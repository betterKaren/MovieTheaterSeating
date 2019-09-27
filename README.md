# MovieTheaterSeating Manual

### Assumptions
* This program assumes that user only input one request file once, and each request file only contains one request with the format Request ID and number of seats. E.g. `R0001 2`. But if user runs the program multiple times, it can be accumulative (the previous assigned seats will not be assigned again) unless admin initialize.
* The way to initialize is by running `Seat.java`. This program will generate a file called `file.txt`, which contains all available seats.
* One more assumption is that user value their seats. For instance, the seats in the middle of this ceater should be allocated to customers with earlier requests. Therefore, in `file.txt`, remaining available seats are categorized. Seats in the middle will be stored in the first line, and seats on the boarder area of the cinema will be stored in later lines.
* One concern to be further optimized is that customers might be allocated into separated seats (like `E16` and `E5`).


### Files to store
Please store customers' reservation requests in folder `Requests` and name them as `xxx.txt` (for example `R0001.txt`, but the name doesn't need to be a request id). 


### Execution Instructions
* Compile
``` Java
javac Seat.java
javac seatAssign.java
```
* Initialize 
Note: Only run this part if you want to start from the very beginning. It will set the available seats back to original.
``` Java
java Seat
```
* Assign seats with entering request file path
``` Java
java seatAssign Requests/R0001.txt
```
* Check `Assignments` for seat assignment!
