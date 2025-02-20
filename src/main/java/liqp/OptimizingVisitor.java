package liqp;

import liqp.nodes.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import static liqp.LValue.isBlank;

public class OptimizingVisitor implements LNodeVisitor {
    @Override
    public void visit(TemplateContext context, BlockNode blockNode) {

    }

    @Override
    public void visit(TemplateContext context, AttributeNode attributeNode) {

    }

    @Override
    public void visit(TemplateContext context, InsertionNode insertionNode) {

    }

    @Override
    public void visit(TemplateContext context, OutputNode outputNode) {
        Object value;
        try {
            value = outputNode.getExpression().render(context);
        } catch (RuntimeException e) {
            return;
        }
        String localUnparsed = outputNode.getUnparsed();
        if (!isBlank(localUnparsed)) {
            // Will not try to optimize if it cannot be fully parsed
            return;
        }

        for (FilterNode node : outputNode.getFilters()) {
            value = node.apply(value, context);
        }

        if (value instanceof BigDecimal && !(value instanceof PlainBigDecimal)) {
            value = new PlainBigDecimal(value.toString());
        }
        outputNode.setExpression(new AtomNode(value));
        outputNode.setFilters(new ArrayList<>());
    }

    @Override
    public void visit(TemplateContext context, FilterNode filterNode) {

    }

    @Override
    public void visit(TemplateContext context, ContainsNode containsNode) {

    }

    @Override
    public void visit(TemplateContext context, GtEqNode gtEqNode) {

    }

    @Override
    public void visit(TemplateContext context, KeyValueNode keyValueNode) {

    }

    @Override
    public void visit(TemplateContext context, NEqNode nEqNode) {

    }

    @Override
    public void visit(TemplateContext context, LtNode ltNode) {

    }

    @Override
    public void visit(TemplateContext context, EqNode eqNode) {

    }

    @Override
    public void visit(TemplateContext context, GtNode gtNode) {

    }

    @Override
    public void visit(TemplateContext context, OrNode orNode) {

    }

    @Override
    public void visit(TemplateContext context, AndNode andNode) {

    }

    @Override
    public void visit(TemplateContext context, LookupNode lookupNode) {

    }

    @Override
    public void visit(TemplateContext context, AtomNode atomNode) {

    }

    @Override
    public void visit(TemplateContext context, LtEqNode ltEqNode) {

    }
}
