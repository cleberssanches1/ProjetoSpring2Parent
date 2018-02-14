package com.sanches.application.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

	public SenhaUtils() {		
	}

	/**
	 * Gera a senha encriptada.
	 * 
	 * @param senhaParam
	 *            String
	 * @return String
	 */
	public static String gerarBCriptString(String senhaParam) {
		String senha = senhaParam;

		if (senha != null) {
			BCryptPasswordEncoder bCryptPassWordEncoder = new BCryptPasswordEncoder();
			senha = bCryptPassWordEncoder.encode(senha);
		}

		return senha;
	}

	/**
	 * Método para verificar validade da senha
	 * 
	 * @param senhaParam
	 *            String
	 * @param encodedSenhaParam
	 *            String
	 * @return boolean
	 */
	public static boolean senhaValida(String senhaParam, String encodedSenhaParam) {
		boolean retorno = false;
		String senha = senhaParam;
		String encodedSenha = encodedSenhaParam;
		BCryptPasswordEncoder bCryptPassWordEncoder = new BCryptPasswordEncoder();

		retorno = bCryptPassWordEncoder.matches(senha, encodedSenha);

		return retorno;
	}

}
