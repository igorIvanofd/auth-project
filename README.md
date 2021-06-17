# auth-project
Project based on SpringBoot and React for signin and singup\
Deploy on environment with docker-compose

# Deploy on environment
Source code for deploy u can find on this link https://github.com/igorIvanofd/auth-project/blob/main/docker-compose.yml \
For run use:
````bash
docker-compose up -d
````
After DataBase deployed, u need to create schema, user and password for java application\
first step: enter to container of database:
````bash
docker exec -it <container_name> bash
````
second step run sql script:
````sql
psql  -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
  CREATE USER $APP_DB_USER WITH PASSWORD '$APP_DB_PASS';
  CREATE DATABASE $APP_DB_NAME;
  GRANT ALL PRIVILEGES ON DATABASE $APP_DB_NAME TO $APP_DB_USER;
  COMMIT;
EOSQL
````
after this u can start ur docker container with springboot application
````bash
docker start <ur_container>
````
U can modify docker-compose, and set property restart on always mode.
# System design notice
