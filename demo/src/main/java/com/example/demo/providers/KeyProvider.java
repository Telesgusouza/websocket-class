package com.example.demo.providers;

import java.security.PublicKey;

// o key provider vai ser alguém que consegue retornar para a gente uma chave publica
public interface KeyProvider {

	PublicKey getPublicKey(String keyId);
	
}
