package liqp.nodes;

import liqp.TemplateContext;

public interface LNodeVisitor {
    Object visit(TemplateContext context, BlockNode blockNode);

    Object visit(TemplateContext context, AttributeNode attributeNode);

    Object visit(TemplateContext context, InsertionNode insertionNode);

    Object visit(TemplateContext context, OutputNode outputNode);

    Object visit(TemplateContext context, FilterNode filterNode);

    Object visit(TemplateContext context, ContainsNode containsNode);

    Object visit(TemplateContext context, GtEqNode gtEqNode);

    Object visit(TemplateContext context, KeyValueNode keyValueNode);

    Object visit(TemplateContext context, NEqNode nEqNode);

    Object visit(TemplateContext context, LtNode ltNode);

    Object visit(TemplateContext context, EqNode eqNode);

    Object visit(TemplateContext context, GtNode gtNode);

    Object visit(TemplateContext context, OrNode orNode);

    Object visit(TemplateContext context, AndNode andNode);

    Object visit(TemplateContext context, LookupNode lookupNode);

    Object visit(TemplateContext context, AtomNode atomNode);

    Object visit(TemplateContext context, LtEqNode ltEqNode);
}
