package com.thomasgassmann.exercises;

public class AugmentedBinarySearchTree {
    private AugmentedBinarySearchTreeNode _root;

    public boolean contains(int key) {
        AugmentedBinarySearchTreeNode current = _root;
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

    public AugmentedBinarySearchTreeNode getRoot() {
        return _root;
    }

    public void insert(int key) {
        if (_root == null) {
            _root = new AugmentedBinarySearchTreeNode(key, null, null, null, 1);
            _root.balance = 0;
            return;
        }

        AugmentedBinarySearchTreeNode v = _root;
        AugmentedBinarySearchTreeNode u = null;
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

        var r = new AugmentedBinarySearchTreeNode(key, u,null, null, 1);
        r.balance = 0;
        if (u.key < r.key) {
            u.right = r;
        } else {
            u.left = r;
        }

        if (u.balance == 0) {
            u.balance = u.left == r ? -1 : 1;
            upin(u, false);
        } else {
            // either -1 or 1
            u.balance = 0;
            upin(u, true);
            // tree height didn't change, we're done
        }
    }

    private void rightrotate(AugmentedBinarySearchTreeNode v) {
        AugmentedBinarySearchTreeNode u = v.left;
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

    private void leftrotate(AugmentedBinarySearchTreeNode w) {
        AugmentedBinarySearchTreeNode u = w.right;
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

    private void updateSize(AugmentedBinarySearchTreeNode u) {
        u.size = (u.left != null ? u.left.size : 0)
               + (u.right != null ? u.right.size : 0)
               + 1;
    }

    private void upin(AugmentedBinarySearchTreeNode u, boolean onlyUpdateSizes) {
        if (u == null)
            return;

        updateSize(u);
        if (onlyUpdateSizes || u.parent == null) {
            upin(u.parent, true);
            return;
        }

        AugmentedBinarySearchTreeNode w = u.parent;
        if (w.balance == 0) {
            w.balance = w.left == u ? -1 : 1;
            upin(w, false);
            return;
        }

        if ((w.balance == 1 && w.left == u) ||
                (w.balance == -1 && w.right == u)) {
            w.balance = 0;
            upin(w, true);
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

        updateSize(u);
        upin(w, true);
    }
}
