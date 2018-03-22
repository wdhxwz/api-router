package com.krista.apirouter.enumerate;

/**
 * 服务是否已经过期，过期的服务方法不能再访问
 * Created by Administrator on 2018/3/22.
 */
public enum ObsoletedType {
    YES, NO, DEFAULT;

    public static boolean isObsoleted(ObsoletedType type) {
        if (YES == type ) {
            return true;
        } else {
            return false;
        }
    }
}
