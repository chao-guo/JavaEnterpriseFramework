package com.company.project.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"ZZSampleApis"}, value = "ZZSampleValue")
@RestController
@RequestMapping(method = RequestMethod.POST)
public class ZZSampleController extends BaseController{

    @ApiOperation(value="testSwagger2Api",notes="...remark")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "para1", value = "value1|value2|value3"
                    , required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "para2", value = "value"
                    , required = true, paramType = "query", dataType = "String"),
    })
    @ApiResponses({
            @ApiResponse(code=200,message="200 message"),
            @ApiResponse(code=201,message="201 message"),
    })
    @RequestMapping("/zzsample/testSwagger2")
    public String testSwagger2() {

        return "testSwagger2 sucess";
    }
}
