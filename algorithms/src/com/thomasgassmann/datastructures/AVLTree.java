package com.thomasgassmann.datastructures;

import java.util.HashMap;

// for all vertices v in tree: bal(v) in {-1, 0, 1}
public class AVLTree {
    private AVLTreeNode _root;
    private HashMap<AVLTreeNode, Integer> _balances = new HashMap<AVLTreeNode, Integer>();

    public void insert(int key) {
        if (_root == null) {
            _root = new AVLTreeNode(key, null, null, null);
            _balances.put(_root, 0);
            return;
        }

        AVLTreeNode v = _root;
        AVLTreeNode prev = null;
        while (v != null) {
            prev = v;
            if (key > v.key) {
                v = v.right;
            } else if (key < v.key) {
                v = v.left;
            } else {
                return;
            }
        }

        AVLTreeNode newNode = new AVLTreeNode(key, prev,null, null);
        if (prev.key < newNode.key) {
            prev.right = newNode;
        } else {
            prev.left = newNode;
        }

        int currentBalance = _balances.get(prev);
        _balances.put(newNode, 0);
        if (currentBalance == 0) {
            _balances.put(prev, prev.left == newNode ? -1 : 1);
            if (prev.parent != null) {
                upin(prev);
            }
        } else {
            // either -1 or 1
            _balances.put(prev, 0);
            // tree height didn't change, we're done
            return;
        }
    }

    private void upin(AVLTreeNode u) {
        AVLTreeNode w = u.parent;
        if (_balances.get(w) == 0) {
            
        }
    }
}
