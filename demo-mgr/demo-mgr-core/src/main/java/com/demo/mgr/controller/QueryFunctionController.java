package com.demo.mgr.controller;

import com.oceancode.cloud.common.constant.CommonConst;
import com.oceancode.cloud.common.web.graphql.GraphUtil;
import com.oceancode.cloud.common.web.graphql.QueryRequest;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(CommonConst.API_PREFIX)
public class QueryFunctionController {
    private GraphQL graphQL;

    @Autowired
    public void setGraphQL(GraphQL graphQL) {
        this.graphQL = graphQL;
    }

    @PostMapping("/graphql/query")
    public Object query(@RequestBody QueryRequest param) {
        ExecutionResult result = this.graphQL.execute(param.getQuery());
        return GraphUtil.getData(result);
    }
}
