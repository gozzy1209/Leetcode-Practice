package Graphs;
//133 clone graph

import java.security.cert.TrustAnchor;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class CloneGraph {
    
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        //如果当前node是空的，就是没有neighbors，直接返回null
        if(node==null){
            return null;
        }
        Map<Node,Node>map=new HashMap<>();
        return clone_dfs(node,map);
    }
    private Node clone_dfs(Node node,Map<Node,Node> map) {
        //如果已经map的映射表已经有当前节点了，那就不用在clone当前结点了
        if(map.containsKey(node)){
            return map.get(node);
        }
        //如果没有当前结点，那就map put当前结点
        map.put(node, new Node(node.val));
        //创建当前结点的clone结点
        Node clone=map.get(node);
        //然后把当前结点的neighbor关系也复制到当前clone结点的neighbor关系
        for(Node nei:node.neighbors){
            clone.neighbors.add(clone_dfs(nei,map));
        }
        //最后返回当前结点的clone结点（不仅复制了值，还复制了neighbor关系
        return clone;
    }
}