package com.krista.apirouter.enumerate;

/**
 * 服务是否已经过期，过期的服务方法不能再访问
 * Created by Administrator on 2018/3/22.
 *
 * @author krista
 */
public enum ObsoletedType {
    /**
     * 过期
     */
    YES,
    /**
     * 未过期
     */
    NO,
    /**
     * 默认
     */
    DEFAULT;

    public static boolean isObsoleted(ObsoletedType type) {
        return YES == type;
    }
}
