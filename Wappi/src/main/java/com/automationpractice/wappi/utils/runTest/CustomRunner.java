package com.automationpractice.wappi.utils.runTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import net.serenitybdd.cucumber.CucumberWithSerenity;

public class CustomRunner extends Runner {

	private Class<CucumberWithSerenity> classValue;
	private CucumberWithSerenity cucumberWithSerenity;

	private static final Logger LOGGER = Logger.getLogger(CustomRunner.class);

	public CustomRunner(Class<CucumberWithSerenity> classValue) {
		this.classValue = classValue;
		try {
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	@Override
	public Description getDescription() {
		return cucumberWithSerenity.getDescription();
	}

	private void runAnnotatedMethods(Class<?> annotation) {
		if (!annotation.isAnnotation()) {
			return;
		}
		Method[] methods = this.classValue.getMethods();
		for (Method method : methods) {
			Annotation[] annotations = method.getAnnotations();
			for (Annotation item : annotations) {
				if (item.annotationType().equals(annotation)) {
					try {
						method.invoke(null);
					} catch (Exception e) {
						LOGGER.error(e.getMessage(), e);
					}
					break;
				}
			}
		}
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			runAnnotatedMethods(BeforeSuite.class);
			cucumberWithSerenity = new CucumberWithSerenity(classValue);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		cucumberWithSerenity.run(notifier);
	}
}
