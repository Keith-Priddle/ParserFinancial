INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 1 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'USD', '2020-01-01', FALSE, 2 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 2','GB32ESSE40486562136016', 0.00, 'EUR', '2020-01-01', TRUE, 3 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 3','GB32ESSE40486562136016', 0.00, 'HUF', '2020-01-01', TRUE, 1 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'SEK', '2020-01-01', TRUE, 3 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 2','GB32ESSE40486562136016', 0.00, 'KRW', '2020-01-01', TRUE, 1 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 4','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 1 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 3','GB32ESSE40486562136016', 0.00, 'IDR', '2020-01-01', TRUE, 2 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 4 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 5 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 6 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 7 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 5 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 5 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 3 );
INSERT INTO ACCOUNT (TYPE, IBAN, BALANCE, CURRENCY, OPENDATE, ACTIVE, HOLDERID)
VALUES ('TYPE 1','GB32ESSE40486562136016', 0.00, 'GBP', '2020-01-01', TRUE, 4 );

INSERT INTO TRANSFER (TRANSID,SOURCE, DESTINATION, AMOUNT, DESCRIPTION, TIMESTAMP)
VALUES (1,1,2,10000.00,'THIS IS A TEST TRANSFER DESCRIPTION','2020-01-01 00:00:00');

INSERT INTO ACCOUNTHOLDER (HOLDERID, EMAIL, FIRSTNAME, LASTNAME, TITLE, BIRTHDATE )
VALUES (1,'keith@moderneventsttech.com','Keith', 'Priddle', 'Mr', '1966-01-06' );
