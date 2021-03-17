INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, DOB) VALUES
('Christopher', 'Tolkien', 'christophertolkien@gmail.com', '1924-11-21'),
('Lynley', 'Dodd', 'lynleydodd@gmail.com', '1941-07-05'),
('Fotis', 'Floros', 'fotf91@gmail.com', '1991-07-19');


INSERT INTO PUBLISHER (NAME, TELEPHONE, ADDRESS) VALUES
('Houghton Mifflin', '2101234500', 'Antistratou 15'),
('Slinky Malinki', '2101234501', 'Ermou 52'),
('Patakis', '2101234502', 'Akadimias 65');
  
INSERT INTO BOOK (ISBN, TITLE,DESCRIPTION, VISIBLE, CREATION_DATE, AUTHOR_ID, PUBLISHER_ID) VALUES
('0618260307', 'The Hobbit', 'The Hobbit description', true, '1937-09-21', '1', '1'),
('9780261103', 'The War of the Jewels', 'The War of the Jewels description', true, '1945-07-08', '1', '1'),
('0395710418', 'The Lost Road and Other Writings', 'The Lost Road and Other Writings description', true, '1997-01-07', '1', '1'),
('0908606664', 'Slinky Malinki', 'Slinky Malinki description', true, '1990-05-10', '2', '2'),
('1908606206', 'Hairy Maclary from Donaldsons Dairy', 'Hairy Maclary from Donaldsons Dairy description', true, '1983-06-02', '2', '2'),
('0000000006', 'What a wonderful life', 'Not yet published book description', false, '2021-03-13', '3', '3');