package io.github.sivalabs.springutils.aop;

import java.lang.annotation.*;

/**
 * This is a marker annotation to indicate where to apply LoggingAspect.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Loggable {}
