package com.thomasgassmann.exercises;

class TreeNode {
    public int key;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;
    public int height;

    TreeNode(int key) {
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

class BinaryTree {
    TreeNode root;

    BinaryTree() {
        this.root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
        } else {
            insert(root, key);
        }
    }

    public void insert(TreeNode node, int key) {
        if (key < node.key) {
            if (node.left != null) {
                insert(node.left, key);
            } else {
                node.left = new TreeNode(key);
                node.left.parent = node;
                updateHeights(node);
            }
        } else {
            if (node.right != null) {
                insert(node.right, key);
            } else {
                node.right = new TreeNode(key);
                node.right.parent = node;
                updateHeights(node);
            }
        }
    }

    private void updateHeights(TreeNode node) {
        if (node == null) {
            return;
        }

        int newHeight = 0;
        if (node.left != null)
            newHeight = Math.max(newHeight, node.left.height);
        if (node.right != null)
            newHeight = Math.max(newHeight, node.right.height);
        node.height = newHeight + 1;
        updateHeights(node.parent);
    }

    public void delete(int key) {
        TreeNode node = search(key); // find the node to be deleted

        if (node == null) {
            return;
        }

        if (node.left == null) {
            if (node.right == null) { // no child
                if (node == root) {
                    root = null;
                } else {
                    if (node.parent.left == node) {
                        node.parent.left = null;
                    } else {
                        node.parent.right = null;
                    }

                    updateHeights(node.parent);
                }
            } else { // only right child
                if (node == root) {
                    root = node.right;
                    root.parent = null;
                } else {
                    if (node.parent.left == node){
                        node.parent.left = node.right;
                        node.right.parent = node.parent;
                    } else {
                        node.parent.right = node.right;
                        node.right.parent = node.parent;
                    }

                    updateHeights(node.parent);
                }
            }
        } else {
            if (node.right == null) { // only left child
                if (node == root) {
                    root = node.left;
                    root.parent = null;
                } else {
                    if (node.parent.left == node){
                        node.parent.left = node.left;
                        node.left.parent = node.parent;
                    } else {
                        node.parent.right = node.left;
                        node.left.parent = node.parent;
                    }

                    updateHeights(node.parent);
                }
            } else { // two children
                // swap node is symmetric successor
                TreeNode swapNode = node.left;
                while (swapNode.right != null) {
                    swapNode = swapNode.right;
                }

                node.key = swapNode.key;

                // now we remove swap node
                if (swapNode.left != null) { // swapNode has left Child
                    if (swapNode.parent.left == swapNode) {
                        swapNode.parent.left = swapNode.left;
                        swapNode.left.parent = swapNode.parent;
                    } else {
                        swapNode.parent.right = swapNode.left;
                        swapNode.left.parent = swapNode.parent;
                    }

                    updateHeights(swapNode.parent);
                } else { // swapNode has no child
                    if (swapNode.parent.left == swapNode) {
                        swapNode.parent.left = null;
                    } else {
                        swapNode.parent.right = null;
                    }

                    updateHeights(swapNode.parent);
                }
            }
        }
    }

    public TreeNode search(int key) {
        if (root == null) {
            return null;
        } else {
            return search(root, key);
        }
    }

    public TreeNode search(TreeNode node, int key) {
        if (node == null) {
            return null;
        } else if (key == node.key) {
            return node;
        } else {
            if (key < node.key) {
                return search(node.left, key);
            } else {
                return search(node.right, key);
            }
        }
    }

    public int heightOfKey(int key) {
        var treeNode = search(key);
        if (treeNode == null) {
            return -1;
        }

        return treeNode.height;
    }
}