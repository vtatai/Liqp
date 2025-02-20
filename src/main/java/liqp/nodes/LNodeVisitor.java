package liqp.nodes;

import liqp.TemplateContext;

public interface LNodeVisitor {
    void visit(TemplateContext context, BlockNode blockNode);

    void visit(TemplateContext context, AttributeNode attributeNode);

    void visit(TemplateContext context, InsertionNode insertionNode);

    void visit(TemplateContext context, OutputNode outputNode);

    void visit(TemplateContext context, FilterNode filterNode);

    void visit(TemplateContext context, ContainsNode containsNode);

    void visit(TemplateContext context, GtEqNode gtEqNode);

    void visit(TemplateContext context, KeyValueNode keyValueNode);

    void visit(TemplateContext context, NEqNode nEqNode);

    void visit(TemplateContext context, LtNode ltNode);

    void visit(TemplateContext context, EqNode eqNode);

    void visit(TemplateContext context, GtNode gtNode);

    void visit(TemplateContext context, OrNode orNode);

    void visit(TemplateContext context, AndNode andNode);

    void visit(TemplateContext context, LookupNode lookupNode);

    void visit(TemplateContext context, AtomNode atomNode);

    void visit(TemplateContext context, LtEqNode ltEqNode);
}
