package com.matheussilvadev.desafioSupera;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in).useLocale(Locale.US);
		BigDecimal valor;
		BigDecimal valores[] = { new BigDecimal(100.0), new BigDecimal(50.0), new BigDecimal(20.0),
				new BigDecimal(10.0), new BigDecimal(5.0), new BigDecimal(2.0), new BigDecimal(1.0),
				new BigDecimal(0.50), new BigDecimal(0.25), new BigDecimal(0.10), new BigDecimal(0.05),
				new BigDecimal(0.01) };
		ArrayList<Integer> quantidadeNotas = new ArrayList<Integer>();

		valor = lerEntrada(input);
		calculoNotasMoedas(valor, valores, quantidadeNotas);

	}

	private static BigDecimal lerEntrada(Scanner input) {
		BigDecimal valor = input.nextBigDecimal();
		input.close();
		return valor;
	}

	private static void calculoNotasMoedas(BigDecimal valor, BigDecimal[] valores, ArrayList<Integer> quantidadeNotas) {
		int n = 0;

		while (valor.compareTo(new BigDecimal(0.009)) > 0) {
			quantidadeNotas.add((valor.divide(valores[n], 2, RoundingMode.HALF_UP)).intValue());
			valor = valor.remainder(valores[n].setScale(2, RoundingMode.HALF_UP));
			n++;

			if (n >= valores.length) {
				break;
			}
		}

		imprimir(valores, quantidadeNotas);
	}

	private static void imprimir(BigDecimal[] valores, ArrayList<Integer> quantidadeNotas) {
		boolean isPrinted = false;
		System.out.println("NOTAS:");
		for (int n = 0; n < valores.length; n++) {
			if (valores[n].compareTo(new BigDecimal(1.0)) <= 0) {
				if (!isPrinted) {
					System.out.println("MOEDAS:");
					isPrinted = true;
				}

				if (n >= quantidadeNotas.size()) {
					quantidadeNotas.add(0);
				}

				System.out.println(
						quantidadeNotas.get(n) + " moeda(s) de R$ " + String.format(Locale.US, "%.2f", valores[n]));
			} else {
				System.out.println(
						quantidadeNotas.get(n) + " nota(s) de R$ " + String.format(Locale.US, "%.2f", valores[n]));
			}

		}
	}

}
