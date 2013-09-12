package cse;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import cse.exception.InvalidNICException;

@Test
public class ExtractorTest {
    private Extractor ex;

    @BeforeClass
    public void setUp() {
        ex = new Extractor();
    }
    @Test
    public void createPropTest() {
        Interpreter prop=ex.createInterpreter("913261810V");
        assertEquals(prop.getID(),"913261810V");
    }
    @Test(expectedExceptions = InvalidNICException.class)
	public void validateChar() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("9132s1810G");
                ex.validate(prop);
	}
    @Test(expectedExceptions = InvalidNICException.class)
	public void validateNumOfChars() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("9132618100123V");	 
                ex.validate(prop);
	}
    @Test(expectedExceptions = InvalidNICException.class)
	public void validateLastChar() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("913261810G");
                ex.validate(prop);
	}
    @Test(expectedExceptions = InvalidNICException.class)
	public void validateDate1() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("914001810G");
                ex.validate(prop);
	}
    @Test(expectedExceptions = InvalidNICException.class)
	public void validateDate2() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("880601810G");
                ex.validate(prop);
	}
    @Test
	public void calculate1() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("913261810V");
                String[] res = ex.calculator(prop);
                assertEquals(res[0],"1991");
                assertEquals(res[1],"11");
                assertEquals(res[2],"21");
                assertEquals(res[3],"MALE");
                assertEquals(res[4],"true");
	}
    @Test
	public void calculate2() throws InvalidNICException {
		Interpreter prop = ex.createInterpreter("885611810X");
                String[] res = ex.calculator(prop);
                assertEquals(res[0],"1988");
                assertEquals(res[1],"3");
                assertEquals(res[2],"1");
                assertEquals(res[3],"FEMALE");
                assertEquals(res[4],"false");
	}

    






}