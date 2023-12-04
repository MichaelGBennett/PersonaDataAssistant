package com.bennett.util;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> links;

    public Node(){
        this.links = new ArrayList<Node>();
    }

    public ArrayList<Node> getLinks(){
        return links;
    }

    public void addLink(Node n){
        this.links.add(n);
        n.getLinks().add(this);
    }

    public boolean removeLink(Node n){
        boolean success = this.links.remove(n);
        n.getLinks().remove(this);
        return success;
    }
}
