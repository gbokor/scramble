import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class ScrambleTest {

	@Test
	public void test_Punctuation() {
		Scramble test = new Scramble();
		
		String result1 = test.textScramble(":");
		String result2 = test.textScramble("...");
		String result3 = test.textScramble("test:");
		String result4 = test.textScramble("test? test: another, test!");
		
		assertEquals(": ", result1);
		assertEquals("... ", result2);
		assertEquals("tset: ", result3);
		assertEquals("tset? tset: aehtonr, tset! ", result4);
	}
	
	@Test
	public void test_Apostrophe() {
		Scramble test = new Scramble();
		
		String result1 = test.textScramble("'");
		String result2 = test.textScramble("'t");
		String result3 = test.textScramble("you're");
		String result4 = test.textScramble("don't");
		String result5 = test.textScramble("doesn't");
		String result6 = test.textScramble("It doesn't Matter");

		
		assertEquals("' ", result1);
		assertEquals("'t ", result2);
		assertEquals("you're ", result3);
		assertEquals("don't ", result4);
		assertEquals("dseon't ", result5);
		assertEquals("It dseon't Mettar ", result6);
	}
	
	@Test
	public void test_NormalText() {
		Scramble test = new Scramble();
		
		String result1 = test.textScramble("a");
		String result2 = test.textScramble("ab");
		String result3 = test.textScramble("abc");
		String result4 = test.textScramble("test");
		String result5 = test.textScramble("test another test and another test");
		
		assertEquals("a ", result1);
		assertEquals("ab ", result2);
		assertEquals("abc ", result3);
		assertEquals("tset ", result4);
		assertEquals("tset aehtonr tset and aehtonr tset ", result5);
	}
	
	@Test
	public void test_ComplexText() {
		Scramble test = new Scramble();
		
		String result1 = test.textScramble("All letters up to that year are printed intact, "
				+ "for it is legitimate to be interested in the degree of skill the child showed "
				+ "in writing, even to details of punctuation; so it is well "
				+ "to preserve a literal integrity of reproduction.");
		
		assertEquals("All lrettes up to taht yaer are petnird icatnt, "
				+ "for it is ltamitigee to be ietseretnd in the dergee of slikl the clihd sewohd "
				+ "in wnitirg, eevn to dliates of poitautcnun; so it is wlel "
				+ "to pvresere a laretil itirgetny of roitcudorpen. ", result1);
	}
}
