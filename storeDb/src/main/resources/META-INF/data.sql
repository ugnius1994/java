INSERT INTO clients (name, city, discount, post) VALUES('Google', 'Los Angeles', 25, 22);
INSERT INTO clients (name, city, discount, post) VALUES('Microsoft', 'Washington', 10, 44);
INSERT INTO clients (name, city, discount, post) VALUES('Uber', 'Los Angeles', 5, 44);
INSERT INTO clients (name, city, discount, post) VALUES('NetFlix', 'Los Angeles', 9, 0);

INSERT INTO products(name, price, description, image) VALUES('Windows 3.11', 10.99, 'bla ab ab bing', 'https://c1.staticflickr.com/3/2365/2185918681_38197eedd8_z.jpg?zz=1');
INSERT INTO products(name, price, description, image) VALUES('Windows XP', 20.99, 'cha cha smile', 'https://i.kym-cdn.com/photos/images/original/001/364/889/794.png');
INSERT INTO products(name, price, description, image) VALUES('Windows 10', 30.99, 'ogohoho', 'https://images.idgesg.net/images/article/2017/10/windows-10-logo-100739284-large.jpg');
INSERT INTO products(name, price, description, image) VALUES('Windows 8.1', 50, 'pure awesomness', 'https://www.hdwallpaper.nu/wp-content/uploads/2015/01/Windows-8.1-Wallpapers-5.jpg');
INSERT INTO products(name, price, description, image) VALUES('Windows Vista', 1, 'Lay me some eggs', 'http://46c4ts1tskv22sdav81j9c69-wpengine.netdna-ssl.com/wp-content/uploads/sites/2/2012/02/6874.5_5F00_01C91EBC.png' );
INSERT INTO products(name, price, description, image) VALUES('Windows 7.0', 48, 'fk it, it was good while it lasted', 'https://cdn1.itpro.co.uk/sites/itpro/files/styles/article_main_wide_image/public/images/dir_155/it_photo_77552.jpg?itok=EKDFYHXt');

INSERT INTO invoices(date, number, sum, client_id) VALUES('2018-09-10', 'INV 01', 1111, 1);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 1, 1111, 1000);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 4, 1144, 1001);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 2, 1122, 1002);

INSERT INTO invoices(date, number, sum, client_id) VALUES('2000-01-01', 'INV 02', 2222, 1);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 2, 2222, 2000);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 5, 2255, 2001);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(1, 3, 2233, 2002);

INSERT INTO invoices(date, number, sum, client_id) VALUES('2018-09-26', 'INV 03', 3333, 2);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 3, 3333, 3000);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 6, 3366, 3001);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 4, 3344, 3002);

INSERT INTO invoices(date, number, sum, client_id) VALUES('2018-09-26', 'INV 04', 4444, 2);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 3, 4433, 4000);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 1, 4411, 4001);
INSERT INTO inv_lines(invoice_id, product_id, price, quantity) VALUES(2, 5, 4455, 4002);