package br.com.qintess.microservicepagamento.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bouncycastle.crypto.RuntimeCryptoException;

public class GeneralTests {

	public static int[] numbers = { 90, 2, 5, 7, 9, 6, 11, 15, 12 };

	public static int[] aux_array = null;

	public static int minorValue = 0;

	public static List<Integer> auxCollection = new ArrayList<>();

	public static void main(String[] args) throws IllegalArgumentException, Exception, IOException {
		try {
			for (int number : numbers) {
				System.out.println("Number = " + number);
			}
			Arrays.sort(numbers);
			System.out.println("The sorted int array is:");
			for (int number : numbers) {
				System.out.println("Number = " + number);
			}
		} catch (NumberFormatException ex) {
			throw new RuntimeCryptoException(ex.getMessage());
		}
	}

	public static int sortByminorNumber(int[] numbers) {
		List<int[]> lista = Arrays.asList(numbers);
		if (numbers != null && numbers.length >= 1) {
			Arrays.sort(numbers);
			for (int z = 0; z < numbers.length; z++) {
				auxCollection.add(Integer.valueOf(z));

				for (int i = 0; i < auxCollection.size(); i++) {
					while (auxCollection.get(i) > 0) {
						if (auxCollection.get(i) < minorValue) {
							minorValue = auxCollection.get(i);

						}

					}
				}
				/*
				 * List<int[]> list = Arrays.asList(numbers);
				 * 
				 * int begin = numbers[0]; int end = numbers.length - 1; for (int i = 0; i <
				 * end; i++) { int position = numbers[i]; if
				 * (String.valueOf(position).equals("0")) { return position; } int next_position
				 * = numbers[i + 1]; if (next_position < position) { minorValue = position; for
				 * (int x = 0; x < numbers.length; x++) { int pos = numbers[x]; do { minorValue
				 * = numbers[x]; } while (numbers[x] < minorValue);
				 * 
				 * }
				 * 
				 * } } }
				 */
				return minorValue;
			}
		}
		return minorValue;
	}
}
