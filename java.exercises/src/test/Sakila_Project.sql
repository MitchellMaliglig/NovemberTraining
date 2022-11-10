-- 1. Get 10 cities in descending alphabetical order.
(SELECT * FROM City ORDER BY City.city LIMIT 10) ORDER BY city DESC;

-- 2. Get all films with "airplane" in the title.
SELECT * FROM Film WHERE Film.title LIKE '%airplane%';

-- 3. Get the highest payment amount.
SELECT MAX(Payment.amount) AS MaxPayment FROM Payment;

-- 4. Get the number of records in the customer table for store id #1.
SELECT COUNT(Customer.customer_id) FROM Customer WHERE Customer.store_id = 1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"
SELECT * FROM Customer WHERE Customer.email LIKE 'NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.
SELECT actor_info.film_info FROM actor_info WHERE first_name = 'Bob' AND last_name = 'Fawcett';

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
SET @filmID = (SELECT Film.film_id FROM Film Where Film.title = 'Alien Center');
CALL film_in_stock(@filmID, 2 ,@count);

-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! 
--    Pay attention to constraints and the order that you are inserting data.)

--    *Had trouble solving it the proper way, and solving it in general
START TRANSACTION;

INSERT INTO Address (address_id)
VALUES (1000);

INSERT INTO Staff (staff_id, address_id)
VALUES (2000, 1000);

INSERT INTO Store (store_id, manager_staff_id, address_id)
VALUES (3000, 2000, 1000);

COMMIT;

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 
UPDATE Store
SET last_update = CURRENT_TIMESTAMP
WHERE store_id = 3000 AND manager_staff_id = 2000 AND address_id = 1000;

-- 10. Delete the new store. 
DELETE FROM Store
WHERE store_id = 3000;

-- 11. Using one SQL statement, get how many films are there in each rating category.
SELECT Film.rating, COUNT(*) AS Amount FROM Film GROUP BY Film.rating;

-- 12. Get (in order) the first and last names of the 3 customers who have spent the most, along with how much they have paid overall.
(SELECT SUM(Payment.amount), Customer.first_name, Customer.last_name FROM Payment, Customer 
WHERE Payment.customer_id = Customer.customer_id GROUP BY Customer.customer_id 
ORDER BY SUM(Payment.amount) DESC LIMIT 3) ORDER BY first_name;

-- 13. Get all movies rented by the customer who spent the most. (Hint: This will either require 
--     nested queries, or more than two joins. one approach is much shorter than the other.)
SELECT Film.title FROM Film WHERE Film.film_id IN
(SELECT DISTINCT Inventory.film_id FROM Inventory WHERE Inventory.inventory_id IN
(SELECT DISTINCT Rental.inventory_id FROM Rental, Customer WHERE Customer.customer_id = 
(SELECT Customer.customer_id FROM Payment, Customer 
WHERE Payment.customer_id = Customer.customer_id GROUP BY Customer.customer_id 
ORDER BY SUM(Payment.amount) DESC LIMIT 1)));

-- 14. Get the first and last names of all customers who spent more than $150, along with how much they spent.
SELECT SUM(Payment.amount) AS Amount, Customer.first_name, Customer.last_name FROM 
(Payment INNER JOIN Customer ON Payment.customer_id = Customer.customer_id)
GROUP BY Customer.customer_id HAVING SUM(Payment.amount) > 150;
