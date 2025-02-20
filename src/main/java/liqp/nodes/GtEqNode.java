package liqp.nodes;

import liqp.TemplateContext;
import liqp.exceptions.IncompatibleTypeComparisonException;

public class GtEqNode extends ComparingExpressionNode {

    public GtEqNode(LNode lhs, LNode rhs) {
        super(lhs, rhs, true);
    }

    @SuppressWarnings("unchecked")
    @Override
    Object doCompare(Object a, Object b, boolean strictTypedExpressions) {
        if (a instanceof Comparable && a.getClass().isInstance(b)) {
            return ((Comparable<Object>) a).compareTo(b) >= 0;
        } else if (b instanceof Comparable && b.getClass().isInstance(a)) {
            return ((Comparable<Object>) b).compareTo(a) < 0;
        }

        if (strictTypedExpressions) {
            throw new IncompatibleTypeComparisonException(a, b);
        }
        return false;
    }

    @Override
    public void accept(TemplateContext context, LNodeVisitor visitor) {
        if (rhs != null) {
            rhs.accept(context, visitor);
        }
        if (lhs != null) {
            lhs.accept(context, visitor);
        }
        visitor.visit(context, this);
    }
}
