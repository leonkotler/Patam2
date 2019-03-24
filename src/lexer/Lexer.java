package lexer;

import java.util.Arrays;
import java.util.List;

public class Lexer {

    private boolean blockBegan;
    private List<String[]> block;

    public String[] processLine(String line) {

        if (blockBegan){
            block.add(line.split(" "));

            if (line.endsWith("}")){
                blockBegan = false;
                return Arrays.to
            }
        }

        if (line.endsWith("{")){
            return handleBlock()
        }

        return line.split(" ");
    }
}
