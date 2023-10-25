package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MongoTemplateCommon {
    public AggregationOperation buildConvertToObjectId(String fieldToConvert) {
        return new AggregationOperation() {
            @Override
            public Document toDocument(AggregationOperationContext context) {
                return new Document("$addFields",
                        new Document(fieldToConvert,
                                new Document("$toObjectId", "$" + fieldToConvert)));
            }
        };
    }
}
