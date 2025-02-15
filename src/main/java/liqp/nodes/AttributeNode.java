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
    public Object accept(TemplateContext context, LNodeVisitor visitor) {
        return visitor.visit(context, this);
    }
}
