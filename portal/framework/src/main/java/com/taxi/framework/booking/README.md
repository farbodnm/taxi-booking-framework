# Framework's Booking service

This service is supposed to Handle bookings made by users, manage assignments, states of the user, and assigned driver's location.

# Table of Contents

* [Provided Classes](#classes-provided-in-the-framework)
* [Controller Endpoints](#controller-endpoints)

# Classes provided by the framework

The provided baseline DTOs are supposed to be expanded upon. As such the provided logic and controllers are written using generics.

<p align="center">
  <img width="1000" src="../../../../../../../../../images/Booking-Service.png" alt="Project Architecture">
</p>

# Controller endpoints

<center>

| HTTP Verb |    Exposed Endpoint    |                                      Job                                       |
|:---------:|:----------------------:|:------------------------------------------------------------------------------:|
|   POST    |         /book          | Start a booking and sends a request to dispatch to start the finding process.  |  
|     -     | Service Communications |                Assigns the driver found by dispatch to a user.                 |
|    GET    |   /refresh/{userID}    | Returns the current state of the driver assignment and their location to user. |
|   PATCH   |  /nextstate/{userID}   |                Goes to the next state of user's travel states.                 |

</center>


