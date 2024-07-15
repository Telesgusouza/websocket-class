package com.example.demo.cachetest;

import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class StringGenerator {

	public String buildSimpleString() {
		return UUID.randomUUID().toString();
	}

	@Cacheable("cached-string")
	public String buildCachedString() {
		return UUID.randomUUID().toString();
	}

}
