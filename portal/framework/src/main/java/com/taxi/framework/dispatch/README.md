# Framework's Booking service

This service handles finding users and the drivers close to them, updates itself by getting each drivers updated location from the fleet service. This service also manages assigning a driver to a user.

# Table of Contents

* [Provided Classes](#classes-provided-in-the-framework)
* [Controller Endpoints](#controller-endpoints)

# Classes provided by the framework

The provided baseline DTOs are supposed to be expanded upon. As such the provided logic and controllers are written using generics.

<p align="center">
  <img width="1000" src="../../../../../../../../../images/Dispatch-Service.png" alt="Project Architecture">
</p>

# Controller endpoints

<center>

| HTTP Verb |    Exposed Endpoint     |                                  Job                                  |
|:---------:|:-----------------------:|:---------------------------------------------------------------------:|
|     -     | Service Communications  | When a new driver looks for users, return nearby users to the driver. |  
|     -     | Service Communications  | When a new user looks for a driver, sends the user to nearby drivers. |
|     -     | Service Communications  |     When a driver accepts a user assigns the driver to the user.      |

</center>


