package com.example.demo.providers;

import java.util.Map;

public interface TokenProvider {
	Map<String, String> decode(String token);
}
