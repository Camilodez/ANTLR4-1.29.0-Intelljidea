public class MyVisitor extends gBaseVisitor<Object>{

    @Override public Object visitProg(gParser.ProgContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr(gParser.ExprContext ctx) { return visitChildren(ctx); }
}
