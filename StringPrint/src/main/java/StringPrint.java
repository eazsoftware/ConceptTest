
/**
 *
 * @author JIVL
 */
public class StringPrint {

    public static void main(String[] args) {

        try {
            System.out.printf("%-12s%-12s%s\n", "Column 1", "Column 2", "Column3");
            System.out.printf("%-12d%-12d%07d\n", 15, 12, 5);

            for (int j = 0; j < 20; j++) {
                System.out.println("[" + j + "]" + String.format("%02d", j));
            }
                        
            System.out.println(String.format("%-12.5f%.20f", 12.23429837482,9.10212023134));            
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

}
