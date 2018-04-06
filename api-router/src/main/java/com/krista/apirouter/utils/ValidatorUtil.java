package com.krista.apirouter.utils;

import com.krista.apirouter.exception.ApiException;
import com.krista.apirouter.response.ApiResponseCode;
import org.springframework.validation.*;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 基于JSR-303的验证工具类
 */
public class ValidatorUtil {
    private ValidatorUtil() {

    }

    /**
     * 使用JSR303标准对传进来的对象进行验证
     *
     * @param bindObject
     * @return 验证通过，返回null
     */
    public static void valid(Object bindObject) throws ApiException{
        DataBinder dataBinder = new DataBinder(bindObject, "bindObject");
        dataBinder.setValidator(getValidator());
        dataBinder.validate();
        BindingResult bindingResult = dataBinder.getBindingResult();
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                if (objectError instanceof FieldError) {
                    FieldError fieldError = (FieldError) objectError;
                    throw new ApiException(fieldError.getDefaultMessage(), ApiResponseCode.ParamError);
                }
            }
        }
    }


    /**
     * 验证器
     */
    private static Validator validator;

    /**
     * 初始化验证器
     *
     * @return
     */
    private static Validator getValidator() {
        if (validator == null) {
            LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
            localValidatorFactoryBean.afterPropertiesSet();
            validator = localValidatorFactoryBean;
        }

        return validator;
    }
}
