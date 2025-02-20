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
