package com.test.model

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.Immutable
import groovy.transform.ToString
import groovy.util.logging.Slf4j
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.NotBlank

@Slf4j
@ApiModel
@ToString(includePackage = false, includeNames = true)
@Immutable class RequestWithoutJsonCreator {

    // Purpose of using @JsonProperty here:
    // https://github.com/FasterXML/jackson-annotations#usage-simple
    // "One of most common tasks is to change JSON name used for a property"

    @NotBlank
    @ApiModelProperty(required = true, readOnly = true)
    @JsonProperty('InField1')
    String input_field_1

    @NotBlank
    @ApiModelProperty(required = true, readOnly = true)
    @JsonProperty('InField2')
    String input_field_2
}
