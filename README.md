# springfox-requestbody-jsonproperty
Springfox @JsonProperty generated empty Swagger 2.0 properties for @RequestBody

## Contrib

Requires Java 8

./gradlew bootrun

Open Swagger UI
http://localhost:8080/swagger-ui.html

Swagger JSON
http://localhost:8080/v2/api-docs?group=my-api

## Relavent Swagger JSON with Empty properties

```json
    {
	"definitions": {
        "RequestWithoutJsonCreator": {},
        "ResponseObject": {
            "required": [
                "OutField1",
                "OutField2"
            ],
            "properties": {
                "OutField1": {
                    "type": "string",
                    "readOnly": true
                },
                "OutField2": {
                    "type": "string",
                    "readOnly": true
                }
            }
        },
        "RequestWithJsonCreator": {
            "required": [
                "input_field_1",
                "input_field_2"
            ],
            "properties": {
                "input_field_1": {
                    "type": "string",
                    "readOnly": true
                },
                "input_field_2": {
                    "type": "string",
                    "readOnly": true
                }
            }
        }
    }
```

