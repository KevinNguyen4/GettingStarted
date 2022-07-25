import java.util.*;

public class loopPractice {

	public static void main(String args[]) {

//Put in hashtable, as youre going thru, check containsKey on that letter
		//YEEEHAW
		//yeeeeclaw

		int[] arr = new int[] {1};

		System.out.println("isUniqueWith: " + isUnique("botasdfy"));// correct
		System.out.println("isUniqueWithout: " + isUniqueWithout("boxtasdy"));// corect
		System.out.println("checkPermutation: " + checkPermutation("ddoffg", "gdffod"));// cirect
		System.out.println("palindromePermutation: " + palindromePermutation("ybebea"));// i think ciret
		System.out.println("one waway: " + oneAway("butt", "burt"));// corec!
		System.out.println("string Compression " + stringCompression("aabccccccccccd"));
		System.out.println("bainry search " + binarySearch(arr, 1));
	}

	class LinkedList {
		Node head;

		class Node {
			int data;
			Node next;

			Node(int datain) {
				datain = data;
			}
		}
	}

	// we binary searching
	public static int binarySearch(int[] arr, int target) {

		int low = 0;
		int high = arr.length;
		int mid;

		while (low < high) {
			mid = low + (high - low) / 2;
			if (target == arr[mid]) {
				return mid;
			} else if (target > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}

		}
		return -1;
	}

	void removeDups(LinkedList head) {

		// go thru link list, check data if its in hashset, if not then put it in there,
		// if is then remove it by making its previous point to next

	}

	void kthtoLast(LinkedList n, int data) {

	}

	// go thru the linked list, putting it in hashmap, if its already there, remove
	// it.

	static boolean isUnique(String s) {

		Hashtable<Integer, Character> yes = new Hashtable<Integer, Character>();

		for (int i = 0; i < s.length(); i++) {

			if (yes.containsValue(s.charAt(i))) {
				return false;
			}
			yes.put(i, s.charAt(i));
		}
		return true;
	}

	// BF = do another loop and see if they match up
	// opt: we sort it, then we see if i is same as i+1
	static boolean isUniqueWithout(String s) {

		char arr[] = s.toCharArray();
		Arrays.sort(arr);

		for (int i = 0; i < s.length() - 1; i++) {

			if (arr[i] == arr[i + 1]) {
				return false;
			}

		}

		return true;
	}

	// could do nlogn, sort both and compare
	// need to compare letters and number of letters
	static boolean checkPermutation(String s, String s2) {

		Hashtable<Character, Integer> yes = new Hashtable<Character, Integer>();
		Hashtable<Character, Integer> yes2 = new Hashtable<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {

			if (yes.containsKey(s.charAt(i))) {
				yes.put(s.charAt(i), yes.get(s.charAt(i)) + 1);
			} else {
				yes.put(s.charAt(i), 1);
			}

		}

		System.out.println(yes);
		for (int i = 0; i < s2.length(); i++) {

			if (yes2.containsKey(s2.charAt(i))) {
				yes2.put(s2.charAt(i), yes2.get(s2.charAt(i)) + 1);
			} else {
				yes2.put(s2.charAt(i), 1);
			}

		}
		System.out.println(yes2);
		if (yes.equals(yes2)) {
			return true;
		}

		// character, how many times it appears?
		// check if containsKey, if so, increment value+1
		// compare the two tables

		return false;
	}

	// go thru it, if we see space, then move all things after it 2 back, replace i
	// with %, i+1 with 2, i+2 with 0,
	// go thru it once and count where the spaces are, then if ur number is after
	// that space nah
	static char[] URLify(char[] s, int length) {

		char at;
		for (int i = 0; i < s.length; i++) {
			at = s[i];
			if (at == (' ')) {
				for (int j = s.length; j > i; j--) {
					s[j] = s[j + 2];
				}
				s[i] = '%';
				s[i + 1] = '2';
				s[i + 2] = '0';
			}

		}

		System.out.println(s);
		return s;
	}

	// go thru the string, put it in hashmap, at the end, check if doesnt contain
	// value2
	// BF: go thru, if each letter has an even number of repititions, good, only one
	// can have odd, we're O(n)
	static boolean palindromePermutation(String s) {

		int oddCounter = 0;
		Hashtable<Character, Integer> yes = new Hashtable<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {

			if (yes.containsKey(s.charAt(i))) {
				yes.put(s.charAt(i), yes.get(s.charAt(i)) + 1);
			} else {
				yes.put(s.charAt(i), 1);

			}

		}

		// System.out.println(yes.values());
		Object[] yes2 = yes.values().toArray();
		for (int i = 0; i < yes2.length; i++) {
			if ((int) yes2[i] % 2 == 1) {

				oddCounter++;
				// System.out.println(oddCounter);
			}
		}
		if (s.length() % 2 == 1) {
			if (oddCounter >= 2) {
				// System.out.println("here");
				return false;
			}
		} else {
			if (oddCounter >= 1) {
				// System.out.println("here2");
				return false;
			}
		}

		return true;

	}

	static boolean oneAway(String s1, String s2) {

		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		boolean found = false;

		// insertion
		if (a1.length + 1 == a2.length) {

			for (int i = 0; i < a1.length; i++) {

//				System.out.println("insertion " + a1[i]);
//				System.out.println("insertion " + a2[i]);

				if (found == false) {
					if (a1[i] != a2[i]) {
						found = true;
						// what if we do spot found, then make it so a2[i] maps to a1[i+1]
					}
				} else {

					if (a1[i - 1] != a2[i]) {
						return false;

					}
				}
			}
			return true;
		}

		// deletion
		if (a1.length == a2.length + 1) {
			for (int i = 0; i < a2.length; i++) {

//				System.out.println("deletion " + a1[i]);
//				System.out.println("deletion " + a2[i]);

				if (found == false) {
					if (a1[i] != a2[i]) {
						found = true;
						// what if we do spot found, then make it so a2[i] maps to a1[i+1]
					}
				} else {

					if (a2[i - 1] != a1[i]) {
						return false;

					}
				}
			}
			return true;
		}

		// now we do replacement
		if (a1.length == a2.length) {
			for (int i = 0; i < a1.length; i++) {

//				System.out.println("replace " + a1[i]);
//				System.out.println("reaplace " + a2[i]);

				if (found == false) {
					if (a1[i] != a2[i]) {
						found = true;
						// what if we do spot found,
					}
				} else {

					if (a2[i] != a1[i]) {
						return false;

					}
				}
			}
			return true;
		}

		// deletion: stirng to array, compare?, if s1[1] != s2[1] then s2[1] = s2[2] and
		// keep going
		// insertion: string to arraay, compare?, if s1[1] != s2[1] then s1[1] = s1[2]
		// and keep going
		// replace: same really

		return false;
	}

	static String stringCompression(String s) {

		// to array? then we go thru and see if i = i+1
		int count = 1;
		String returned = "";

		char[] a = s.toCharArray();

		for (int i = 0; i < a.length; i++) {

			if (i == a.length - 1) {
				if (a[i] == a[i - 1]) {
					returned += a[i];
					returned += count;
					if (returned.length() > s.length()) {
						return s;
					}
					return returned;

				} else

					returned += a[i];
				count = 1;
				returned += count;
				if (returned.length() > s.length()) {
					return s;
				}
				return returned;

			}

			else if (a[i] == a[i + 1]) {
				count++;
			} else {

				// when nmove onto enxt letter

				returned += a[i];
				returned += count;
				count = 1;
			}

		}
		if (returned.length() > s.length()) {
			return s;
		}
		return returned;
	}

}
