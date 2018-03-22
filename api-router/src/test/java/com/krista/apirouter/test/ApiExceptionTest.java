package com.krista.apirouter.test;

import com.krista.apirouter.exception.ApiException;

public class ApiExceptionTest {
    public static void main(String[] args) throws ApiException {
        throw new ApiException("hahaha");
    }
}
