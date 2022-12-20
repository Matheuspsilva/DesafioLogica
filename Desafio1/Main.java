package com.matheussilvadev.desafioSupera;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		int numeroEntradas;
		ArrayList<Integer> par = new ArrayList<Integer>();
		ArrayList<Integer> impar = new ArrayList<Integer>();

		numeroEntradas = input.nextInt();
		int valores[] = new int[numeroEntradas];
		
		recebeValores(input, valores);
		
		separaValores(par, impar, valores);
		
		ordenaArrays(par, impar);

		populaArray(par, impar, valores);		

		imprimeArray(valores);

	}

	private static void imprimeArray(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	private static void recebeValores(Scanner input, int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}

		input.close();
	}

	private static void populaArray(ArrayList<Integer> par,
			ArrayList<Integer> impar, int[] array) {
		int n = 0;
		int tamanhoPar = par.size();
		for (int i = 0; i < array.length; i++) {
			if(i< tamanhoPar) {
				array[i] = par.get(i);
			}else {
				array[i] = impar.get(n);
				n++;
			}
		}
	}

	private static void ordenaArrays(ArrayList<Integer> par, ArrayList<Integer> impar) {
		par.sort(null);
		impar.sort(Collections.reverseOrder());
	}

	private static void separaValores(ArrayList<Integer> par, ArrayList<Integer> impar, int[] array) {
		for (int i : array) {
			if(i % 2 == 0)
				par.add(i);
			else 
				impar.add(i);
		}
	}

}
