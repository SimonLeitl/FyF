# Use-Case Specification: Evaluate

# Table of Contents
- [Analyze Acceleration Behavior](#1-analyze-acceleration-behavior)
    - [Brief Description](#11-brief-description)
    - [Screenshots](#12-screenshots)
- [Flow of Events](#2-flow-of-events)
    - [Basic Flow](#21-basic-flow)
    - [Alternative Flows](#22-alternative-flows)
- [Special Requirements](#3-special-requirements)
- [Preconditions](#4-preconditions)
- [Postconditions](#5-postconditions)
- [Function Points](#6-function-points)

# 1. Analyze Acceleration Behavior

A registered user who spent time at an farm shop or bought something there can evaluate this shop.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow
## 2.1.1 Activity Diagram

![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-evaluate.jpg "Activity Diagram"

## 2.1.2 Mock-Up
![alt text][MockUp2]

[MockUp2]: https://github.com/linkna/FyF/blob/master/documentation/UC/Evaluate%20Mockup.jpg


## 2.2 Alternative Flows
# 3. Special Requirements
## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen

The app must be running and opened on the screen. 

## 4.2 The user is logged in as customer

To evaluate farmshops, the user has to be logged in as a customer. 

## 4.3 The farmshop information view is opened
To evaluate a farmshop, the shop information has to be opened on the screen.

# 5. Postconditions

## 5.1 Managing success
The average evaluation value is updated in the farmshop information view. 

## 5.2 Managing failure

Display a notification, saying that and why (if possible) the evaluation failed.

# 6. Function Points
Value: 

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/evaluate%20fp.JPG
