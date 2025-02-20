package liqp.nodes;

import liqp.PlainBigDecimal;
import liqp.TemplateContext;
import liqp.TemplateParser;
import liqp.exceptions.LiquidException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static liqp.LValue.isBlank;

public class OutputNode implements LNode {

    private LNode expression;
    private String unparsed;
    private Integer unparsedline;
    private Integer unparsedPosition;
    private List<FilterNode> filters;

    public OutputNode(LNode expression, String unparsed, Integer unparsedline, Integer unparsedPosition) {
        this.expression = expression;
        this.unparsed = unparsed;
        this.unparsedline = unparsedline;
        this.unparsedPosition = unparsedPosition;
        this.filters = new ArrayList<>();
    }

    public void addFilter(FilterNode filter) {
        filters.add(filter);
    }

    @Override
    public Object render(TemplateContext context) {

        Object value = expression.render(context);

        for (FilterNode node : filters) {
            value = node.apply(value, context);
        }
        if (context != null && context.getParser().errorMode == TemplateParser.ErrorMode.WARN) {
            String localUnparsed = unparsed;
            if (!isBlank(localUnparsed)) {
                if (localUnparsed.length() > 30) {
                    localUnparsed = localUnparsed.substring(0, 30) + "...";
                }
                 if (unparsedline == null) {
                     unparsedline = -1;
                 }
                 if (unparsedPosition == null) {
                     unparsedPosition = -1;
                 }
                context.addError(new LiquidException("unexpected output: " + localUnparsed, unparsedline, unparsedPosition, null));
            }
        }

        if (value instanceof BigDecimal && !(value instanceof PlainBigDecimal)) {
            value = new PlainBigDecimal(value.toString());
        }

        return value;
    }

    @Override
    public void accept(TemplateContext context, LNodeVisitor visitor) {
        if (expression != null) {
            expression.accept(context, visitor);
        }
        filters.forEach(f -> f.accept(context, visitor));
        visitor.visit(context, this);
    }

    public LNode getExpression() {
        return expression;
    }

    public String getUnparsed() {
        return unparsed;
    }

    public Integer getUnparsedline() {
        return unparsedline;
    }

    public Integer getUnparsedPosition() {
        return unparsedPosition;
    }

    public List<FilterNode> getFilters() {
        return filters;
    }

    public void setExpression(LNode expression) {
        this.expression = expression;
    }

    public void setFilters(List<FilterNode> filters) {
        this.filters = filters;
    }
}
