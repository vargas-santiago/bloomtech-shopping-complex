# BloomTech Shopping Complex Design Document

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

## 6.5 Add To Favorites Endpoint

* Accepts `POST` request to `accounts/:userId/store`
* Accepts a user ID and a store to be added. The store is specified by the storeId
 * If the user is not found, will throw a `UserNotFoundException`
 * If the storeId doesn't exist, throw `StoreNotFoundException`
* By default, will insert the new store to the end of the store list

## 6.6 DeleteFavorites EndPoint

* Accepts `DELETE` request to `accounts/:userId/store`
* Accepts a user ID and a store to be deleted from the list. The store is specified by the storeId
  * If the user is not found, will throw `UserNotFoundException`
  * If the storeId doesn't exist, throw `StoreNotFoundException`


## 6.7 Get Store Info Endpoint

* Accepts `GET` requests to `stores/storeId`
* Accepts a store ID and returns corresponding StoreModel.
  * If store ID is not found, will throw `StoreNotFoundException`

## 6.8 Update Store Info Endpoint

* Accepts `PUT` requests to `stores/storeId`
* Accepts data needed to update the store like a storeId, name, list of items in store, category and popularity.
  * If store ID is not found, will throw `StoreNotFoundException`

[//]: # (## 6.7 Delete Store Endpoint NOTE: THIS ONE MIGHT NOT BE IMPLEMENTED)

[//]: # ()
[//]: # (* Accepts `POST` requests to `stores/storeId`)

[//]: # (* Accepts a store ID and returns nothing. )

[//]: # (  * If store ID is not found, will throw `StoreNotFoundException`)

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
storeId // sort key, string
name // string
quantity // int
```

# 8. Pages

![Every page has a BloomTech Shopping Complex header and logout button. The 
first page is a basic login page with username and password fields and "login" 
and "sign up" buttons. Clicking the sign up button takes you to the sign up page.
The sign up page says "Sign Up" with fields to enter a username, password, name, 
and email. There is a "cancel" button to return to the login page and a "sign up" 
button to create a new user account.](images/design_document/signup.png)

![The account details page says "Your Account" and displays the userId, name and 
email of the logged in account. Clicking the view button next to "Favorites:" 
takes you to the "Favorites" page. Clicking the "Edit Account" button takes you to the 
"Edit Account" page. Clicking the "View Stores" button takes you to the "Stores" 
page.](images/design_document/accountdetails.png)

![The edit account page says "Edit Account". It displays the username of the logged
in account. There are input fields for the user to enter the updated information. There
is a "Cancel" button to return to the account details page without making any changes. 
Clicking the "Delete Account" button deletes the account completely and returns to the 
login/sign up page. Clicking the edit button updates the name and email fields of the
logged in account.](images/design_document/editaccount.png)

![The favorites page says "Favorites". It displays a list of the user's favorite stores
with radio buttons by each store name. Selecting a radio button and then clicking "View
Store" loads that specific stores item's page or clicking "Delete from Favorites" removes it 
from the user's favorites list. There are also navi buttons at the bottom, "Account" and "Stores",
which take you to the account details page or the stores page, 
respectively.](images/design_document/favorites.png)

![The stores page says "Stores". It has a card for each store that includes the store logo, 
the store name, and the store categories. Each card also has a "Visit Store" button that 
navigates to the store's item's page and a heart icon that adds that store to the user's
favorites list and shows the store's popularity count (+1 for every user that favorites 
the store). Above the cards is a dropdown box of filters, with options to sort the store cards
alphabetically, by popularity or by category. "Account" to go to the account details page 
and "Favorites" to go to the favorites page navi buttons are at the bottom
as well as what page in the list of stores is showing out of how many total pages there are, with
clickable arrows to view either the next or previous page.](images/design_document/stores.png)

![The store's item's page shows the store logo as well as the clickable heart logo 
that adds the store to the user's favorite list and counter. A green or red dot beside 
the logo indicates whether the store is open or closed. There is a list of items the store is 
currently offering for sale. "Account" button navigates to the account details page, 
"Favorites" button navigates to the favorites page and the "Stores" button navigates
to the stores page.](images/design_document/storepage.png)
