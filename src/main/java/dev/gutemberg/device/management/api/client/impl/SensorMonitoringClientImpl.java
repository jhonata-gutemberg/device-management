package dev.gutemberg.device.management.api.client.impl;

import dev.gutemberg.device.management.api.client.SensorMonitoringClient;
import dev.gutemberg.device.management.api.client.SensorMonitoringRestClientFactory;
import io.hypersistence.tsid.TSID;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class SensorMonitoringClientImpl implements SensorMonitoringClient {
    private final RestClient restClient;

    public SensorMonitoringClientImpl(final SensorMonitoringRestClientFactory sensorMonitoringRestClientFactory) {
        this.restClient = sensorMonitoringRestClientFactory.build();
    }

    @Override
    public void enableMonitoring(TSID sensorId) {
        this.restClient.put()
                .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId)
                .retrieve()
                .toBodilessEntity();
    }

    @Override
    public void disableMonitoring(TSID sensorId) {
        this.restClient.delete()
                .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId)
                .retrieve()
                .toBodilessEntity();
    }
}
