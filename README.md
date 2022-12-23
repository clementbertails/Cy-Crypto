# Cy-Crypto

Cy-Crypto is a cryptocurrency tracker.

It allows to have access via a user account, to information (updated every minute) on the selected crypto-currency as well as its history over 30 days.

## Technologies

This project uses the following technologies :

Java 17

Maven 3.8.6

Docker :
- Docker 20.10.20
- Docker-compose 3.9

MariaDB 10.10.1

Adminer 4.8.1

## Launch the project

1. Clone repository : 
```bash
git clone https://github.com/clementbertails/Cy-Crypto.git
```
2. Move to the root of the project :
```bash
cd Cy-Crypto
```
3. Run the docker :
```bash
docker-compose up -d
```

Alternative :
* You can find the .jar at the root of the project.

Do not forget to modify Cy-Crypto/cy_crypto/src/main/resources/application.yaml to fit your database.

## Database

* This project embeds a mariadb docker which you can manage from the adminer (localhost:2580).
    * server : mariadb
    * user : cytech
    * password : cytechpassword
    * database : cycrypto
* You can also replace it with a Mysql database but don't forget to modify Cy-Crypto/cy_crypto/src/main/resources/application.yaml to fit your database.

If you choose to replace the database, you have to compile the project manually and you can't use the docker.

## Use the website :

1. With Docker

Host: localhost
Port used: 2480

2. With a text editor

Do not forget to modify Cy-Crypto/cy_crypto/src/main/resources/application.yaml to fit your database.

Host: localhost
Port used: 8080

3. Login

Create your own user or use one of the following :

User:
* Last name: Test
* First name : Test
* Username: test
* Email: test@example.fr
* Password : Test1234!!

Administrator:
* Last Name: admin
* First name: admin
* Username: admin
* Email: admin@example.fr
* Password : Test1234!!
