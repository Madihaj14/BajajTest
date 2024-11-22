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
[Download JAR](PS C:\Users\Lenovo\Downloads\Programming\bajajtest> java -jar C:\Users\Lenovo\Downloads\Programming\bajajtest\target\hash-generator-1.0-SNAPSHOT-jar-with-dependencies.jar 240350000046 ..\src\main\resources\test.json
Error: ..\src\main\resources\test.json (The system cannot find the path specified)
java.io.FileNotFoundException: ..\src\main\resources\test.json (The system cannot find the path specified)
        at java.base/java.io.FileInputStream.open0(Native Method)
        at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:159)
        at com.fasterxml.jackson.core.TokenStreamFactory._fileInputStream(TokenStreamFactory.java:278)
        at com.fasterxml.jackson.core.JsonFactory.createParser(JsonFactory.java:1089)
        at com.fasterxml.jackson.databind.ObjectMapper.readTree(ObjectMapper.java:3252)
        at com.bajaj.challenge.Main.main(Main.java:24))

