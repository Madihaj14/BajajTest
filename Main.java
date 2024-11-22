package com.bajaj.challenge;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("Usage: java -jar hash-generator.jar <roll-number> <json-file-path>");
                System.exit(1);
            }

            String rollNumber = args[0];
            String jsonFilePath = args[1];

            // Read and parse JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File(jsonFilePath));

            // Find first destination value
            String destinationValue = findDestination(rootNode);
            if (destinationValue == null) {
                System.out.println("No destination key found in JSON");
                System.exit(1);
            }

            // Generate random string
            String randomString = RandomStringUtils.randomAlphanumeric(8);

            // Concatenate values and generate hash
            String concatenated = rollNumber + destinationValue + randomString;
            String hash = generateMD5Hash(concatenated);

            // Output result
            System.out.println(hash + ";" + randomString);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String findDestination(JsonNode node) {
        if (node.has("destination")) {
            return node.get("destination").asText();
        }

        if (node.isObject()) {
            for (JsonNode child : node) {
                String result = findDestination(child);
                if (result != null) {
                    return result;
                }
            }
        } else if (node.isArray()) {
            for (JsonNode element : node) {
                String result = findDestination(element);
                if (result != null) {
                    return result;
                }
            }
        }

        return null;
    }

    private static String generateMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }
        return hashText;
    }
}