# debezium-data-sync-dbs
A POC to demonstrate use of Debezium connectors to synch up data between DBs
Sql Server streams data to Kafka using Debezium. Kafka streams are automatically set up based on the initial SQL scripts.
cdc a Springboot app has a Kafka listeners. It picks up the data streams and inserts data into Postgres SQL
elixir_kaffe_codealong is a Elixir app with a Kafka listener. This can also parallely pick up kafka streams and process the data as needed.

## Steps to run
Start postres DB \
```docker-compose -f docker-compose-postgre.yaml up -d```

Start Kafka, SQL Server and set up Kafka Streams \
```export DEBEZIUM_VERSION=1.6``` \
```docker-compose -f docker-compose-sqlserver.yaml up -d```

Register SQL Server with Debezium Connector. This will set up the topics for each of the tables to continously stream data changes in the tables. \
```curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @register-sqlserver.json```