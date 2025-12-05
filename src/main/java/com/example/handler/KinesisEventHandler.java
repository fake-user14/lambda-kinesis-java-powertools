package com.example.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.lambda.powertools.logging.Logging;
import software.amazon.lambda.powertools.metrics.Metrics;
import software.amazon.lambda.powertools.tracing.Tracing;

public class KinesisEventHandler implements RequestHandler<KinesisEvent, String> {

    @Override
    @Logging(logEvent = true)
    @Tracing
    @Metrics(captureColdStart = true)
    public String handleRequest(KinesisEvent event, Context context) {

        event.getRecords().forEach(record -> {
            String data = new String(record.getKinesis().getData().array());
            System.out.println("Received record: " + data);
        });

        return "Success";
    }
}