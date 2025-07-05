# Ecommerce with Java
# 🛒 Java E-commerce System

A modular, object-oriented Java console application that simulates a basic e-commerce workflow.  
It supports cart management, product expiration, shipping logic, and customer checkout with complete validation and exception handling.

---

## 📦 Features

- ✅ Define general products with `name`, `price`, and `availableQuantity`
- 📆 Support for **expirable products** (e.g., Cheese, Biscuits)
- 🚚 Support for **shippable products** (e.g., TV, Cheese) with `weight` info
- 🛒 Customers can add products to a cart with quantity checks
- ⚠️ Throws exceptions for:
  - Out-of-stock items
  - Expired items
  - Empty cart
  - Insufficient customer balance
- 💳 Checkout process:
  - Calculates subtotal, shipping, and total amount
  - Deducts from customer's balance
  - Displays receipt and shipping notice

---

## 🧰 Technologies Used

- Java 17+
- OOP design principles
- Custom exceptions
- No external libraries (pure Java)

---

## Examples and usecases
  - All products are available, None are expired, The customer has enough balance, Cart is not empty, Including shippable and non-shippable products.
    ![image](https://github.com/user-attachments/assets/64324540-8aeb-4aa3-94ed-d9a3f6e89ba6)
    ![image](https://github.com/user-attachments/assets/d2888392-cbb5-4520-ac1d-e7428fb64c4a)
 - All products are available, None are expired, The customer has enough balance, Cart is not empty, non-shippable products are there.
   ![image](https://github.com/user-attachments/assets/8489e314-9387-4107-be35-89d045a39110)
   ![image](https://github.com/user-attachments/assets/e2a8736a-3a4a-4f11-88c7-2c9f0ab069c4)
- Insufficient Customer balance (balance is 50, products total is 67.60).
  ![image](https://github.com/user-attachments/assets/2c50f20f-d680-49d6-9949-10e7836297d6)
  ![image](https://github.com/user-attachments/assets/e17167de-a292-4e87-921d-2c2673bab078)
- Insufficent product quantity (6 Mobile scratch card are required to be added but 5 only available).
  ![image](https://github.com/user-attachments/assets/6aab84a0-265f-4f81-89f0-1fc009afd684)
  ![image](https://github.com/user-attachments/assets/293c2cd4-4fe3-4968-a078-fe9b68008b1c)
- Empty cart.
  ![image](https://github.com/user-attachments/assets/6325e772-2554-4c47-b126-6e6938fc6156)
  ![image](https://github.com/user-attachments/assets/94b3463c-94e4-4569-89aa-c9c383a396bf)
- Expired products(biscuits)
 ![image](https://github.com/user-attachments/assets/4197dd60-e592-4c9a-b2d9-184a508c9ff9)
 ![image](https://github.com/user-attachments/assets/f02deb91-8be6-4d13-917d-2b0655b0848c)







   



