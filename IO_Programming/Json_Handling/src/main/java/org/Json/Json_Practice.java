package org.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Map;

public class Json_Practice {
        public static void main(String args[]) throws JsonProcessingException {
            String user="{\r\n" + //
                    "  \"name\":\"Arpit\",\r\n" + //
                    "  \"phone\":\"76685\",\r\n" + //
                    "  \"skills\":[\"Java\",\"Sql\",\"Dsa\"],\r\n" + //
                    "  \"address\":{\r\n" + //
                    "    \"house_no\": 187,\r\n" + //
                    "    \"city\":\"Agra\"\r\n" + //
                    "  }\r\n" + //
                    "}";
            ObjectMapper mapper=new ObjectMapper();
            Map<String,Object> value =mapper.readValue(user, Map.class);
            System.out.println(value);
            Student st=mapper.readValue(user,Student.class);
            System.out.println(st.getName());
            System.out.println(st.getPhone());
            System.out.println(st.getAddress().getCity());
            System.out.println(st.getAddress().getHouse_no());
            System.out.println(Arrays.toString(st.getSkills()));
            String user1=mapper.writeValueAsString(st);
            System.out.println(user1);
            JsonNode jsonn=mapper.readTree(user);
            System.out.println(jsonn.get("name"));
            JsonNode skill=jsonn.get("skills");
            for(JsonNode i:skill){
                System.out.println((i));
            }
        }
}
