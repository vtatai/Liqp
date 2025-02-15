package liqp.nodes;

import liqp.LValue;
import liqp.TemplateContext;

public class AndNode extends LValue implements LNode {

    private LNode lhs;
    private LNode rhs;

    public AndNode(LNode lhs, LNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Object render(TemplateContext context) {

        return super.asBoolean(lhs.render(context)) && super.asBoolean(rhs.render(context));

    }

    @Override
    public Object accept(TemplateContext context, LNodeVisitor visitor) {
        Object tmp = lhs.accept(context, visitor);
        if (tmp instanceof LNode) {
            lhs = (LNode) tmp;
        }
        tmp = rhs.accept(context, visitor);
        if (tmp instanceof LNode) {
            rhs = (LNode) tmp;
        }
        return visitor.visit(context, this);
    }
}
