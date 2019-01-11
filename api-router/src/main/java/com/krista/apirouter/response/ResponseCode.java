package com.krista.apirouter.response;

/**
 * 响应码接口<br/>
 * 基于jdk 8
 * Created by Administrator on 2018/3/22.
 *
 * @author Administrator
 */
public interface ResponseCode<T> {
    T getCode();

    String getMessage();

    /**
     * 将值转换为指定枚举类型
     *
     * @param enumType
     * @param code
     * @return
     */
    public static <C extends ResponseCode<?>> C parse(Class<C> enumType, Object code) {
        C[] enums = enumType.getEnumConstants();
        for (C t : enums) {
            if (t.getCode().equals(code)) {
                return t;
            }
        }

        throw new IllegalArgumentException("没有枚举" + enumType.getCanonicalName()
                + "." + code);
    }

    /**
     * 判断值是否是指定枚举类型
     *
     * @param enumType
     * @param code
     * @return
     */
    public static <C extends ResponseCode<?>> boolean isEnumType(Class<C> enumType, Object code) {
        try {
            parse(enumType, code);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}