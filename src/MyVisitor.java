import Parser.gParser;
import Parser.gBaseVisitor;

import javax.swing.text.html.parser.Parser;

public class MyVisitor extends gBaseVisitor<Object> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitType(gParser.TypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStatement(gParser.StatementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSimple_statement(gParser.Simple_statementContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimary_expression(gParser.Primary_expressionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr(gParser.ExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitTerm(gParser.TermContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitFactor(gParser.FactorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimary(gParser.PrimaryContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpression(gParser.ExpressionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIgual(gParser.IgualContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMayor(gParser.MayorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMenor(gParser.MenorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDiferente(gParser.DiferenteContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAnd(gParser.AndContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitOr(gParser.OrContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitLogical_condition(gParser.Logical_conditionContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSi(gParser.SiContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSino(gParser.SinoContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public Object visitIf_statement(gParser.If_statementContext ctx) {
        System.out.println("Procesando sentencia si:");

        // Procesar la condición del si
        System.out.println("si (" + visitLogical_condition(ctx.logical_condition()) + ") {");

        // Procesar el bloque del si
        System.out.println("    // Inicio del bloque del si");
        visitBlock(ctx.block(0)); // Bloque del si
        System.out.println("    // Fin del bloque del si");

        // Procesar el bloque del sino, si existe
        if (ctx.sino() != null) {
            System.out.println("} sino {");
            System.out.println("    // Inicio del bloque del sino");
            visitBlock(ctx.block(1)); // Bloque del sino
            System.out.println("    // Fin del bloque del sino");
        }

        System.out.println("}");

        return null;
    }
    @Override public Object visitStatement_list(gParser.Statement_listContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitProgram(gParser.ProgramContext ctx) { return visitChildren(ctx); }

    @Override public Object visitWhile_loop(gParser.While_loopContext ctx) {
        System.out.println("Procesando ciclo mientras:");

        // Procesar la expresión del ciclo mientras
        System.out.println("mientras (" + visitExpression(ctx.expression()) + ") {");

        // Procesar el bloque del ciclo mientras
        System.out.println("    // Inicio del bloque del ciclo mientras");
        visitBlock(ctx.block());
        System.out.println("    // Fin del bloque del ciclo mientras");

        System.out.println("}");

        return null;
    }

    // Implementa otros métodos visit para los nodos restantes según sea necesario
    @Override public Object visitBlock(gParser.BlockContext ctx) {
        // Implementa lógica para visitar el bloque aquí
        return visitChildren(ctx);
    }
    // ...

    public static void main(String[] args) {
        // Puedes crear una instancia del parser y del visitor aquí y probar el procesamiento
    }
}

