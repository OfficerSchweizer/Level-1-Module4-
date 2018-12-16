
public class test {

	static void wholeNumber(double input) {
		int a = (int) input;
		System.out.println(a);
		for (int i = 0; i < 100000 ; i++) {
			if (input % i == i) {
				System.out.println(i-1);
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		wholeNumber(7.4);
	}
}
