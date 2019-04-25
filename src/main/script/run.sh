#!/bin/sh

# Start the proxy
/usr/local/bin/cloud_sql_proxy -instances=$CLOUDSQL_INSTANCE=tcp:5432 -credential_file=$CLOUDSQL_CREDENTIALS &

# wait for the proxy to spin up
sleep 10

# Start the server
./application -Dquarkus.http.host=0.0.0.0 -Dquarkus.http.port=$PORT
