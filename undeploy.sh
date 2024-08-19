#!/usr/bin/env bash

set -e

kubectl delete deployments.apps demo-scheduling-shedlock-neo4j-deployment
kubectl delete services demo-scheduling-shedlock-neo4j-service
kubectl delete deployments.apps neo4j-deployment
kubectl delete services my-neo4j-service
