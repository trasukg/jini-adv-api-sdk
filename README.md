
Jini Advanced API Software Development Kit
==========================================

This is an annotation-based API for writing Jini services and clients.  It is
intended to make it simple to create Java-based microservices and other integrations.

Sample code is in the 'adv-api-hello-impl' module, which implements the 'hello world' service
from the Apache River Examples project (https://www.apache.org/dyn/closer.cgi/river/river-examples-1.0/river-examples-1.0-source-release.zip).

To run the hello program, do the following

    cd adv-api-hello-home/target/adv-api-hello-home-1.0-SNAPSHOT-bin
    java -Djava.security.policy=application.policy -jar lib/start.jar start.config

