[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Vlc0gOo_)
# Homework: Library Borrowing System (Java Overloading)

## Overview

In this assignment, you will build a simple **Library Borrowing System** using Java.

Libraries allow users to borrow books in different ways:

* Borrow a single book
* Borrow multiple books
* Borrow books with an extended borrowing period

To support these cases, you will implement **method overloading**.

You will also implement **constructor overloading** to configure the library system.

This project focuses on practicing:

* Constructor Overloading
* Method Overloading
* Abstract Classes
* Inheritance
* Basic Object-Oriented Design

---

# Project Structure

Your project should follow this structure:

```
src/
 └── com/
     └── library/
         ├── model/
         │    ├── LibraryItem.java
         │    ├── Book.java
         │    └── Magazine.java
         │
         ├── service/
         │    └── BorrowService.java
         │
         └── App.java
```

---

# Part 1 — Abstract Class

Create an abstract class called:

```
LibraryItem
```

## Attributes

```
title
author
borrowFee
```

## Constructor

```
LibraryItem(String title, String author, double borrowFee)
```

## Methods

```
String getTitle()
double getBorrowFee()
abstract String getItemType()
```

---

# Part 2 — Item Implementations

You must implement two classes that extend `LibraryItem`.

---

## Book

Default borrow fee:

```
2.0
```

Example:

```
Book book = new Book("Clean Code", "Robert Martin");
```

Method:

```
getItemType()
```

Returns:

```
Book
```

---

## Magazine

Default borrow fee:

```
1.5
```

Example:

```
Magazine magazine = new Magazine("Tech Monthly", "Editorial Team");
```

Method:

```
getItemType()
```

Returns:

```
Magazine
```

---

# Part 3 — BorrowService (Method Overloading)

Create a class called:

```
BorrowService
```

This class handles borrowing operations.

You must implement **method overloading**.

---

# Method 1 — Borrow One Item

```
double borrow(LibraryItem item)
```

Description:

Returns the borrowing cost of one item.

Example:

```
borrow(book)
```

Result:

```
2.0
```

---

# Method 2 — Borrow With Extra Days

```
double borrow(LibraryItem item, int extraDays)
```

Rule:

Each extra day adds:

```
0.5
```

Formula:

```
totalFee = borrowFee + (extraDays × 0.5)
```

Example:

```
borrow(book, 4)
```

Result:

```
2.0 + (4 × 0.5) = 4.0
```

---

# Method 3 — Borrow Multiple Items

```
double borrow(LibraryItem[] items)
```

Description:

Borrow multiple items at once.

Formula:

```
totalFee = sum of all borrowFee
```

Example:

```
items = [book, magazine]
```

Result:

```
2.0 + 1.5 = 3.5
```

---

# Method 4 — Borrow Multiple Items With Extra Days

```
double borrow(LibraryItem[] items, int extraDays)
```

Formula:

```
totalFee = sum of all borrowFee + (extraDays × 0.5 × numberOfItems)
```

Example:

```
borrow(items, 3)
```

Calculation:

```
(2.0 + 1.5) + (3 × 0.5 × 2)
```

---

# Part 4 — Constructor Overloading

Inside `BorrowService`, implement **constructor overloading**.

The library system should support **different membership discounts**.

---

## Constructor 1

```
BorrowService()
```

Default discount:

```
0%
```

---

## Constructor 2

```
BorrowService(double memberDiscount)
```

Example:

```
BorrowService service = new BorrowService(0.1);
```

Meaning:

```
10% discount
```

---

# Discount Rule

Final fee must apply discount:

```
finalFee = totalFee - (totalFee × memberDiscount)
```

---

# Part 5 — Main Program

A class called:

```
App
```

Example usage:

```
Book book = new Book("Clean Code", "Robert Martin");
Magazine magazine = new Magazine("Tech Monthly", "Editorial Team");

BorrowService service = new BorrowService();

System.out.println(service.borrow(book));
System.out.println(service.borrow(book, 3));

LibraryItem[] items = {book, magazine};

System.out.println(service.borrow(items));
System.out.println(service.borrow(items, 2));
```

Your program should print the calculated borrowing fees.


## Happy Coding!