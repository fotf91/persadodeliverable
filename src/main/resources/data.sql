INSERT INTO AUTHOR (FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, DOB) VALUES
('Christopher', 'Tolkien', 'christophertolkien@gmail.com', '1924-11-21'),
('Lynley', 'Dodd', 'lynleydodd@gmail.com', '1941-07-05'),
('Fotis', 'Floros', 'fotf91@gmail.com', '1991-07-19'),
('Frank', 'Herbert', 'frankherbert@gmail.com', '1986-02-11');


INSERT INTO PUBLISHER (NAME, TELEPHONE, ADDRESS) VALUES
('Houghton Mifflin', '2101234500', 'Antistratou 15'),
('Penguin Books', '2101234501', 'Allen Lane 8'),
('Patakis', '2101234502', 'Akadimias 65'),
('Anubis', '2101234503', 'Gravias 10');


INSERT INTO BOOK (ISBN, TITLE,DESCRIPTION, VISIBLE, CREATION_DATE, AUTHOR_ID, PUBLISHER_ID) VALUES
('978-3-16-148410-0', 'The Hobbit', 'The Hobbit description.', true, '1937-09-21', '1', '1'),
('978-0-26-110334-0', 'The War of the Jewels', 'The War of the Jewels description.', true, '1945-07-08', '1', '1'),
('039-5-71-041838-0', 'The Lost Road and Other Writings', 'The Lost Road and Other Writings description.', true, '1997-01-07', '1', '1'),
('090-8-60-666487-1', 'Slinky Malinki', 'Slinky Malinki description.', true, '1990-05-10', '2', '2'),
('190-8-60-620615-7', 'Hairy Maclary from Donaldsons Dairy', 'Hairy Maclary from Donaldsons Dairy description.', true, '1983-06-02', '2', '2'),
('000-0-00-000511-0', 'Story of my life', 'This is the story of my life.', true, '2010-09-20', '3', '3'),
('000-0-00-000652-6', 'What a wonderful life', 'Not yet published book description.', false, '2020-03-05', '3', '3'),
('000-0-00-000782-7', 'Power of now', 'Not yet published book description. Still looking for Publisher', false, '2021-04-13', '3', null),
('478-0-60-005171-0', 'Dune', 'Dune is a 1965 science-fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine. It tied with Roger Zelazny This Immortal for the Hugo Award in 1966, and it won the inaugural Nebula Award.', true, '1990-02-10', '4', '1'),
('978-9-60-306372-0', 'Dune', 'Dune is a 1965 science-fiction novel by American author Frank Herbert, originally published as two separate serials in Analog magazine. It tied with Roger Zelazny This Immortal for the Hugo Award in 1966, and it won the inaugural Nebula Award.', true, '2008-02-10', '4', '4');
