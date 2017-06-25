import org.junit.*;
import static org.junit.Assert.*;

public class CombinedNumberTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void non_negative() {
        int[] input = {-1};
        String answer = CombinedNumber.answer(input);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void string() {
        String[] input = {"one"};
        String answer = CombinedNumber.answer(input);
    }

    @Test
    public void example1() {
        int[] input = {50,2,1,9};
        String answer = CombinedNumber.answer(input);
        String valid = "95021";
        
        assertEquals(valid, answer);    
    }
       
    @Test
    public void example2() {
        int[] input = {5,50,56};

        assertEquals("56550", CombinedNumber.answer(input));   
    }
    
    @Test
    public void example3() {
        int[] input = {420,42,423};
        
        //System.out.println(CombinedNumber.answer(input));

        assertEquals(CombinedNumber.answer(input), "42423420");   
    }
    
    @Test
    public void nines() {
        int[] input = {92,93,94,95,99};
        
        assertEquals(CombinedNumber.answer(input), "9995949392");
    }
    
    @Test
    public void zeroes() {
        int[] input = {0,0,0,0,0};
        
        assertEquals(CombinedNumber.answer(input), "00000");
    }
    
}

