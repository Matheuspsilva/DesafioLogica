package com.matheussilvadev.desafioSupera;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int numeroFrases;
		
		numeroFrases = input.nextInt();
		// Recebe enter
		input.nextLine();

		String frases[] = new String[numeroFrases];

		for (int i = 0; i < numeroFrases; i++) {
			frases[i] = input.nextLine();

		}

		for (int i = 0; i < frases.length; i++) {
			converterFrase(frases[i]);
		}

	}

	private static void converterFrase(String frase) {
		int meioFrase;

		int tamanhoFrase = frase.length();

		if (tamanhoFrase % 2 == 0) {
			meioFrase = tamanhoFrase / 2;
		} else {
			meioFrase = tamanhoFrase / 2 + 1;
		}

		String primeiraFrase = frase.substring(0, meioFrase);
		String segundaFrase = frase.substring(meioFrase);

		frase = new StringBuilder(primeiraFrase).reverse().toString() + new StringBuilder(segundaFrase).reverse().toString();

		System.out.println(frase);
	}
}
