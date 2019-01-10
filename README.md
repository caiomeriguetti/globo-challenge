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