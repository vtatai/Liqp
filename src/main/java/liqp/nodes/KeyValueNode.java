package liqp.nodes;

import liqp.TemplateContext;

import java.util.HashMap;
import java.util.Map;

public class KeyValueNode implements LNode {

    public final String key;
    public final LNode value;

    public KeyValueNode(String key, LNode value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Object render(TemplateContext context) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key, value.render(context));
        return map;
    }

    @Override
    public Object accept(TemplateContext context, LNodeVisitor visitor) {
        return visitor.visit(context, this);
    }
}
