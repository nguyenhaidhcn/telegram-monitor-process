package com.maker.cms.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {

	public static <T> String listToString(List<T> list) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			String s = mapper.writeValueAsString(list);
			return s;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> String toString(T object) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			String s = mapper.writeValueAsString(object);
			return s;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T toEntity(String s, Class<T> clazz) {
		if (s == null) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		T u = null;
		try {
			u = mapper.readValue(s, clazz);
			return u;
		} catch (Exception e) {
			return null;
		}
	}
}
