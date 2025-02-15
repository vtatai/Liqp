package liqp.nodes;

import liqp.LValue;
import liqp.TemplateContext;

public class OrNode extends LValue implements LNode {

    private LNode lhs;
    private LNode rhs;

    public OrNode(LNode lhs, LNode rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public Object render(TemplateContext context) {

        return super.asBoolean(lhs.render(context)) || super.asBoolean(rhs.render(context));

    }

    @Override
    public Object accept(TemplateContext context, LNodeVisitor visitor) {
        return visitor.visit(context, this);
    }
}
