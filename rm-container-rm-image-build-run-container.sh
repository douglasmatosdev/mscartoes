#!/bin/bash

name="cursoms-cartoes"
network="cursoms-network"
rabbitmq_server="cursoms-rabbitmq"
eureka_server="cursoms-eureka"

docker stop "${name}" ;\
docker rm -f "${name}" ;\
docker image rm -f "${name}" ;\
docker build --tag "${name}" . ;\
docker run --name "${name}" --network "${network}" -e  RABBITMQ_SERVER="${rabbitmq_server}" -e EUREKA_SERVER="${eureka_server}" "${name}"
