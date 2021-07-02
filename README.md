# Donut Priority Queue

Jim works in the production facility of a premium online donut retailer. He is responsible for
bringing donuts to the pickup counter once they’re done. But the manager is not satisfied
because either it takes too long before a delivery arrives, or only a few items arrive. Jim’s
manager wants to fix this and asks Jim to write a web service that accepts the orders and
provides a list of items to deliver to the pickup counter. Desperate Jim remembers his friend
who is working in a software company as a software engineer ... and your phone rings. Can
you help Jim?


## Endpunkte:

Welche Endpunkte gibt es und wie werden diese angeprochen?

### GET

"/ordersAll": 
- get all orders in the queue

"/ordersPrio":
- get all priority orders in the queue

"/ordersNormal":
- get all normal orders in the queue

"/nextPickup":
- get the orders for the next pickup
- pickup contains not more than 50 dounuts

"/getWait?clientID=":
- param: int clientID
- get the waittime for the order with client number "clientID"

"/deleteOrder?clientID=":
- param: int clientID
- delete order with client number "clientID"

### POST

"/order?clientID=,number=":
- param: int clientID, int number
- create order 

### DELETE

"/order?clientID=":
- delete order with clientID "clientID"
