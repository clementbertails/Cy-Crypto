use cycrypto;

insert into user (id, name, last_name, username, password, email, role)
values (0, "Clément", "Bertails", "espath", "$2a$10$I1kFWTIBGSBmyklv9GBQgO8g0z1VaoRELRFBHcI0fhMSwkQmIpE5i", "clement.bertails@gmail.com", 1),
       (1, "Clément", "Bertails", "clement", "$2a$10$x1KkCHsN1W.gP8cUGVhqYuuFY5b/EEhpPRPWtJt8Mlign1QIv41ZS", "test@example.fr", 0);