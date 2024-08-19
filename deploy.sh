#!/usr/bin/env bash

set -e

eval "$(minikube docker-env)"
docker buildx build -t demo-scheduling-shedlock-neo4j .
kubectl apply -f neo4j-deployment.yaml
kubectl apply -f spring-boot-deployment.yaml
