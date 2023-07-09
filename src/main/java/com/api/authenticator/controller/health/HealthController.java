package com.api.authenticator.controller.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("health")
@RequestMapping("/")
public class HealthController {
  @RequestMapping(value = "health", method = RequestMethod.GET)
  @ApiOperation(value = "returns health status")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfull"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public ResponseEntity<Object> health() {
    return new ResponseEntity<>("healthy", HttpStatus.OK);

  }
}
