package tree;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {

    Node<T> root;
    int size = 0;

    public BinaryTree() {
    }

    public BinaryTree(T value) {
        root = new Node<>(value);
        root.parent = null;
    }

    public T get(T value) {
        if (root == null) {
            return null;
        }
        return getNode(root, value).value;
    }

    public int getSize() {
        return size;
    }

    private Node<T> getNode(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.value.compareTo(value);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return getNode(node.left, value);
        } else {
            return getNode(node.right, value);
        }
    }

    public T add(T value) {
        if (root == null) {
            root = new Node<>(value);
            return value;
        }
        root = addRecursive(root, root.parent, value);
        size++;
        return value;
    }

    private Node<T> addRecursive(Node<T> current, Node<T> parent, T value) {
        if (current == null) {
            Node<T> node = new Node<>(value);
            node.parent = parent;
            return node;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = addRecursive(current.left, current, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = addRecursive(current.right, current, value);
        } else {
            return current;
        }
        return current;
    }

    public T deleteNode(T value) {
        root = deleteNodeRecursive(root, value);
        size--;
        return value;
    }

    private Node<T> deleteNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.value)) {
            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            T smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteNodeRecursive(current.right, smallestValue);
            return current;
        }

        if (value.compareTo(current.value) < 0) {
            current.left = deleteNodeRecursive(current.left, value);
            return current;
        }

        current.right = deleteNodeRecursive(current.right, value);
        return current;
    }

    private T findSmallestValue(Node<T> root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public boolean isContainsNode(T value) {
        return isContainsNodeRecursive(root, value);
    }

    private boolean isContainsNodeRecursive(Node<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (value.equals(current.value)) {
            return true;
        }

        return value.compareTo(current.value) < 0 ?
                isContainsNodeRecursive(current.left, value) : isContainsNodeRecursive(current.right, value);
    }

    @Override
    public String toString() {
        Stack<Node<T>> nodeStack = new Stack<>();
        nodeStack.push(root);
        StringBuilder s = new StringBuilder("{ ");
        while (!nodeStack.isEmpty()) {
            Node<T> node = nodeStack.pop();
            s.append(node.value).append(" ");

            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }
        s.append("}");
        return s.toString();
    }
}
