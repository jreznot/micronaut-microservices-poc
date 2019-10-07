package pl.altkom.asc.lab.micronaut.poc.dashboard.infrastructure.adapters.elastic;

import io.micronaut.context.annotation.Factory;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import javax.inject.Singleton;

@Factory
public class ElasticConfig {

    private final ElasticSearchSettings elasticSearchSettings;

    public ElasticConfig(ElasticSearchSettings elasticSearchSettings) {
        this.elasticSearchSettings = elasticSearchSettings;
    }

    @Singleton
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(
                new HttpHost(elasticSearchSettings.getHost(), elasticSearchSettings.getPort(), "http")));
    }

}
