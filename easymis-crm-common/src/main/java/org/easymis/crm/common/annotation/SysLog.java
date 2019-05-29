package org.easymis.crm.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLog {

    /**
     * 服务id
     * @return
     */
    String serviceId();

    /**
     * 模块名
     * @return
     */
    String moduleName();

    /**
     * 操作名
     * @return
     */
    String actionName();

}
