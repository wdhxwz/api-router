package com.krista.apirouter.annotation;

import com.krista.apirouter.enumerate.ObsoletedType;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;


/**
 * 标注于服务类上 <br/>
 * 版本号默认为1.0 <br/>
 * 接口默认为不失效 <br/>
 * Created by Administrator on 2018/3/22.
 *
 * @author krista
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface Api {
    String value() default "";

    /**
     * 该方法所对应的版本号，对应version请求参数的值，版本为空，表示不进行版本限定
     *
     * @return
     */
    String version() default "1.0";

    /**
     * 服务所在模块
     *
     * @return
     */
    String module() default "";

    /**
     * 接口编号
     *
     * @return
     */
    String apiNo() default "";

    /**
     * 接口功能描述
     *
     * @return
     */
    String description() default "";

    /**
     * 服务方法是否已经过期，默认不过期
     *
     * @return
     */
    ObsoletedType obsoleted() default ObsoletedType.DEFAULT;
}