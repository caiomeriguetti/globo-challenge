# Prerequisites

- Linux
- bash
- Docker
- Docker compose

# Local environment

### build app jar

To build application jar:

```./build-jar```

### build docker image

To build api docker image:

```./build-docker-image```


### run the app

```./up```

# Deploy



# 10k connections test

Being inside 10k dir, run:

``` python 10k.py ```

Then, check the number of ESTABLISHED connections:

``` sudo netstat -alntp | grep 8443 |wc -l ```