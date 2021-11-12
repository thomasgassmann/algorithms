package com.thomasgassmann.datastructures;

import java.util.HashMap;

// for all vertices v in tree: bal(v) in {-1, 0, 1}
public class AVLTree {
    private AVLTreeNode _root;
    private HashMap<AVLTreeNode, Integer> _balances = new HashMap<>();

    public boolean contains(int key) {
        AVLTreeNode current = _root;
        while (current != null) {
            if (current.key == key) {
                return true;
            } else if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        return false;
    }

    public AVLTreeNode getRoot() {
        return _root;
    }

    public void insert(int key) {
        if (_root == null) {
            _root = new AVLTreeNode(key, null, null, null);
            setBalance(_root, 0);
            return;
        }

        AVLTreeNode v = _root;
        AVLTreeNode u = null;
        while (v != null) {
            u = v;
            if (key > v.key) {
                v = v.right;
            } else if (key < v.key) {
                v = v.left;
            } else {
                return;
            }
        }

        AVLTreeNode r = new AVLTreeNode(key, u,null, null);
        setBalance(r, 0);
        if (u.key < r.key) {
            u.right = r;
        } else {
            u.left = r;
        }

        if (getBalance(u) == 0) {
            setBalance(u, u.left == r ? -1 : 1);
            if (u.parent != null) {
                upin(u);
            }
        } else {
            // either -1 or 1
            setBalance(u, 0);
            // tree height didn't change, we're done
        }
    }

    private void rightrotate(AVLTreeNode w) {
        AVLTreeNode u = w.left;
        if (w.parent != null) {
            if (w.parent.right == w) {
                w.parent.right = u;
            } else {
                w.parent.left = u;
            }
        } else {
            _root = u;
        }

        u.parent = w.parent;
        w.parent = u;
        w.left = u.right;
        u.right = w;
    }

    private void leftrotate(AVLTreeNode w) {
        AVLTreeNode u = w.right;
        if (w.parent != null) {
            if (w.parent.right == w) {
                w.parent.right = u;
            } else {
                w.parent.left = u;
            }
        } else {
            _root = u;
        }

        u.parent = w.parent;
        w.parent = u;
        w.right = u.left;
        u.left = w;
    }

    private int getBalance(AVLTreeNode node) {
        return _balances.get(node);
    }

    private void setBalance(AVLTreeNode node, int value) {
        _balances.put(node, value);
    }

    private void upin(AVLTreeNode u) {
        AVLTreeNode w = u.parent;
        if (getBalance(w) == 0) {
            setBalance(w, w.left == u ? -1 : 1);
            if (w.parent != null)
                upin(w);
            return;
        }

        if ((getBalance(w) == 1 && w.left == u) ||
            (getBalance(w) == -1 && w.right == u)) {
            setBalance(w, 0);
            return;
        }

        // we now either have bal(w) == 1 or bal(w) == -1
        // since by our invariant bal(u) != 0, we need to rebalance
        // the tree somehow
        if (getBalance(w) == -1) {
            // bal(w) == -1
            if (getBalance(u) == -1) {
                // new key is in left part
                // right rotation around w (u is new root, w right of u)
                rightrotate(w);
            } else {
                // bal(u) == 1
                leftrotate(u);
                rightrotate(w);
            }
        } else {
            // bal(w) == 1
            if (getBalance(u) == -1) {
                // new key is in left part
                rightrotate(u);
                leftrotate(w);
            } else {
                // new key is in right part
                // left rotation around w (u is new root, w left of u)
                leftrotate(w);
            }
        }
    }
}
