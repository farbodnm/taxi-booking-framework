# Taxi Booking Framework

Simple software architectures project to design a taxi booking framework.

# Table of Contents

* [Team Members](#team-members)
* [Description](#description)
  * [Prioritised Feature List](#prioritised-feature-list)
  * [Framework Architecture](#framework-architecture)
    * [Framework Services](#framework-services)
  * [Component Diagram](#component-diagram)
  * [Class Diagram](#class-diagram)

# Team Members

- Farbod Nazari Montazer
- Mahshad Salimi
- Amin Hassan Zarei
- Taha Khani Almoti

# Description

The prerequisites to designing the framework as requested by the projects are defined as follows.

## Prioritised Feature List

A defined ranked list of features required for a basic taxi reservation system with a description.

<center>

| Priority |                 Feature                 |                                                                                                            Description                                                                                                             |
| :------: | :-------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|    1     |  User Registration and Authentication   |                                                                   User registration (passengers and drivers) <br> Login authentication (passengers and drivers)                                                                    |
|    2     |           Profile Management            |                                                 User profile creation and editing (passengers and drivers) <br> Driver document verification (e.g., license, vehicle registration)                                                 |
|    3     |           Booking Management            |                          Taxi availability search <br> Taxi selection based on criteria (e.g., location, type) <br> Pickup and drop-off location selection <br> Confirmation and cancellation of bookings                          |
|    4     |            Taxi Dispatching             |                                                         Assigning nearest available taxi to passenger <br> Real-time tracking of taxi location <br> Dispatching algorithm                                                          |
|    5     |            Driver Management            | Driver registration and onboarding <br> Availability status management <br> Booking assignment to drivers <br> Real-time location tracking of driversReal-time location tracking of drivers <br> Navigation assistance for drivers |
|    6     |            Fleet Management             |                Vehicle registration and management <br> Real-time tracking of vehicle locations <br> Vehicle availability status management <br> Vehicle maintenance scheduling <br> Optimizing vehicle utilization                |
|    7     |       Feedback and Rating System        |                                                                  Passenger rating of drivers <br> Driver rating of passengers <br> Feedback submission for rides                                                                   |
|    8     |             Admin Dashboard             |                                  System configuration management <br> Handling user complaints/disputes <br> Managing driver accounts <br> Generating reports and analytics <br> Feedback review                                   |
|    9     |           Payment Processing            |                        Multiple payment method support (debit cards, cash) <br> Fare calculation based on distance, time, and additional charges <br> Invoice generation <br> Refunds and dispute handling                         |
|    10    |         Notification Management         |              Booking confirmation notifications <br> Driver assignment notifications <br> Estimated arrival time notifications <br> Ride completion notifications <br> Payment confirmation notifications to drivers               |
|    11    |         Analytics and Reporting         |                                      System performance analytics <br> User behavior analytics <br> Booking trend analysis <br> Driver productivity analysis <br> Revenue generation reports                                       |
|    12    |        Promotions and Discounts         |                                                  Generating and applying promotion codes <br> Offering discounts for specific users or rides <br> Managing promotional campaigns                                                   |
|    13    | Localization and Multi-language Support |                                                                    Supporting multiple languages for users <br> Localization of content based on user location                                                                     |
|    14    |         Accessibility Features          |                                                                       Support for visually impaired users <br> User interface adjustments for accessibility                                                                        |
|    15    |    Regulatory Compliance Enforcement    |                                                                             Compliance with local transportation regulations <br> Fine for bad actors                                                                              |
|    16    |   Integration with External Services    |                                                Integration with mapping services (e.g., Google Maps) <br> Integration with bank payment gateways <br> Integration with sms services                                                |

</center>

## Framework Architecture

The framework is designed using a service oriented architecture with each service using a layered architecture, with a focus on scalability and adaptability.

<p align="center">
  <img width="1000" src="images/Project-Architecture.png" alt="Project Architecture">
</p>

### Framework Services:

#### User Management Service

> Handles user registration, authentication, and profile management for both passengers and drivers.

#### Booking Service

> Manages the entire booking process, including searching for available taxis, selecting pickup and drop-off locations, confirming bookings, and handling cancellations.

#### Driver Management Service

> Manages driver registration, authentication, and profile management, as well as driver availability and assignment to bookings.

#### Fleet Management Service

> Handles registration and management of vehicles, tracking vehicle locations, and optimizing vehicle utilization based on demand.

#### Dispatching Service

> Assigns available taxis to incoming booking requests based on factors like proximity, driver availability, and real-time traffic conditions.

#### Payment Service

> Manages payment processing for completed rides, including fare calculation, payment method integration, invoice generation, and handling refunds or disputes.

#### Admin Service

> Provides administrators with a centralized interface for managing system configurations, monitoring key metrics, handling user complaints, and performing administrative tasks.

## Component Diagram

TODO

## Class Diagram

TODO
