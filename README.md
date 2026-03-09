# 🦆 Duck Simulator – Design Pattern Project

## 📌 Project Overview

This project implements a **Duck Simulator** that demonstrates multiple **Object-Oriented Design Patterns** working together in a single system.

The simulator models different types of ducks that can quack, be grouped into flocks, monitored in real-time, and counted whenever they make a sound.

The main objective of this project is to show how **multiple design patterns can collaborate to build flexible, scalable, and maintainable software systems**.

This project is inspired by the design pattern examples from the book **Head First Design Patterns**.


# 🧠 Design Patterns Implemented

The project combines several design patterns together (a concept sometimes called a **Compound Pattern**) to solve a complex problem. These patterns work together to build a flexible simulation system. ([ajklili.github.io][1])

The following design patterns are used:

* Adapter Pattern
* Decorator Pattern
* Abstract Factory Pattern
* Composite Pattern
* Iterator Pattern
* Observer Pattern



# 1️⃣ Adapter Pattern

## Purpose

The **Adapter Pattern** allows objects with incompatible interfaces to work together.

## Problem

In the simulator, a **Goose** exists which makes a **honk()** sound instead of a **quack()** sound. However, the simulator only understands objects that implement the **Quackable** interface.

## Solution

A **GooseAdapter** class is created to adapt the Goose so that it behaves like a Duck.

## Implementation Idea


Goose -> honk()

GooseAdapter -> quack()
              -> calls goose.honk()


## Benefit

The goose can now be used anywhere a duck is expected without modifying the Goose class.



# 2️⃣ Decorator Pattern

## Purpose

The **Decorator Pattern** dynamically adds new behavior to objects without modifying their original code.

## Problem

The system needs to **count how many times ducks quack** for research purposes.

## Solution

A decorator class called **QuackCounter** wraps a duck object and increments a counter every time the duck quacks.

## Implementation Idea


Duck -> quack()

QuackCounter -> wraps Duck
              -> counts quacks
              -> calls original duck.quack()


## Benefit

New behavior is added without changing the original duck classes.



# 3️⃣ Abstract Factory Pattern

## Purpose

The **Abstract Factory Pattern** provides a way to create related objects without specifying their exact classes.

## Problem

The system needs to ensure that every duck created in the simulator is automatically wrapped with the **QuackCounter decorator**.

## Solution

A factory called **CountingDuckFactory** creates ducks and automatically decorates them with the quack counter.

## Example


CountingDuckFactory
   -> createMallardDuck()
   -> createRedheadDuck()
   -> createDuckCall()
   -> createRubberDuck()


## Benefit

Object creation is centralized and consistent across the system.



# 4️⃣ Composite Pattern

## Purpose

The **Composite Pattern** allows us to treat a group of objects the same way as individual objects.

## Problem

The simulator needs to manage **individual ducks and groups of ducks (flocks)**.

## Solution

A **Flock** class is created that implements the same interface as a single duck.

## Implementation Idea


Quackable
   ├── MallardDuck
   ├── RedheadDuck
   ├── RubberDuck
   └── Flock


The flock stores multiple ducks and calls `quack()` on each duck in the group.

## Benefit

A flock of ducks behaves exactly like a single duck.



# 5️⃣ Iterator Pattern

## Purpose

The **Iterator Pattern** provides a way to traverse a collection of objects sequentially.

## Implementation

The **Flock class** stores ducks inside an `ArrayList` and uses an **Iterator** to access each duck.

Example logic:


Iterator<Quackable> iterator = ducks.iterator();

while(iterator.hasNext()) {
    Quackable duck = iterator.next();
    duck.quack();
}


## Benefit

The internal structure of the flock is hidden while still allowing traversal of its elements.



# 6️⃣ Observer Pattern

## Purpose

The **Observer Pattern** enables objects to receive updates automatically when another object's state changes.

## Problem

Researchers want to **monitor ducks and receive notifications whenever a duck quacks**.

## Solution

Observers can register themselves with ducks to receive notifications.

### Components

Subject:

QuackObservable


Observer:

Observer
Quackologist


When a duck quacks, all registered observers are notified.

## Example Output

[12:30:10] Mallard Duck has quacked!


## Benefit

Provides **real-time monitoring of duck behavior** without tightly coupling the observer to the duck classes.


# 🏗 Project Structure

Duck Simulator
│
├── Quackable (interface)
├── Duck Classes
│   ├── MallardDuck
│   ├── RedheadDuck
│   ├── DuckCall
│   └── RubberDuck
│
├── Adapter
│   └── GooseAdapter
│
├── Decorator
│   └── QuackCounter
│
├── Factory
│   ├── AbstractDuckFactory
│   └── CountingDuckFactory
│
├── Composite
│   └── Flock
│
├── Observer
│   ├── Observer
│   ├── QuackObservable
│   └── Quackologist
│
└── DuckSimulator (Main Class)


# ▶️ How to Run the Project

1. Clone the repository

git clone https://github.com/fahimswe/Duck-Simulator-Design-Pattern-Project.git


2. Open the project in **IntelliJ IDEA / Eclipse / VS Code**

3. Run the main class


DuckSimulator.java




# 📊 Example Output


=================================================
          DUCK MONITORING SYSTEM
=================================================

🚀 Starting Simulation...

Mallard Duck: Quack
[12:30:10] ALERT: Mallard Duck has quacked!

Redhead Duck: Quack
[12:30:11] ALERT: Redhead Duck has quacked!

Rubber Duck: Squeak
[12:30:12] ALERT: Rubber Duck has quacked!

=================================================
TOTAL QUACKS RECORDED: 3
=================================================


# 🎯 Key Learning Outcomes

This project demonstrates:

* Object-Oriented Programming principles
* Separation of concerns
* Loose coupling
* Reusable software architecture
* Real-world use of multiple design patterns working together


# 📚 Reference

* **Head First Design Patterns** by Eric Freeman & Elisabeth Freeman


# 👨‍💻 Author

**Fahim Ahmed**
Software Engineering Student
Islamic University of Technology

GitHub:
https://github.com/fahimswe
