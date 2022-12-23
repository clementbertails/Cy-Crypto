# Cy-Crypto

Cy-Crypto is a cryptocurrency tracker.

It allows to have access via a user account, to information (updated every minute) on the selected crypto-currency as well as its history over 30 days.

## Technologies

This project uses the following technologies:
Java 17

Maven 3.8.6

Docker :
- Docker 20.10.20
- Docker-compose 3.9

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
* Do not forget to modify Cy-Crypto/cy_crypto/src/main/resources/application.yaml to fit your database.

## Database

* This project embeds a mariadb docker.
* You can also replace it with a Mysql database but don't forget to modify Cy-Crypto/cy_crypto/src/main/resources/application.yaml to fit your database.
* If you choose to replace the database, you have to compile the project manually and you can't use the docker.

