# Prerequisites

- Linux
- bash
- Docker
- Docker compose
- Ansible

# Local environment

## FrontEnd

### compile frontend js files

cd into frontend and then:

```./compile-js```

After js compilation, being in the project root run:

``` ./build-docker-image-front ```

## Backend

### build app jar

To build application jar:

```./build-jar```

### build docker image

To build api docker image:

```./build-docker-image```

## Put everything up

### run the app

```./up```

### run tests

```./test```

### Basic Auth credentials

caio
1234

### Set status of user in redis

```curl --insecure -XPUT -H "Authorization: Basic Y2FpbzoxMjM0" https://localhost:9443/api/user/caio/status -d "status=XXXX"```

### Get user json

```curl --insecure https://localhost:9443/api/user/caio```

# Deploy

## Frontend

TODO: Frontend deploy

## Backend

### Install api on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-api/install-api.yml --limit api-servers ```

### Install mongo on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-mongo/install-mongo.yml --limit mongo-servers```

### Install redis on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-redis/install-redis.yml --limit redis-servers```

# Load test using apache benchmark

I did some load tests using AWS EC2 instances with the following profiles:

Api Server - c4.2xlarge - 8 Cores - 15GB RAM - Price 0,398 USD/hour
Apache Benchmark Server - c5.4xlarge - 16 Cores - 31GB RAM

And i got the following results:

```
[root@ip-10-0-2-240 centos]# ab -k -n 1000000 -c 10000 https://34.196.85.137:9443/public/ping
This is ApacheBench, Version 2.3 <$Revision: 1430300 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking 34.196.85.137 (be patient)
Completed 100000 requests
Completed 200000 requests
Completed 300000 requests
Completed 400000 requests
Completed 500000 requests
Completed 600000 requests
Completed 700000 requests
Completed 800000 requests
Completed 900000 requests
Completed 1000000 requests
Finished 1000000 requests


Server Software:        
Server Hostname:        34.196.85.137
Server Port:            9443
SSL/TLS Protocol:       TLSv1.2,ECDHE-RSA-AES256-GCM-SHA384,2048,256

Document Path:          /public/ping
Document Length:        4 bytes

Concurrency Level:      10000
Time taken for tests:   69.790 seconds
Complete requests:      1000000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    1000000
Total transferred:      390000000 bytes
HTML transferred:       4000000 bytes
Requests per second:    14328.77 [#/sec] (mean)
Time per request:       697.896 [ms] (mean)
Time per request:       0.070 [ms] (mean, across all concurrent requests)
Transfer rate:          5457.25 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  174 1790.6      0   22784
Processing:   102  520 424.5    481   17584
Waiting:        2  520 424.5    481   17584
Total:        102  695 1978.6    481   23310

Percentage of the requests served within a certain time (ms)
  50%    481
  66%    493
  75%    499
  80%    503
  90%    523
  95%    554
  98%    735
  99%  15937
 100%  23310 (longest request)
```

The api server evidence of 10k open connections:

```
[centos@ip-10-0-2-32 ~]$ sudo docker exec -it api-run_api_1 netstat -alntp | grep 8443 |grep ESTABLISHED | wc -l
10000
```

I had to install netstat manually inside the api container.