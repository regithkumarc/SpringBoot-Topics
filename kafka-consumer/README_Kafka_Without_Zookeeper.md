# Kafka Producer and Consumerwithout Zookeeper

Generate a Cluster UUID :

E:\Software\kafka>.\bin\windows\kafka-storage.bat random-uuid

hqo1AMbgQyOv-KCP7vDCuA

-----------------------------------------------------------------------------------------------------------------

Format Log Directories :

E:\Software\kafka>.\bin\windows\kafka-storage.bat format -t hqo1AMbgQyOv-KCP7vDCuA -c .\config\kraft\server.properties

Formatting /tmp/kraft-combined-logs with metadata.version 3.8-IV0.

-----------------------------------------------------------------------------------------------------------------

Start the Kafka Server:

E:\Software\kafka>.\bin\windows\kafka-server-start.bat .\config\kraft\server.properties

bin/kafka-server-start.sh config/kraft/reconfig-server.properties


-----------------------------------------------------------------------------------------------------------------

Create Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic1 --partitions 3 --replication-factor 1

Created topic my-topic1.


E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic2 --partitions 3 --replication-factor 1

Created topic my-topic2.

-----------------------------------------------------------------------------------------------------------------

List:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

my-topic1
my-topic2

-----------------------------------------------------------------------------------------------------------------

Describe Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic my-topic1

[2024-12-19 21:00:58,847] WARN [AdminClient clientId=adminclient-1] The DescribeTopicPartitions API is not supported, using Metadata API to describe topics. (org.apache.kafka.clients.admin.KafkaAdminClient)
Topic: my-topic1        TopicId: AorH8CLzRuSy8u7BB8-2_g PartitionCount: 3       ReplicationFactor: 1    Configs:
        Topic: my-topic1        Partition: 0    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 1    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 2    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A

-----------------------------------------------------------------------------------------------------------------

Produce Message:

E:\Software\kafka>.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-topic1

-----------------------------------------------------------------------------------------------------------------

Consume Message:

E:\Software\kafka>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic1 --from-beginning

-----------------------------------------------------------------------------------------------------------------
