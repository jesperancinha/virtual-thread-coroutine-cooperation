FROM postgres:15

COPY . /docker-entrypoint-initdb.d

COPY ./multiple /docker-entrypoint-initdb.d/multiple

EXPOSE 5432
