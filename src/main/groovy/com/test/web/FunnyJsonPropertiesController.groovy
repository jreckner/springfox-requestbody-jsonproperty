package com.test.web

import com.test.model.RequestWithJsonCreator
import com.test.model.RequestWithoutJsonCreator
import com.test.model.ResponseObject
import groovy.util.logging.Slf4j
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid
import javax.validation.ValidationException

@Api
@RestController
@RequestMapping(value = '/api')
@Slf4j
class FunnyJsonPropertiesController {

    @RequestMapping(method = RequestMethod.POST, value = '/withoutjsoncreator')
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = 'Without JsonCreator',
            response = ResponseObject,
            responseContainer = 'Map',
            consumes = 'application/json',
            produces = 'application/json',
            nickname = 'Request Body Object without JsonCreator'
    )
    def without(@RequestBody @Valid final RequestWithoutJsonCreator request, final BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            log.error 'Invalid request {}', request
            throw new BindException(bindResult)
        }

        return new ResponseObject(field_1: "value1", field_2: "value2")
    }

    @RequestMapping(method = RequestMethod.POST, value = '/withjsoncreator')
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = 'With JsonCreator',
            response = ResponseObject,
            responseContainer = 'Map',
            consumes = 'application/json',
            produces = 'application/json',
            nickname = 'Request Body Object with JsonCreator'
    )
    def with(@RequestBody @Valid final RequestWithJsonCreator request, final BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            log.error 'Invalid request {}', request
            throw new BindException(bindResult)
        }

        return new ResponseObject(output_field_1: "value1", output_field_2: "value2")
    }
}
