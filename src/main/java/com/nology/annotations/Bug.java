package com.nology.annotations;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Bug {

    String[] descr() default "";

}
