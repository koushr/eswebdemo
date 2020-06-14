package com.example.eswebdemo.util;

import com.example.eswebdemo.model.IndicatorItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

/**
 * @author shengruikou
 */
@Slf4j
public class EsUtils {

    private static final RestHighLevelClient ES_CLIENT = new RestHighLevelClient(
            RestClient.builder(
                    new HttpHost("localhost", 9200, "http"),
                    new HttpHost("localhost", 9201, "http")));

    public static void bulk(String index, String type, Collection collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return;
        }
        try {
            RequestOptions requestOptions = RequestOptions.DEFAULT;
            BulkRequest bulkRequest = new BulkRequest();
            for (Object obj : collection) {
                bulkRequest.add(generateNewsRequest(index, type, obj));
            }
            BulkResponse bulkResponse = ES_CLIENT.bulk(bulkRequest, requestOptions);
            if (bulkResponse.hasFailures()) {
                throw new RuntimeException(bulkResponse.getItems()[0].getFailureMessage());
            }
        } catch (IOException e) {
            log.error("es bulk error", e);
            throw new RuntimeException();
        }
    }

    public static IndexRequest generateNewsRequest(String index, String type, Object obj) {
        IndexRequest indexRequest = new IndexRequest(index, type);
        indexRequest.source(ObjectMapperUtils.toJSON(obj), XContentType.JSON);
        String id = "";
        if (obj instanceof Map) {
            id = MapUtils.getString((Map) obj, "id");
        } else if (obj instanceof IndicatorItem) {
            int idInt = ((IndicatorItem) obj).getId();
            if (idInt > 0) {
                id = String.valueOf(idInt);
            }
        }
        if (StringUtils.isNotBlank(id)) {
            indexRequest.id(StringUtils.deleteWhitespace(id));
        }
        return indexRequest;
    }

}