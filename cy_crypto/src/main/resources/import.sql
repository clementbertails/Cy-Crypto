INSERT INTO currency (id, name, code, symbol) 
VALUES (0, 'Bitcoin', 'BTC', '/webapp/assets/currency_icon/BTC.png'),
       (1, 'Etherum', 'ETH', '/webapp/assets/currency_icon/ETH.png'),
       (2, 'Litecoin', 'LTC', '/webapp/assets/currency_icon/LTC.png'),
       (3, 'Ripple', 'XRP', '/webapp/assets/currency_icon/XRP.png'),
       (4, 'Bitcoin Cash', 'BCH', '/webapp/assets/currency_icon/BCH.png'),
       (5, 'EOS', 'EOS', '/webapp/assets/currency_icon/EOS.png'),
       (6, 'Stellar', 'XLM', '/webapp/assets/currency_icon/XLM.png'),
       (7, 'Cardano', 'ADA', '/webapp/assets/currency_icon/ADA.png'),
       (8, 'IOTA', 'MIOTA', '/webapp/assets/currency_icon/MIOTA.png'),
       (9, 'Dash', 'DASH', '/webapp/assets/currency_icon/DASH.png'),
       (10, 'NEM', 'XEM', '/webapp/assets/currency_icon/XEM.png'),
       (11, 'Monero', 'XMR', '/webapp/assets/currency_icon/XMR.png'),
       (12, 'TRON', 'TRX', '/webapp/assets/currency_icon/TRX.png'),
       (13, 'NEO', 'NEO', '/webapp/assets/currency_icon/NEO.png'),
       (14, 'Ethereum Classic', 'ETC', '/webapp/assets/currency_icon/ETC.png'),
       (15, 'VeChain', 'VEN', '/webapp/assets/currency_icon/VEN.png'),
       (16, 'Tether', 'USDT', '/webapp/assets/currency_icon/USDT.png'),
       (17, 'Bitcoin Gold', 'BTG', '/webapp/assets/currency_icon/BTG.png'),
       (18, 'OmiseGO', 'OMG', '/webapp/assets/currency_icon/OMG.png'),
       (19, 'Zcash', 'ZEC', '/webapp/assets/currency_icon/ZEC.png'),
       (20, 'Qtum', 'QTUM', '/webapp/assets/currency_icon/QTUM.png'),
       (21, 'Lisk', 'LSK', '/webapp/assets/currency_icon/LSK.png'),
       (22, 'Binance Coin', 'BNB', '/webapp/assets/currency_icon/BNB.png');

INSERT INTO user (id, name, last_name, username, password, email, role)
VALUES (0, 'Clément', 'Bertails', 'espath', '$2a$10$I1kFWTIBGSBmyklv9GBQgO8g0z1VaoRELRFBHcI0fhMSwkQmIpE5i', 'clement.bertails@gmail.com', 1),
       (1, 'Test', 'Test', 'test', '$2a$10$x1KkCHsN1W.gP8cUGVhqYuuFY5b/EEhpPRPWtJt8Mlign1QIv41ZS', 'test@example.fr', 0);