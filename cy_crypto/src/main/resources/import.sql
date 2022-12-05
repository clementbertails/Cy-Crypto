USE cycrypto;

INSERT INTO currency (id, name, symbol, icon_path) VALUES (0, 'Bitcoin', 'BTC', '/webapp/assets/currency_icon/BTC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (1, 'Etherum', 'ETH', '/webapp/assets/currency_icon/ETH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (2, 'Litecoin', 'LTC', '/webapp/assets/currency_icon/LTC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (3, 'Ripple', 'XRP', '/webapp/assets/currency_icon/XRP.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (4, 'Bitcoin Cash', 'BCH', '/webapp/assets/currency_icon/BCH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (5, 'EOS', 'EOS', '/webapp/assets/currency_icon/EOS.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (6, 'Stellar', 'XLM', '/webapp/assets/currency_icon/XLM.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (7, 'Cardano', 'ADA', '/webapp/assets/currency_icon/ADA.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (8, 'IOTA', 'MIOTA', '/webapp/assets/currency_icon/MIOTA.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (9, 'Dash', 'DASH', '/webapp/assets/currency_icon/DASH.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (10, 'NEM', 'XEM', '/webapp/assets/currency_icon/XEM.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (11, 'Monero', 'XMR', '/webapp/assets/currency_icon/XMR.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (12, 'TRON', 'TRX', '/webapp/assets/currency_icon/TRX.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (13, 'NEO', 'NEO', '/webapp/assets/currency_icon/NEO.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (14, 'Ethereum Classic', 'ETC', '/webapp/assets/currency_icon/ETC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (15, 'VeChain', 'VEN', '/webapp/assets/currency_icon/VEN.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (16, 'Tether', 'USDT', '/webapp/assets/currency_icon/USDT.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (17, 'Bitcoin Gold', 'BTG', '/webapp/assets/currency_icon/BTG.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (18, 'OmiseGO', 'OMG', '/webapp/assets/currency_icon/OMG.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (19, 'Zcash', 'ZEC', '/webapp/assets/currency_icon/ZEC.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (20, 'Qtum', 'QTUM', '/webapp/assets/currency_icon/QTUM.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (21, 'Lisk', 'LSK', '/webapp/assets/currency_icon/LSK.png');
INSERT INTO currency (id, name, symbol, icon_path) VALUES (22, 'Binance Coin', 'BNB', '/webapp/assets/currency_icon/BNB.png');

INSERT INTO user (id, name, last_name, username, email, password, role) VALUES (1, 'Clément', 'Bertails', 'espath', 'clement.bertails@gmail.com', '$2a$10$I1kFWTIBGSBmyklv9GBQgO8g0z1VaoRELRFBHcI0fhMSwkQmIpE5i', 1);
INSERT INTO user (id, name, last_name, username, email, password, role) VALUES (2, 'Test', 'Test', 'test', 'test@example.fr', '$2a$10$x1KkCHsN1W.gP8cUGVhqYuuFY5b/EEhpPRPWtJt8Mlign1QIv41ZS', 0);