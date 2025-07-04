# E-Commerce System - Fawry Quantum Internship Challenge

## Overview

This is a simple console-based e-commerce system implemented in **Java**, built to simulate essential features of an online shopping platform. It was developed as a solution to the **Fawry Quantum Internship Challenge**.

---

# Features

# Product Management

* Products have:

  * `name`, `price`, and `quantity`.
* Some products may **expire** (e.g., Cheese, Biscuits).
* Some products require **shipping** (e.g., Cheese, TV), with specified `weight`.

# Interfaces Implemented

* `Expirable`: implemented by products that can expire (has `isExpired()` method).
* `Shippable`: implemented by products that require shipping (has `getName()` and `getWeight()` methods).

# Cart Operations

* Customers can:

  * Add products to the cart with a specified quantity (not exceeding stock).
  * Attempt to checkout the cart.
* Validation during checkout:

  * Cart must not be empty.
  * No expired products.
  * Customer must have sufficient balance.

# Checkout Process

* Prints a formatted **Shipment Notice**:

  * Lists all shippable items with their quantities and weights.
  * Displays total package weight.
* Prints a **Checkout Receipt**:

  * Lists each item and its total price.
  * Displays subtotal, shipping fee, and total amount paid.
  * Shows remaining customer balance.

# Shipping Service

* A `ShippingService` interface accepts a list of `Shippable` items.
* Calculates total weight and provides item names.
* `ShippingServiceImpl` implements logic for shipment notice formatting.

---

## Example Output

```
** Shipment notice **
2x Cheese           400g
1x Biscuits         700g
Total package weight 1.1kg

** Checkout receipt **
2x Cheese           200
1x Biscuits         150
------------------------------
Subtotal            350
Shipping            30
Amount              380
Remaining Balance   620
```

---

## Technologies Used

* Java SE
* Object-Oriented Programming (OOP)

---

## Folder Structure

```
شcom.fawryChallenge
│
├── model
│   ├── product         # Product, ExpirableProduct, ShippableProduct, etc.
│   ├── cart            # Cart and CartItem
│   └── customer        # Customer class
│
├── service
│   ├── checkout        # CheckoutService, CheckoutServiceImpl
│   └── shipping        # ShippingService, ShippingServiceImpl
│
└── Main.java           # Entry point for testing the system
```

---

## How to Run

1. Compile all classes using any Java IDE or CLI.
2. Run `Main.java` to simulate product creation, cart addition, and checkout.

---

# Notes

* Designed to be extensible for future features like payment gateways or discounts.
* Developed under the assumption of single-customer session.

---

# Author

Mostafa Eid Hassan Fawry Internship Challenge)
