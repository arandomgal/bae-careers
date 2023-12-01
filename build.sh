#!/bin/sh
tag="1.0.5"
echo "Build new artifact for BAE Careers REST API release:$tag"
echo "==> Step 1: Build Jar file."
mvn clean install -DskipTests
echo "==> Step 2: Create new image file."
docker build . -t ymandrews/bae-careers-rest-api:$tag
echo "==> Step 3: Push image to docker hub."
docker push ymandrews/bae-careers-rest-api:$tag
echo "Done!"