package com.Hotel_Reservation_System.io;

import com.Hotel_Reservation_System.model.Reservation;
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
    private static final ObjectMapper mapper = new ObjectMapper();

    public static boolean validateJsonSchema(String jsonPath, String schemaPath) {

        try {

            JsonNode schemaNode = mapper.readTree(new File(schemaPath));

            JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);

            JsonSchema schema = factory.getSchema(schemaNode);

            JsonNode jsonNode = mapper.readTree(new File(jsonPath));

            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (!errors.isEmpty()) {

                errors.forEach(System.out::println);
                return false;
            }

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static List<Reservation> readReservationsFromJson(String filePath) {

        try {

            return mapper.readValue(new File(filePath), new TypeReference<List<Reservation>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.of();
    }

    public static void writeReservationsToJson(String filePath, List<Reservation> reservations) {

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), reservations);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
