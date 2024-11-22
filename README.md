# Bajaj Health Programming Challenge Solution

This application processes a JSON file to find the first occurrence of a "destination" key and generates an MD5 hash of concatenated values.

## Usage

```bash
java -jar destination-hash-generator-1.0-SNAPSHOT-jar-with-dependencies.jar <roll_number> <json_file_path>
```

### Parameters:
- `roll_number`: Your roll number in lowercase without spaces
- `json_file_path`: Absolute path to the JSON file to process

### Example
Given JSON file (example.json):
```json
{
  "key1": 10,
  "key2": {
    "key3": "value3",
    "destination": "finalValue"
  },
  "key4": [1, 2, {"destination": "anotherValue"}]
}
```

Command:
```bash
java -jar destination-hash-generator-1.0-SNAPSHOT-jar-with-dependencies.jar 12345 example.json
```

Output format:
```
<MD5_hash>;<random_string>
```

## Building from Source

1. Ensure you have Java and Maven installed
2. Clone this repository
3. Run: `mvn clean package`
4. The JAR file will be created in the `target` directory

## Direct Download
You can download the compiled JAR file directly from:
[Download JAR](https://github.com/YOUR_USERNAME/BajajChallenge/raw/main/destination-hash-generator-1.0-SNAPSHOT-jar-with-dependencies.jar)

## Requirements
- Java 11 or higher
- Input JSON file must be accessible
