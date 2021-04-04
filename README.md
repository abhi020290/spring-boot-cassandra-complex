# spring-boot-cassandra-complex


Download Apache Cassandra
Set up CASANDRA_HOME
Install python and set up Environment variable Path

Docker commands:

    docker pull cassandra
    docker run --name cassandra -p 9042:9042 -p 9160:9160   -d cassandra
    docker ps
    docker exec -it  /bin/bash

    nodetool status
    nodetool netstats
    cqlsh

This Application will create keyspace by itself during application Startup