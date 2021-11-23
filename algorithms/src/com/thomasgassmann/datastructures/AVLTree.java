package com.thomasgassmann.datastructures;

// for all vertices v in tree: bal(v) in {-1, 0, 1}
public class AVLTree {
    private AVLTreeNode _root;

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
            _root.balance = 0;
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
        r.balance = 0;
        if (u.key < r.key) {
            u.right = r;
        } else {
            u.left = r;
        }

        if (u.balance == 0) {
            u.balance = u.left == r ? -1 : 1;
            if (u.parent != null) {
                upin(u);
            }
        } else {
            // either -1 or 1
            u.balance = 0;
            // tree height didn't change, we're done
        }
    }

    private void rightrotate(AVLTreeNode v) {
        AVLTreeNode u = v.left;
        if (v.parent != null) {
            if (v.parent.right == v) {
                v.parent.right = u;
            } else {
                v.parent.left = u;
            }
        } else {
            _root = u;
        }

        u.parent = v.parent;
        v.left = u.right;
        if (u.right != null) {
            u.right.parent = v;
        }

        if (v.right != null) {
            v.right.parent = v;
        }

        u.right = v;
        v.parent = u;
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
        if (u.left != null) {
            u.left.parent = w;
        }

        if (w.left != null) {
            w.left.parent = w;
        }

        u.left = w;
    }

    private void upin(AVLTreeNode u) {
        AVLTreeNode w = u.parent;
        if (w.balance == 0) {
            w.balance = w.left == u ? -1 : 1;
            if (w.parent != null)
                upin(w);
            return;
        }

        if ((w.balance == 1 && w.left == u) ||
            (w.balance == -1 && w.right == u)) {
            w.balance = 0;
            return;
        }

        // we now either have bal(w) == 1 or bal(w) == -1
        // since by our invariant bal(u) != 0, we need to re-balance
        // the tree somehow
        if (w.balance == -1) {
            // bal(w) == -1
            if (u.balance == -1) {
                // new key is in left part
                // right rotation around w (u is new root, w right of u)
                w.balance = 0;
                u.balance = 0;
                rightrotate(w);
            } else {
                // bal(u) == 1
                w.balance = u.right.balance < 0 ? 1 : 0;
                u.balance = u.right.balance > 0 ? -1 : 0;
                u.right.balance = 0;
                leftrotate(u);
                rightrotate(w);
            }
        } else {
            // bal(w) == 1
            if (u.balance == -1) {
                // new key is in left part
                w.balance = u.left.balance > 0 ? -1 : 0;
                u.balance = u.left.balance < 0 ? 1 : 0;
                u.left.balance = 0;
                rightrotate(u);
                leftrotate(w);
            } else {
                // new key is in right part
                // left rotation around w (u is new root, w left of u)
                w.balance = 0;
                u.balance = 0;
                leftrotate(w);
            }
        }
    }
}
