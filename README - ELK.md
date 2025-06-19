
ELK :

https://www.youtube.com/watch?v=5s9pR9UUtAU&t=196s

Download :

ElasticSearch: https://www.elastic.co/downloads/elasticsearch - 7.9.3

Logstash: https://www.elastic.co/downloads/logstash - 7.9.3

Kibana: https://www.elastic.co/downloads/kibana - 9.0.2


Elastic Search : 

1) Run below comments :

1) elasticsearch.bat -> will get some error use below comments to run

2) elasticsearch -E xpack.security.enabled=false

After done we will use the below url for elestic search

http://localhost:9200/

{
  "name" : "DESKTOP-L93I0EG",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "Pq4bLh-eTW2kgAqWYkjseg",
  "version" : {
    "number" : "7.9.3",
    "build_flavor" : "default",
    "build_type" : "zip",
    "build_hash" : "c4138e51121ef06a6404866cddc601906fe5c868",
    "build_date" : "2020-10-16T10:36:16.141335Z",
    "build_snapshot" : false,
    "lucene_version" : "8.6.2",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}


http://localhost:9200/_cat/indices


green open .kibana-event-log-7.9.3-000001 pO9WKzHHTYW_Dtjsq_RmDA 1 0  1 0  5.4kb  5.4kb
green open .apm-custom-link               CNraQOQxTTKHbP6blpe-qA 1 0  0 0   208b   208b
green open .kibana_task_manager_1         GGKrttlfRVmS0uszUCAsdw 1 0  2 6 56.9kb 56.9kb
green open .apm-agent-configuration       Rv_-g06kQgSckAp_Ai9csQ 1 0  0 0   208b   208b
green open .kibana_1                      yhyHtw9jS1GKD-LTXzDHpg 1 0 11 0 41.9kb 41.9kb

----------------------------------------------------------------------------------------------------

Kibana :

1) Run below comments :

2)kibana.bat

http://localhost:5601/app/home#/


Index Query :

http://localhost:5601/app/dev_tools#/console

GET _search
{
  "query": {
    "match_all": {}
  }
}


GET _cat/indices

green  open .kibana-event-log-7.9.3-000001  pO9WKzHHTYW_Dtjsq_RmDA 1 0   2  0  10.9kb  10.9kb
green  open .apm-custom-link                CNraQOQxTTKHbP6blpe-qA 1 0   0  0    208b    208b
green  open .kibana_task_manager_1          GGKrttlfRVmS0uszUCAsdw 1 0   2  3  40.1kb  40.1kb
green  open .apm-agent-configuration        Rv_-g06kQgSckAp_Ai9csQ 1 0   0  0    208b    208b
green  open .async-search                   vEjNljtdRP-KljTATSGhOw 1 0  12 35     2mb     2mb
green  open .kibana_1                       yhyHtw9jS1GKD-LTXzDHpg 1 0  29 37 121.1kb 121.1kb
yellow open .ds-logs-generic-default-000001 aRK_3O1qQ1GJ2vUfN_vUjw 1 1 857  0 246.6kb 246.6kb

GET .kibana

GET .ds-logs-generic-default-000001

----------------------------------------------------------------------------------------------------

Logstash :

E:\Software\Elk\logstash-9.0.2\bin>logstash.bat -f .\config\logstash.conf


http://localhost:9200/.ds-logs-generic-default-000001/_search


{"took":1821,"timed_out":false,"_shards":{"total":1,"successful":1,"skipped":0,"failed":0},"hits":{"total":{"value":857,"relation":"eq"},"max_score":1.0,"hits":[{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"qLpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:906)\r"},"message":"\tat org.springframework.web.client.RestTemplate.doExecute(RestTemplate.java:906)\r","@timestamp":"2025-06-19T04:19:36.866915300Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"qbpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat org.springframework.cloud.netflix.eureka.http.RestTemplateEurekaHttpClient.getDelta(RestTemplateEurekaHttpClient.java:186)\r"},"message":"\tat org.springframework.cloud.netflix.eureka.http.RestTemplateEurekaHttpClient.getDelta(RestTemplateEurekaHttpClient.java:186)\r","@timestamp":"2025-06-19T04:19:36.872916500Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"qrpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$7.execute(EurekaHttpClientDecorator.java:152)\r"},"message":"\tat com.netflix.discovery.shared.transport.decorator.EurekaHttpClientDecorator$7.execute(EurekaHttpClientDecorator.java:152)\r","@timestamp":"2025-06-19T04:19:36.880375500Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"q7pphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat com.netflix.discovery.shared.transport.decorator.SessionedEurekaHttpClient.execute(SessionedEurekaHttpClient.java:76)\r"},"message":"\tat com.netflix.discovery.shared.transport.decorator.SessionedEurekaHttpClient.execute(SessionedEurekaHttpClient.java:76)\r","@timestamp":"2025-06-19T04:19:36.882919800Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"rLpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat com.netflix.discovery.DiscoveryClient.refreshRegistry(DiscoveryClient.java:1473)\r"},"message":"\tat com.netflix.discovery.DiscoveryClient.refreshRegistry(DiscoveryClient.java:1473)\r","@timestamp":"2025-06-19T04:19:36.887918100Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"rbpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)\r"},"message":"\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)\r","@timestamp":"2025-06-19T04:19:36.890918200Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"rrpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat java.base/sun.nio.ch.Net.pollConnect(Native Method)\r"},"message":"\tat java.base/sun.nio.ch.Net.pollConnect(Native Method)\r","@timestamp":"2025-06-19T04:19:36.928987200Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"r7pphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327)\r"},"message":"\tat java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327)\r","@timestamp":"2025-06-19T04:19:36.933918300Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"sLpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat org.apache.hc.client5.http.impl.classic.InternalExecRuntime.connectEndpoint(InternalExecRuntime.java:164)\r"},"message":"\tat org.apache.hc.client5.http.impl.classic.InternalExecRuntime.connectEndpoint(InternalExecRuntime.java:164)\r","@timestamp":"2025-06-19T04:19:36.938920200Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}},{"_index":".ds-logs-generic-default-000001","_type":"_doc","_id":"sbpphpcB-LDgIqB26s5A","_score":1.0,"_source":{"host":{"name":"DESKTOP-L93I0EG"},"@version":"1","log":{"file":{"path":"E:/Regith/Apps/logs/gateway.log"}},"event":{"original":"\tat org.apache.hc.client5.http.impl.classic.ProtocolExec.execute(ProtocolExec.java:192)\r"},"message":"\tat org.apache.hc.client5.http.impl.classic.ProtocolExec.execute(ProtocolExec.java:192)\r","@timestamp":"2025-06-19T04:19:36.965917600Z","data_stream":{"type":"logs","dataset":"generic","namespace":"default"}}}]}}



