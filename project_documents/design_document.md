# [BloomTech Shopping Complex] Design Document

## Instructions

*Save a copy of this template for your team in the same folder that contains
this template.*

*Replace italicized text (including this text!) with details of the design you
are proposing for your team project. (Your replacement text shouldn't be in
italics)*

*You should take a look at the example design document in the same folder as
this template for more guidance on the types of information to capture, and the
level of detail to aim for.*

## BloomTech Shopping Complex Design

## 1. Problem Statement
BloomTech Shopping Complex is a one-stop shop online shopping mall. We provide online access 
to all the top stores all in one place, our goal is to make online shopping as convenient 
and simple as possible, eliminating the burden of having to travel to a physical location.

This design document will provide clarification on how the shopping platform will work 
including the functionality on how our customers will interact with the site to satisfy 
our customers' needs. 



## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. What stores are we going to include in the shopping complex? 
2.   
3.  

## 3. Use Cases

*This is where we work backwards from the customer and define what our customers
would like to do (and why). You may also include use cases for yourselves, or
for the organization providing the product to customers.*

U1. As a customer, I want to create an account.

U2. As a customer, I want to update customer account info.

U3. As a customer, I want to see the total order cost.

U4. As a customer, I want to browse different categories.

U5. As a customer, I want to check order status.

U6. As a customer, I want to see product details (price, website links).

U7. As a customer, I want to organize stores in alphabetical order.

U8. As a customer, I want to add a store/product to my favorites.

U9. As a customer, I want to delete a store from my favorites.

U10. As a customer, I want to see which stores are open or closed. 

U11. As a customer, I want to be able to place an order. 

U12. As a customer, I want to see an order history for my account.

U13. As a customer, I want to see if an item is in stock.

## 4. Project Scope

### 4.1. In Scope

- create an account
- update account info
- browse different categories
- see product details
- organize stores by alphabetical order or popularity
- add a store/product to favorites
- delete a store/product from favorites
- see which stores are open or closed
- see if item is in stock

### 4.2. Out of Scope
- see order total
- check order status
- place order
- see order history


# 5. Proposed Architecture Overview

This initial iteration will provide customers with a way to create an account, 
so that they can save stores/products to a favorites list, browse the available stores, 
browse the items available from those stores, sort the list of stores with different filters
(alphabetically, by popularity, etc.).

We will use API Gateway and Lambda functions to create our endpoints ('CreateAccount', 
'UpdateAccount', 'GetAccountInfo', 'GetStores', 'GetFavorites', 'AddToFavorites', 
'DeleteFavorites') that will handle the creation and updating of customer accounts, 
including adding to and deleting from customer's favorites list as well as returning a list
of available stores that can be filtered by each customer's preferred method. 

We will store a list of customer accounts and the available stores in DynamoDB tables. For 
simpler retrieval, we will store the favorites list for each customer directly in the 
accounts table. 

BloomTech Shopping Complex will also provide a web interface for users to create their accounts, 
see information about available stores, and update their favorites lists. A main page will 
provide a list of stores with links showing the store information as well as a linked page 
to show their favorites list and add or delete stores.

# 6. API

## 6.1. Public Models

```
// AccountModel

String userId;
String name;
String email;
List<String> favorites;

// StoreModel

String storeId;
String name;
List<String> items;
integer popularity;
List<String> category;


```

## 6.2. Create Account Endpoint 

* Accepts `POST` requests to `/accounts`
* Accepts data to create a new account with a provided userId, name, and email. Returns the new account.
* We will validate the provided userId for the new account does not contain any invalid characters: `" ' \`
  * If the userId contains any of the invalid characters, will throw `InvalidCharacterException`.

## 6.3 Update Account Endpoint

* Accepts `PUT` requests to `/accounts/:userId`
* Accepts data to update an account including the user ID, and an updated name or email. Returns updated account.
  * If user ID is not found, will throw a `UserNotFoundException`.

## 6.4 Get Account Info Endpoint

* Accepts `GET` requests to `accounts/:userId`
* Accepts a user ID and returns corresponding AccountModel.
  * If user ID is not found, will throw a `UserNotFoundException`

# 7. Tables

## 7.1. 'accounts'
```
userId // partition key, string
favorites // list
name // string
email // string
```

## 7.2. 'stores'
```
storeId // partition key, string
name // string
items // list 
category / list
popularity / int
```

## 7.3. 'items'
```
itemId // parition key, string
storeName // sort key, string
name // string
quantity // int
```

# 8. Pages

*Include mock-ups of the web pages you expect to build. These can be as
sophisticated as mockups/wireframes using drawing software, or as simple as
hand-drawn pictures that represent the key customer-facing components of the
pages. It should be clear what the interactions will be on the page, especially
where customers enter and submit data. You may want to accompany the mockups
with some description of behaviors of the page (e.g. “When customer submits the
submit-dog-photo button, the customer is sent to the doggie detail page”)*
