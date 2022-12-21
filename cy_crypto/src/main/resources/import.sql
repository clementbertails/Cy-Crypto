USE cycrypto;

INSERT INTO currency (id, name, symbol, icon_path) VALUES (0, 'Bitcoin', 'BTC', '/webapp/assets/currency_icon/BTC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (1, 'Etherum', 'ETH', '/webapp/assets/currency_icon/ETH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (2, 'Litecoin', 'LTC', '/webapp/assets/currency_icon/LTC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (3, 'Ripple', 'XRP', '/webapp/assets/currency_icon/XRP.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (4, 'Bitcoin Cash', 'BCH', '/webapp/assets/currency_icon/BCH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (7, 'Cardano', 'ADA', '/webapp/assets/currency_icon/ADA.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (9, 'Dash', 'DASH', '/webapp/assets/currency_icon/DASH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (14, 'Ethereum Classic', 'ETC', '/webapp/assets/currency_icon/ETC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (16, 'Tether', 'USDT', '/webapp/assets/currency_icon/USDT.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (18, 'OmiseGO', 'OMG', '/webapp/assets/currency_icon/OMG.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (19, 'Zcash', 'ZEC', '/webapp/assets/currency_icon/ZEC.png');

INSERT INTO user (id, name, last_name, username, email, password, role) VALUES (1, 'Clément', 'Bertails', 'espath', 'clement.bertails@gmail.com', '$2a$10$I1kFWTIBGSBmyklv9GBQgO8g0z1VaoRELRFBHcI0fhMSwkQmIpE5i', "ADMIN");
INSERT INTO user (id, name, last_name, username, email, password, role) VALUES (2, 'Test', 'Test', 'test', 'test@example.fr', '$2a$10$x1KkCHsN1W.gP8cUGVhqYuuFY5b/EEhpPRPWtJt8Mlign1QIv41ZS', "USER");