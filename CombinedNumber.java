import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class CombinedNumber {

    /*
     * Accept array of ints and return the highest possible value
     * in string format
     * 
     * @param input array of integers to combine 
     * @throws IllegalArgumentException
     */ 
    public static String answer(int[] input) {
        
        //@see https://stackoverflow.com/questions/880581/how-to-convert-int-to-integer-in-java
        Integer[] output = IntStream.of(input).boxed().toArray( Integer[]::new );
        
        for (int i=0; i<input.length; i++) {
            if (input[i] < 0) {
                   throw new IllegalArgumentException();
            }
        }

        Arrays.sort(output, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                String strA = String.valueOf(a);
                char[] chrA = strA.toCharArray();

                String strB = String.valueOf(b);
                char[] chrB = strB.toCharArray();

                int normalizedA = a;
                int normalizedB = b;
                
                if (chrA.length < chrB.length) {
                    char[] tmpCharA = new char[chrB.length];
                    for (int i=0; i<chrB.length; i++) {
                        if (i >= chrA.length) {
                            tmpCharA[i] = chrA[0];
                        } else {
                            tmpCharA[i] = chrA[i];
                        }
                    }
                                        
                    normalizedA = Integer.parseInt(new String(tmpCharA));
                }
                
                if (chrB.length < chrA.length) {
                    char[] tmpCharB = new char[chrA.length];
                    for (int i=0; i<chrA.length; i++) {
                        if (i >= chrB.length) {
                            tmpCharB[i] = chrB[0];
                        } else {
                            tmpCharB[i] = chrB[i];
                        }
                    }
                    
                    normalizedB = Integer.parseInt(new String(tmpCharB));
                }
               
                
                if ((char) normalizedA < (char) normalizedB) {
                    return 1;
                }
                
                if ((char) normalizedA > (char) normalizedB) {
                    return -1;
                }

              
                return 0;
            }
        });
        
        String[] temp = new String[output.length];
        for (int i=0; i<output.length; i++) {
            temp[i] = String.valueOf(output[i]);
        }
        
        return String.join("", temp);
    }

    /*
     * Handle invalid inputs
     *
     * @param input some invalid input
     * @throws IllegalArgumentException
     */
    public static <T> T answer(T[] input) {
        throw new IllegalArgumentException();
    }
     
    /*
     * Handle invalid inputs
     *
     * @param input some invalid input
     * @throws IllegalArgumentException
     */
    public static <T> T answer(T input) {
        throw new IllegalArgumentException();
    } 
}
