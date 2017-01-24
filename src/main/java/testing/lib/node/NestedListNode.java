package testing.lib.node;

import java.util.LinkedList;

/**
 * Created by yun.li on 1/17/17.
 */
public class NestedListNode extends LinkedList<NestedListNode> {
    private String value = "";

    public NestedListNode(String value) {
        this.value = value;
    }

    public String getValue() { return this.value; }
}