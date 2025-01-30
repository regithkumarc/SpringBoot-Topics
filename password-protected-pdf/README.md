# SpringBoot-Topics

# URL's :

Soap Webservice CRUD :

https://www.concretepage.com/spring-boot/spring-boot-soap-web-service-example

-----------------------------------------------------------------------------------------------------------------

# H2 DB Config :

# H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2

# Datasource
spring.datasource.url=jdbc:h2:mem:soapwebserviceDB
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
#spring.jpa.hibernate.ddl-auto=update

-----------------------------------------------------------------------------------------------------------------

# DockerConfig :

Docker Comments :-

1) Download

https://www.docker.com/products/docker-desktop/ 

2) Login

docker login

3) Docker Build

docker build -t docker-demo .


4) Image Status 

docker images


5) Tag Image to docker image hub

docker tag docker-demo regithcprm/docker-demo


6) Push to Docker Hub

docker push regithcprm/docker-demo

7) Reomove tag using image name

docker rmi docker-demo


8) Run docker in locally

docker run -p 8085:8085 regithcprm

9) Remove tag force

docker rmi -f regithcprm/docker-demo

10) Pull

docker pull regithcprm/docker-demo

-----------------------------------------------------------------------------------------------------------------

# Git Comments :- 

Clone : git clone https://github.com/regithkumarc/SpringBoot-Topics.git 
Add Origin : git remote add origin https://github.com/regithkumarc/SpringBoot-Topics.git 
Checkout : git checkout NewBranch 
All Files : git add . 
Specific Files : git add classA classB class C 
Fetch All : git pull 
Verify Commits : git log 
Add : git commit -m "Implemented successfully" 
Update : git commit --amend -m "Updated Successfully" 
Code Changes : git status 
Push All : git push origin master 

Down merge from master to branch : 
git checkout master 
git pull 
git checkout test 
git merge master 
git push 

Auto Merging : git revert commitId(qqqqqqq) 
Change Commit message before Push : shift -> : wq -> Enter -> change commit message 
Create New Branch : git checkout -b "NewBranch"  
List All Branch : git branch --list 
Delete New Branch : git branch -d NewBranch 
Git Push All : git push --all  
Restore HTML : git restore index.html 

git checkout NewBranch 
git log --online  -> It will show all commit id with message for the NewBranch 
git checkout Master 
git log --online  -> It will show all commit id with message for the Master 

-----------------------------------------------------------------------------------------------------------------

# Kafka With Zookeeper

Start Zookeeper :

E:\Software\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties


Start the Kafka Server:

E:\Software\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties


Create Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic1 --partitions 3 --replication-factor 1

Created topic my-topic1.


E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic2 --partitions 3 --replication-factor 1

Created topic my-topic2.


List:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

my-topic1
my-topic2

Describe Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic my-topic1

[2024-12-19 21:00:58,847] WARN [AdminClient clientId=adminclient-1] The DescribeTopicPartitions API is not supported, using Metadata API to describe topics. (org.apache.kafka.clients.admin.KafkaAdminClient)
Topic: my-topic1        TopicId: AorH8CLzRuSy8u7BB8-2_g PartitionCount: 3       ReplicationFactor: 1    Configs:
        Topic: my-topic1        Partition: 0    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 1    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 2    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A


Produce Message:

E:\Software\kafka>.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-topic1


Consume Message:

E:\Software\kafka>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic1 --from-beginning

-----------------------------------------------------------------------------------------------------------------

# Kafka With Out Zookeeper

Generate a Cluster UUID :

E:\Software\kafka>.\bin\windows\kafka-storage.bat random-uuid

hqo1AMbgQyOv-KCP7vDCuA


Format Log Directories :

E:\Software\kafka>.\bin\windows\kafka-storage.bat format -t hqo1AMbgQyOv-KCP7vDCuA -c .\config\kraft\server.properties

Formatting /tmp/kraft-combined-logs with metadata.version 3.8-IV0.


Start the Kafka Server:

E:\Software\kafka>.\bin\windows\kafka-server-start.bat .\config\kraft\server.properties

bin/kafka-server-start.sh config/kraft/reconfig-server.properties


Create Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic1 --partitions 3 --replication-factor 1

Created topic my-topic1.


E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic my-topic2 --partitions 3 --replication-factor 1

Created topic my-topic2.


List:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

my-topic1
my-topic2

Describe Topic:

E:\Software\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic my-topic1

[2024-12-19 21:00:58,847] WARN [AdminClient clientId=adminclient-1] The DescribeTopicPartitions API is not supported, using Metadata API to describe topics. (org.apache.kafka.clients.admin.KafkaAdminClient)
Topic: my-topic1        TopicId: AorH8CLzRuSy8u7BB8-2_g PartitionCount: 3       ReplicationFactor: 1    Configs:
        Topic: my-topic1        Partition: 0    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 1    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A
        Topic: my-topic1        Partition: 2    Leader: 0       Replicas: 0     Isr: 0  Elr: N/A        LastKnownElr: N/A


Produce Message:

E:\Software\kafka>.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic my-topic1


Consume Message:

E:\Software\kafka>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic my-topic1 --from-beginning

-----------------------------------------------------------------------------------------------------------------
