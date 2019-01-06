# Prerequisites

- Linux
- bash
- Docker
- Docker compose
- Ansible

# Local environment

### build app jar

To build application jar:

```./build-jar```

### build docker image

To build api docker image:

```./build-docker-image```


### run the app

```./up```

### Set status of user in redis

```curl --insecure -XPUT -H "Authorization: Basic Y2FpbzoxMjM0" https://localhost:9443/api/user/caio/status -d "status=XXXX"```

### Get user json

```curl --insecure https://localhost:9443/api/user/caio```

# Deploy

### Install api on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-api/install-api.yml --limit api-servers ```

### Install mongo on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-mongo/install-mongo.yml --limit mongo-servers```

### Install redis on a ssh-able host

after cd into deploy dir:

``` ansible-playbook install-redis/install-redis.yml --limit redis-servers```


# 10k connections test

Run the app, cd into 10k dir and run:

``` python 10k.py ```

Then, check the number of ESTABLISHED connections:

``` sudo netstat -alntp | grep 8443 |wc -l ```