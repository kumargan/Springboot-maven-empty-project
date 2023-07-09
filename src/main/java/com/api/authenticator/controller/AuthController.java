package com.api.authenticator.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.api.authenticator.service.AuthService;

@Slf4j
@Controller("AuthControllerV1")
@RequestMapping("/v1")
public class AuthController {

  @Autowired
  AuthService authService;

  @RequestMapping(value = "authenticate", method = RequestMethod.GET)
  @ApiOperation(value = "returns authentication status")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfull"),
      @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
      @ApiResponse(code = 403,
          message = "Accessing the resource you were trying to reach is forbidden"),
      @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
  public ResponseEntity<Object> verify() {

    HttpStatus status = HttpStatus.FORBIDDEN;
    if(authService.authenticate())
      status = HttpStatus.OK;

    return new ResponseEntity<>("", status);

  }
}
