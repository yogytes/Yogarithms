package amagi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LinkingLoader {
	public static void main(String[] args) {
		int index = 0;
		Scanner in = new Scanner(System.in);
		in.useDelimiter("[\\r]+");
		//System.out.println(in.delimiter());
		String previous = "";

		List<String> inputCase = new LinkedList<String>();
		/*
		 * Read cases
		 */
		while (in.hasNext()) {
			String current = in.next();
			if (previous.endsWith("$") && current.endsWith("$")) {
				break;
			}
			if (current.endsWith("$")) {
				// Solve the case
				index++;
				solve(index, inputCase);
				inputCase = new LinkedList<String>();
			} else if (!current.endsWith("Z")) {
				inputCase.add(current);
			}

			previous = current;

		}
	}

	private static void solve(int index, List<String> inputCase) {
		Map<String, String> symbols = new HashMap<String, String>();
		List<String> refs = new ArrayList<String>();

		Integer bytesAllocated = Integer.valueOf("00", 16);
		// Address Calculation
		for (String s : inputCase) {
			// System.out.println(s);
			String[] splits = s.split(" ");
			splits[0] = splits[0].trim();
			if (splits[0].equals("D")) {
				if (symbols.containsKey(splits[1])) {
					symbols.put(splits[1], symbols.get(splits[1]) + " M");
				} else {
					// System.out.printf("%s %x","Allocated bytes"
					// ,bytesAllocated);
					Integer memory = 0x100 + bytesAllocated
							+ Integer.valueOf(splits[2], 16);
					symbols.put(splits[1], String.valueOf(memory));

				}

			}
			if (splits[0].equals("E")) {
				refs.add(splits[1]);
			}
			if (splits[0].equals("C")) {
				for (int i = 2; i < splits.length; i++) {
					bytesAllocated += 0x1;
				}
			}
			// System.out.printf("%s %x","Allocated bytes" ,bytesAllocated);
		}
		short checkSum = 0x00;
		// Checksum Calculation
		for (String s : inputCase) {
			// System.out.println(s);
			String[] splits = s.split(" ");
			splits[0] = splits[0].trim();
			if (splits[0].equals("C")) {
				for (int i = 2; i < splits.length; i++) {
					if (splits[i].equals("$")) {
						String symbol = refs
								.get(Integer.valueOf(splits[i + 1]));
						if (symbols.containsKey(symbol)) {
							String address = symbols.get(symbol).replaceAll(
									" M", "");
							Integer addr = Integer.parseInt(address);
							// System.out.printf("%s %x", "address", addr);
							/**
							 * Split address into higher and lower order bytes
							 */
							Integer higher = ((addr >> 8) & 0xff);
							Integer lower = (addr & 0xff);
							// System.out.printf("%s %x", "Higher", higher);
							// System.out.printf("%s %x","lower", lower);
							// System.out.println();
							splits[i] = Integer.toHexString(higher);
							splits[i + 1] = Integer.toHexString(lower);

						} else {
							splits[i] = String.valueOf(0);
							splits[i + 1] = String.valueOf(0);

						}

					}
					checkSum = (short) ((Integer.rotateLeft(checkSum, 1)) + (Integer
							.parseInt(splits[i], 16)));
					/*
					 * System.out.println(String.format("%x %x",Integer
					 * .parseInt(splits[i],16), checkSum));
					 */
				}
			}
		}

		System.out.printf("%s %d %s %04x", "Case ", index, " : Checksum = ",
				checkSum);
		System.out.println();
		System.out.println("SYMBOL\tADDRESS");
		System.out.println("--------\t----");
		for (String key : symbols.keySet()) {
			String val = symbols.get(key);
			boolean multiple = false;
			if (val.endsWith("M")) {
				val = val.replaceAll(" M", "");
				multiple = true;
			}
			if (multiple) {
				System.out.printf("%s \t %x %c", key, Integer.parseInt(val),
						'M');
				System.out.println();
			} else {
				System.out.printf("%s \t %x", key, Integer.parseInt(val));
				System.out.println();
			}
		}
		for (String s : refs) {
			//Only print unresolved references
			if (!symbols.containsKey(s))
				System.out.println(s + "\t????");
		}
		System.out.println();
	}

}
