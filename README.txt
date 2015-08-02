Current implementation.
-----------------------
The library system has been developed to enable the recording and monitoring of resources that are
loaned to subscribers of the library service. There are two types of subscribers to the library,
pensioners and students each having different borrowing limits. There are also two types of resources 
that may be borrowed: books and games, both have different loan periods and games require a surcharge to
be paid.

A user interface has not yet been developed as it is thought the object oriented design of the library 
system should be improved.

The LibrarySimulator class gives examples of access into the system and contains a small system test.


Exercise
--------
Improve the current implementation of the library system introducing: inheritance, interfaces, 
custom exceptions and types where appropriate.

Implement a new output service “FileOutputService” that writes to a file. Introduce this into 
the system running along side the existing “ConsoleOutputService”.

Add more test scenarios to the system.

Consider how this system would be implemented using EJBs. What considerations should be made for 
deploying such a system across multiple tiers?
