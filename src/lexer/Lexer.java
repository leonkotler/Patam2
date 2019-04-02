package lexer;


public class Lexer {

    private boolean inTheMiddleOfAWhileLoop;
    private StringBuilder whileBlock;

    public Lexer() {
        this.whileBlock = new StringBuilder();
    }

    public String[] processLine(String line) {
        if (inTheMiddleOfAWhileLoop) {
            // we are in a while loop block
            whileBlock.append(line).append(" \n ");

            if (line.endsWith("}")){
                // end of a while loop
                inTheMiddleOfAWhileLoop = false;
                String[] whileBlockAsStringArray = whileBlockAsStringArray();

                // allocate a new
                whileBlock = new StringBuilder();
                return whileBlockAsStringArray;
            }
        } else if (line.startsWith("while")) {
            // start of a new while block
            inTheMiddleOfAWhileLoop = true;
            whileBlock.append(line).append(" \n ");
        }

        // regular line
        return line.split(" ");
    }

    private String[] whileBlockAsStringArray() {
        return whileBlock.toString().split(" ");
    }

}
