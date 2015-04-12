#!/bin/sh
mvn clean install;cd target/felix-framework-4.6.1/;java -jar bin/felix.jar;cd ../..