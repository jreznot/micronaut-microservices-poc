package pl.altkom.asc.lab.micronaut.poc.dashboard.infrastructure.adapters.elastic;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("elastic")
class ElasticSearchSettings {
    private String host;
    private int port;
    private int connectionTimeout;
    private int connectionRequestTimeout;
    private int socketTimeout;
    private int maxRetryTimeout;

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getConnectionRequestTimeout() {
        return this.connectionRequestTimeout;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public int getMaxRetryTimeout() {
        return this.maxRetryTimeout;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setMaxRetryTimeout(int maxRetryTimeout) {
        this.maxRetryTimeout = maxRetryTimeout;
    }
}
