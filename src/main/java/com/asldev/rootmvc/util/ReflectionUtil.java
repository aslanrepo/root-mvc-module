package com.asldev.rootmvc.util;

import java.lang.reflect.ParameterizedType;

public class ReflectionUtil {
	public static Class<?> getDtoClass(Object restController){
		ParameterizedType dtoClass = (ParameterizedType) restController.getClass().getGenericSuperclass();
		return (Class<?>) dtoClass.getActualTypeArguments()[1];
	}

	public static Class<?> getEntityClass(Object restController){
		ParameterizedType dtoClass = (ParameterizedType) restController.getClass().getGenericSuperclass();
		return (Class<?>) dtoClass.getActualTypeArguments()[0];
	}
}
