package com.visiblestarsksa.survey.web.controllers;

import com.visiblestarsksa.survey.core.model.Survey;
import com.visiblestarsksa.survey.core.service.SurveyManagementService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/survey")
@Api(value = "survey", description = "Operations pertaining to survey management")
public class SurveyManagementController {

    private static final Logger logger = LoggerFactory.getLogger(SurveyManagementController.class);

    @Autowired SurveyManagementService surveyManagementService;

    @ApiOperation(value = "Get Survey", response = Survey.class)
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Successfully retrieved cluster status"),
                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                @ApiResponse(
                        code = 403,
                        message = "Accessing the resource you were trying to reach is forbidden"),
                @ApiResponse(
                        code = 404,
                        message = "The resource you were trying to reach is not found")
            })
    @GetMapping("/{surveyId}")
    public Optional<Survey> getSurvey(@PathVariable("surveyId") long surveyId) {
        logger.debug("getSurvey");
        return surveyManagementService.fetchSurvey(surveyId);
    }
}
