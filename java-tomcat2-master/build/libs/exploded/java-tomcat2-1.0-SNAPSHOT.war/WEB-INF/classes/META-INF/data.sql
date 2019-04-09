insert into products (name, price, description, image) values ('Windows_10', 50.98,  'pirmas', 'https://image.flaticon.com/icons/svg/183/183324.svg');
insert into products (name, price, description, image) values ('Office_10',  30.98,  'antras', 'https://image.flaticon.com/icons/svg/148/148963.svg');
insert into products (name, price, description, image) values ('Excel_3',   110.98, 'trečias', 'https://image.flaticon.com/icons/svg/1/1396.svg');
insert into products (name, price, description, image) values ('Excel_4',   100.98, 'ketvirtas', 'https://image.flaticon.com/icons/svg/265/265707.svg');
insert into products (name, price, description, image) values ('Excel_5',   90.98, 'penktas', 'http://www.qweas.com/reviews/images2/excel.jpg');
insert into products (name, price, description, image) values ('Excel_6',   90.98, 'sestas', 'https://image.flaticon.com/icons/svg/183/183330.svg');
insert into products (name, price, description, image) values ('Excel_7',   90.98, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/1/1395.svg');
insert into products (name, price, description, image) values ('Excel_8',   90.98, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183326.svg');
insert into products (name, price, description, image) values ('Excel_9',   90.98, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183327.svg');
insert into products (name, price, description, image) values ('Excel_10',   0.10, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183328.svg');
insert into products (name, price, description, image) values ('Excel_11',   0.11, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183329.svg');
insert into products (name, price, description, image) values ('Excel_12',   0.12, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183331.svg');
insert into products (name, price, description, image) values ('Excel_13',   0.13, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183332.svg');
insert into products (name, price, description, image) values ('Excel_14',   0.14, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183333.svg');
insert into products (name, price, description, image) values ('Excel_15',   0.15, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183334.svg');
insert into products (name, price, description, image) values ('Excel_16',   0.16, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183335.svg');
insert into products (name, price, description, image) values ('Excel_17',   0.17, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183336.svg');
insert into products (name, price, description, image) values ('Excel_18',   0.18, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183337.svg');
insert into products (name, price, description, image) values ('Excel_19',   0.19, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/183/183338.svg');
insert into products (name, price, description, image) values ('Excel_20',   0.20, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/1/1397.svg');
insert into products (name, price, description, image) values ('Excel_21',   0.21, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/1/1398.svg');
insert into products (name, price, description, image) values ('Excel_22',   0.22, 'tekstas labai ilgas', 'https://image.flaticon.com/icons/svg/1/1399.svg');

insert into clients (name, city, post, discount) values ('Topo Centras', 'Kaunas' , 'LT 5121', 10);
insert into clients (name, city, post, discount) values ('Elektromarkt', 'Vilnius', 'LT 6254', 50);
insert into clients (name, city, post, discount) values ('Iki'         , 'Kaunas' , 'LT 2101', 50);

insert into invoices (date, number, sum, client_id) values ('2019-03-01', 'A1', 15.98, 1);
insert into inv_lines (price, qty, invoice_id, product_id) values (100.05, 2, 1, 1);
insert into inv_lines (price, qty, invoice_id, product_id) values (300.98, 2, 1, 3);

insert into invoices (date, number, sum, client_id) values ('2019-03-02', 'A2', 15.98, 2);
insert into inv_lines (price, qty, invoice_id, product_id) values (200.98, 1, 2, 2);

insert into invoices (date, number, sum, client_id) values ('2019-03-02', 'A3', 15.98, 1);
insert into inv_lines (price, qty, invoice_id, product_id) values (200.98, 1, 3, 1);
insert into inv_lines (price, qty, invoice_id, product_id) values (200.98, 1, 3, 2);
insert into inv_lines (price, qty, invoice_id, product_id) values (200.98, 1, 3, 3);

insert into users (username, secret, role) values ('admin@gmail.com', '$2a$10$GovzvMHKM2X7aSUGQN/8TuG6gcKm9pxltuUWJajjX2ZYpxXCNNfaa', 'admin');
insert into users (username, secret, role) values ('user@gmail.com', '$2a$10$m3JdnsfXBaEMPS4DCFF30eX3IMKcQsslLanRZTjLRURu2lVM.aVU.', 'user');

insert into cart_lines (user_id, product_id, qty) values (2, 1, 1);
insert into cart_lines (user_id, product_id, qty) values (2, 1, 1);
insert into cart_lines (user_id, product_id, qty) values (2, 1, 1);


