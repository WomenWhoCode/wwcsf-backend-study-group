# Kafka Simple Demo

## Dependencies
Java, Scala

To begin, you need to first download the latest version of Kafka. You can do this by running:

```
wget https://dlcdn.apache.org/kafka/3.1.0/kafka_2.13-3.1.0.tgz
tar -xzf kafka_2.13-3.1.0.tgz
mv kafka_2.13-3.1.0 kafka
```

Next, you need to start Zookeeper and a Kafka Broker. You can do this by running the following in separate shells:

```
kafka/bin/zookeeper-server-start.sh config/zookeeper.properties
kafka/bin/kafka-server-start.sh config/server.properties
```

After that, you can create a topic by running the following:

```
kafka/bin/kafka-topics.sh --create --partitions 1 --replication-factor 1 --topic quickstart-events --bootstrap-server localhost:9092
```

Next, you can start your consumer in a different shell, by running:

```
kafka/bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
```

This will spawn a consumer that will read `quickstart-events` from the beginning.

Then, you need to compile and run your `SimpleProducer.java` program. You can do this from the commandline as follows:
```
javac -cp "kafka/libs/*" *.java
java -cp "kafka/libs/*":. SimpleProducer quickstart-events
```

This will produce 10 messages with the value "Women Who Code". This should sync almost instaneously to the console consumer.
