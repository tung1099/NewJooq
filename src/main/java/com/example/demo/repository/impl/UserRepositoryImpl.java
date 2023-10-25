package com.example.demo.repository.impl;

import com.example.demo.model.User;
import com.example.demo.model.UserWithDepartment;
import com.example.demo.repository.IUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class UserRepositoryImpl implements IUserRepository {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public List<User> findUserByAge(int age) {
        Criteria criteria = Criteria.where("age").gte(age);
        Query query = new Query(criteria);
        return mongoTemplate.find(query, User.class);
    }
    public List<UserWithDepartment> findUsersWithDepartments() {
        AggregationOperation convertDepartmentIdToObjectId = new AggregationOperation() {
            @Override
            public Document toDocument(AggregationOperationContext context) {
                return new Document("$addFields",
                        new Document("departmentId",
                                new Document("$toObjectId", "$departmentId")));
            }
        };

        Aggregation aggregation = Aggregation.newAggregation(
                convertDepartmentIdToObjectId,
                LookupOperation.newLookup()
                        .from("department")
                        .localField("departmentId")
                        .foreignField("_id")
                        .as("departments")
        );

        AggregationResults<UserWithDepartment> results = mongoTemplate.aggregate(aggregation, "user", UserWithDepartment.class);
        return results.getMappedResults();
    }

}
