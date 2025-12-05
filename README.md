# lambda-kinesis-java-powertools
A sample lambda that processes records from kinesis using AWS powertools for logging, tracing, and metrics.
This project demonstrates how to process Kinesis stream events using AWS lambda (java 11) and AWS Lambda Powertools for :
  1) Structured logging.
  2) Distributed tracing
  3) Custom metrics.

# Features 
Java 11 Lambda
Kinesis event processing
Powertools (Logging, Tracing, Metrics)
Maven Shade Plugin build
Local testing support

# Local Testing
Package :
mvn clean package
# Invoke locally (using sample event):
echo file://sample-event.json | sam local invoke KinesisEventHandler

# Architecture 

Kinesis Producer
      |
      v
+-------------------+
|  Amazon Kinesis   |
|     Stream        |
+-------------------+
          |
          v
+-----------------------------+
|      AWS Lambda (Java)      |
|  KinesisEventHandler.java   |
|  + Powertools Logging       |
|  + Powertools Tracing       |
|  + Powertools Metrics       |
+-----------------------------+
          |
          v
+-------------------+
| Amazon CloudWatch |
|  Logs & Metrics   |
+-------------------+
