# Use-Case Specification: Get farmer profile

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

A registered user or an unregistered user can view a farmer profile by clicking on the farmshop owner. The profile view contains several information, e.g all different farmshops owned by the selected farmer.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow
## 2.1.1 Activity Diagram
![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-get%20farmer%20profile.jpg "Activity Diagram"
## 2.1.2 Mock-up
![alt text][MockUp]

[MockUp]: https://github.com/linkna/FyF/blob/master/documentation/UC/Get%20farmer%20profile%20Mockup.jpg

## 2.2 Alternative Flows
# 3. Special Requirements
## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen
The app must be running and opened on the screen. 

## 4.2 A farmshop view is opened
To view a farmer profile the user has to click on the farmshop owner in the farmshop overview. 


# 5. Postconditions

## 5.1 forwarding success
The farmer profile is displayed. 

## 5.2 forwarding failure

Display a notification, saying that and why (if possible) the forwarding failed.

# 6. Function Points
Value: 

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/get%20farmer%20profile%20fp.JPG
