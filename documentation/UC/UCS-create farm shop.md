# Use-Case Specification: create farm shop

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
- [Function Points](#5-function-points)

# 1. Analyze Acceleration Behavior
## 1.1 Brief Description

An user who wishes to register a farm shop can do so via the profile data setting function. A new farm shop is created and the associated data such as opening hours, address or telephone number are saved via a form.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow
## 2.1.1 Activity Diagram
![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-create%20farm%20shop.jpg "Activity Diagram"

## 2.1.2 Mock-Up

![alt text][MockUp1]

[MockUp1]: https://github.com/linkna/FyF/blob/master/documentation/UC/Create%20Farmshop1.png "MockUp1"

![alt text][MockUp2]

[MockUp2]: https://github.com/linkna/FyF/blob/master/documentation/UC/Create%20Farmshop%202.png "MockUp2"

![alt text][MockUp3]

[MockUp3]: https://github.com/linkna/FyF/blob/master/documentation/UC/Create%20Farmshop3.png "MockUp3"

## 2.2 Alternative Flows
# 3. Special Requirements
## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen

To create a farmshop the app must be running and opened on the screen. 

## 4.2 The farmer is logged in

To create a farmshop the farmer has to be logged in. 


# 5. Postconditions

## 5.1 Creating success
Farmshop is listed in the farmers profile overview. The farmshop is shown on the map and can be found by the search function.

## 5.2 Creating failure

Display a notification, saying that and why (if possible) the creating failed.

# 6. Function Points
Value: 60

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/create%farm%20shop%20fp.JPG
