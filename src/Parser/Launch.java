package Parser;

import Parser.MyVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class Launch {

    public static void main(String[] args){

        try {
            String source = "test.txt";
            CharStream cs = fromFileName(source);
            gLexer Lexer = new gLexer(cs);
            CommonTokenStream token = new CommonTokenStream(Lexer);
            gParser parser = new gParser(token);
            ParseTree tree = parser.program();

            MyVisitor visitor = new MyVisitor();
            visitor.visit(tree);

        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
