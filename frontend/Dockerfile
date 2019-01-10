FROM ubuntu:18.04

RUN apt-get update \
    && apt-get install -y nginx

COPY ./globochallenge/dist/globochallenge /src
COPY ./nginx/default /etc/nginx/sites-available/default
