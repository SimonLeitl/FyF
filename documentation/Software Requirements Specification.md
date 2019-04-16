# Find your Farm - Software Requirements Specification


## 1 Introduction


### 1.1 Purpose

This document describes a detailed description of the "Find your Farm" project. 
It will explain the purpose and features of the android app.

### 1.2 Scope

This document defines the requirements for the android app. Other components such as a web app are not in the scope of this document. 
Furthermore, it servers as an internal reference to be used during development of the application.

### 1.3 Definitions, Acronyms and Abbreviations

n/a: not applicable  
tbd: to be done


### 1.4 References


* [Blog](https://findyourfarm.wordpress.com/)


### 1.5 Overview

The following chapters are about our vision and perspective, the software requirements, the demands we have and the technical realization of this project.

## 2 Overall Description

![use case diagram](https://github.com/linkna/FyF/blob/master/documentation/OverallUseCaseDiagram-Page-1.jpg)

Find your Farm will be an Andriod app which focuses on the connection between farmers and customers who love to buy and eat healthy food and the knowledge where it comes from. So we try to make it easy to find the farmer in your area. We'll use a map where you can find your favorite farm and check the latest offers from vegetables to meet or eggs. Also you find important informations about the farm like open times or something. Another possibility is that you can direktly write an e-mail to your farm to get informations and you can rate the service and the quality of the food.

## 3 Specific Requirements

### 3.1 Functionality

#### 3.1.1 [User registration](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-create%20profile.md)

The user has the possibility to choose between two different account types. 
Either he registers as a farmer or as a customer. But the app can also be used as a guest.

#### 3.1.2 Farmer profile
An as farm shop registered user can access his user profile. There, he is able to update his provided personal data and password, and also to delete his account. 
##### 3.1.2.1 [Create farm shop](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-create%20farm%20shop.md)
A user with a farmer profile can register new farm shops and manage the business data.

#### 3.1.3 Customer profile
An as customer registered user can access his user profile. There, he is able to update his provided personal data and password, and also to delete his account.
#### 3.1.3.1 [Save favorite farmshop](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-save%20favorite%20farmshop.md)
Customers can save a selected farm shop in a list of his favorites.
#### 3.1.3.2 [Show favorite farmshops](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-show%20favorite%20farmshops.md)
Shows a list with the saved favorite farmshops.
#### 3.1.3.3 [Evaluate](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-evaluate.md)
Customers can evaluate farmshops.

#### 3.1.4 [Login](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-login.md)
For authentification the email address and password are used.

#### 3.1.5 Logout
Invalidates the active user session.

#### 3.1.6 Search a farm shop
There are three different ways to find farm shops.

##### 3.1.6.1 [Search by location](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-search%20by%20location.md)
With the location search you get the location of the device. The map shows your location and the shops nearby.
##### 3.1.6.2 [Search by product](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-search%20by%20product.md)
With searching for a special product category you will find surrounding shops that offer the special product category.
##### 3.1.6.3 Search by ranking
With searching by ranking you will find the surrounding shops sorted according to their rating.

#### 3.1.7 Show results
The user can choose the type of presentation of the results.
##### 3.1.7.1 Show results as list
The farmshops are shown as list.
##### 3.1.7.2 Show results as map
The farmshops are shown on the map.

#### 3.1.8 [Get farmer profile](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-get%20farmer%20profile.md)

#### 3.1.9 [Manage products](https://github.com/linkna/FyF/blob/master/documentation/UC/UCS-manage%20products.md)
A registered farmer can add information about offered products to his account. Therefore he can select product categories.

### 3.2 Usability
tbd


### 3.3 Reliability
tbd


### 3.4 Performance
tbd


### 3.5 Supportability
tbd


### 3.6 Design Constraints
tbd

### 3.7 Online User Documentation and Help System Requirements
tbd


### 3.8 Purchased Components
tbd

### 3.9 Interfaces
tbd


### 3.10 Licensing Requirements

Google Licence to use the map template, the API and the database.

### 3.11 Legal, Copyright and Other Notices
tbd


### 3.12 Applicable Standards

n.a.

## Supporting Information

n.a.



