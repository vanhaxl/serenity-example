package com.sams.membership.payout.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AcceptanceTestsConfiguration.class)
@Target(ElementType.TYPE)
@DirtiesContext
@Retention(RetentionPolicy.RUNTIME)
public @interface Step {
}
