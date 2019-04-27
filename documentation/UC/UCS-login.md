# Use-Case Specification: Login

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

# 1. Analyze Acceleration Behavior

A registered user can login to his account with his email adress and password.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow

![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-login.jpg "Activity Diagram"

![alt text][MockUp2]

[MockUp2]: https://github.com/linkna/FyF/blob/master/documentation/UC/Login%20Mockup%202.png

![alt text][MockUp1]

[MockUp1]: https://github.com/linkna/FyF/blob/master/documentation/UC/Login%20Mockup%201.png


## 2.2 Alternative Flows
# 3. Special Requirements
## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen
The app must be running and opened on the screen. 

## 4.3 The profile is already created
To login into an account, the profile has to exist.

# 5. Postconditions

## 5.1 Managing success
Map is shown. User can view and edit his profile.

## 5.2 Managing failure

Display a notification, saying that and why (if possible) the login failed.

# 6. Function Points
Value: 13

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/login%20fp.JPG
