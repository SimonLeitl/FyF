# Use-Case Specification: manage products

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

A registered farmer can add information about offered products to his account. Therefore he can select product categories.

## 1.2 Screenshots


# 2. Flow of Events
## 2.1 Basic Flow
### 2.1.1 Activity Diagram

![alt text][ActivityDiagram]

[ActivityDiagram]: https://github.com/linkna/FyF/blob/master/documentation/UC/activity%20Diagrams-manage%20products.jpg "Activity Diagram"

### 2.1.1 Mock-Up
![alt text][MockUp]

[MockUp]: https://github.com/linkna/FyF/blob/master/documentation/UC/Manage%20products%20MockUp%20.png




## 2.2 Alternative Flows
n.a.
# 3. Special Requirements
## 3.1 Device connection 
The device has to be connected to the internet.
## 3.2 Screen size support 
Since the app can be used on every android phone, there will be many different screen sizes. The layout should not waste space on big screens and should still be readable on small screens.

# 4. Preconditions
## 4.1 App opened on screen

To manage products the app must be running and opened on the screen. 

## 4.2 The farmer is logged in

To manage products, the farmer has to be logged in. 

## 4.3 The farmshop is already created
To manage products, a farmshop has to exist and the farmer has to be the owner.

# 5. Postconditions

## 5.1 Managing success
Products can be shown in the farmshop overview. 

## 5.2 Managing failure

Display a notification, saying that and why (if possible) the managing failed.

# 6. Function Points
Value: 38

![alt text][fp]

[fp]: https://github.com/linkna/FyF/blob/master/documentation/UC/manage%20products%20fp.JPG
