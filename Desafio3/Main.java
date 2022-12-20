package com.matheussilvadev.desafioSupera;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int tamanhoArray, valorAlvo, pares = 0;

		tamanhoArray = input.nextInt();
		valorAlvo = input.nextInt();
		
		int valores[] = new int[tamanhoArray];
		
		for (int i = 0; i < valores.length; i++) {
			valores[i] = input.nextInt();
		}
		
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores.length; j++) {
				if(valores[i] - valores[j] == valorAlvo) {
					pares++;
				}
			}
		}
		
		System.out.println(pares);
	}
}
