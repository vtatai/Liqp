package liqp.nodes;

import liqp.TemplateContext;

public class AttributeNode implements LNode {

    private LNode key;
    private LNode value;

    public AttributeNode(LNode key, LNode value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Object render(TemplateContext context) {

        return new Object[]{
                key.render(context),
                value.render(context)
        };
    }

    @Override
    public void accept(TemplateContext context, LNodeVisitor visitor) {
        if (key != null) {
            key.accept(context, visitor);
        }
        if (value != null) {
            value.accept(context, visitor);
        }
        visitor.visit(context, this);
    }
}
