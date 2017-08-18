-- pass - admin
INSERT INTO users VALUES (1, 'admin', '$2a$11$UxhGJ1ofAGqAXEEoIkoKNOwLvdu7no.MIcIz.yyGoXR1TaPFb.HKS');

INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_USER');

INSERT INTO user_roles VALUES (1, 1);

INSERT INTO developers VALUES (1, 'James', 'Carter', 'java', 1, 300);
INSERT INTO developers VALUES (2, 'Helen', 'Leary', 'java', 2, 500);
INSERT INTO developers VALUES (3, 'Linda', 'Douglas', 'java', 3, 800);
INSERT INTO developers VALUES (4, 'Rafael', 'Ortega', 'java', 5, 1000);
INSERT INTO developers VALUES (5, 'Henry', 'Stevens', 'js', 1, 300);
INSERT INTO developers VALUES (6, 'Sharon', 'Jenkins', 'js', 3, 700);

