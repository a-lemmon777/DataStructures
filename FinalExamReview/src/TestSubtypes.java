
public class TestSubtypes {

	public static void main(String[] args) {
		A a1 = new B();
		A a2 = new C();
		
		a1.m(); // in B
		a2.m(); // in C
		
		// a1.mmm(); This needs to be commented out to compile
		((B) a1).mmm(); // in B
		((B) a2).mmm(); // in C (method is chosen at runtime I think)
		((C) a2).mmm(); // in C
		// ((C) a1).mmm(); // ClassCastException thrown B cannot be cast to C
	}

}
