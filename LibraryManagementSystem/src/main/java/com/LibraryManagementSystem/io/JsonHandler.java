package com.LibraryManagementSystem.io;

import com.LibraryManagementSystem.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.List;
import java.util.Set;

public class JsonHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static boolean validateJsonSchema(String jsonPath, String schemaPath) {

        try {

            JsonNode jsonNode = objectMapper.readTree(new File(jsonPath));

            JsonNode schemaNode = objectMapper.readTree(new File(schemaPath));

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

            JsonSchema schema = factory.getSchema(schemaNode);

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (!errors.isEmpty()) {

                System.out.println("Schema Validation Failed");

                errors.forEach(System.out::println);

                return false;
            }

            System.out.println("Schema Validation Successful");

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static List<Transaction> readTransactionsFromJson(String jsonPath) throws Exception {

        return objectMapper.readValue(new File(jsonPath),

                new TypeReference<List<Transaction>>() {
                });
    }

    public static void writeTransactionsToJson(String jsonPath, List<Transaction> transactions) throws Exception {

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), transactions);
    }
}