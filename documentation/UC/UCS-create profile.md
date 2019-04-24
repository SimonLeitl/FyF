# Use-Case Specification: Create profile

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

The user can choose between different profile types. He can register as a farmer or as a customer.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow

![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-create%20profile.jpg "Activity Diagram"



![alt text][MockUp1]

[MockUp1]: https://github.com/linkna/FyF/blob/master/documentation/UC/Create%20Profile%20Mockup.png


## 2.2 Alternative Flows
# 3. Special Requirements

## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen
To manage products the app must be running and opened on the screen. 

# 5. Postconditions
## 5.1 Registered as farmer
User is logged in and can view his profile. He can create farmshops.
## 5.2 Registered as customer
User is logged in and can view his profile. He can save farmshops as favorites.
## 5.3 Registration failure
Display a notification, saying that and why (if possible) the registration failed.

# 6. Function Points
Value: 22

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/create%20profile%20fp.JPG
