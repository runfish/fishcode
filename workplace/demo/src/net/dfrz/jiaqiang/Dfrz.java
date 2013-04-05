package net.dfrz.jiaqiang;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;




@Retention(RetentionPolicy.RUNTIME)
public @interface Dfrz {
	
	String color() default "blue";
	String value();
	int [] array() default {1,2,3} ;

}
