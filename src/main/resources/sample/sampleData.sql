insert into Spender (id, name) values (100, 'Jim');
insert into Spender (id, name) values (200, 'Kate');
insert into Spender (id, name) values (300, 'Common');

insert into ExpenseItem (id, category_id, spender_id, amount, creationDate, description)
values (100, 100, 100, 3.50, to_date('2015/06/23', 'YYYY/MM/DD'), 'Hot-dog');
insert into ExpenseItem (id, category_id, spender_id, amount, creationDate, description) 
values (101, 200, 100, 23.00, to_date('2015/07/11', 'YYYY/MM/DD'), 'Leisure');
insert into ExpenseItem (id, category_id, spender_id, amount, creationDate, description) 
values (102, 300, 300, 40.22, SYSDATE, 'T-Shirt');