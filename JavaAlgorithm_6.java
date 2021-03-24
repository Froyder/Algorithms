package javaAlgorithms;

public class JavaAlgorithm_6 {

    //дерево и связанные с ним методы
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        Tree theTree = new Tree();

        theTree.insert(new Person(4, "Jhon", 35));
        theTree.insert(new Person(2, "Paul", 78));
        theTree.insert(new Person(3, "George", 24));
        theTree.insert(new Person(5, "Ringo", 21));

        theTree.max().display();
        theTree.min().display();
        theTree.find(3).display();
        theTree.delete(2);

        System.out.println();
        theTree.displayTree();

        long endTime = System.nanoTime();
        System.out.println("На выполнение расчетов ушло " + (endTime - startTime) + " единиц времени");
    }


    static class Person {
        public String name;
        public int id;
        public int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    static class Node {
        public Person person;
        public Node leftChild;
        public Node rightChild;

        public void display() {
            System.out.println("ID: " + person.id + " Имя " + person.name + " Возраст: " + person.age);
        }
    }

    static class Tree {
        private Node root;

        public void insert (Person person) {
            Node node = new Node();
            node.person = person;
            if (root == null)
                root = node;
            else {
               Node current = root;
               Node parent;
               while (true) {
                   parent = current;
                   if (person.id < current.person.id) {
                       current = current.leftChild;
                       if (current == null) {
                           parent.leftChild = node;
                           return;
                       }
                   } else {
                       current = current.rightChild;
                       if (current == null) {
                           parent.rightChild = node;
                           return;
                       }
                   }
               }
            }
        }

        public Node find (int key) {
            Node current = root;
            while (current.person.id != key) {
                if (key < current.person.id)
                    current = current.leftChild;
                else
                    current = current.rightChild;
                if (current == null)
                    return null;
            }
            return current;
        }

        //симметричный обход дерева
        public void inOrder (Node rootNode) {
            if (rootNode != null) {
                inOrder(rootNode.leftChild);
                rootNode.display();
                inOrder(rootNode.rightChild);
            }
        }

        //прямой обход дерева
        public void preOrder (Node rootNode) {
            if (rootNode != null) {
                rootNode.display();
                preOrder(rootNode.leftChild);
                preOrder(rootNode.rightChild);
            }
        }

        //обратный обход дерева
        public void postOrder (Node rootNode) {
            if (rootNode != null) {
                postOrder(rootNode.leftChild);
                postOrder(rootNode.rightChild);
                rootNode.display();
            }
        }


        public Node min () {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.leftChild;
            }
            return last;
        }

        public Node max () {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.rightChild;
            }
            return last;
        }

        public boolean delete (int id) {
            Node current = root;
            Node parent = root;

            boolean isLeftChild = true;

            while (current.person.id != id) {
                parent = current;
                if (id < current.person.id) {
                    isLeftChild = true;
                    current = current.leftChild;
                } else {
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if (current == null) {
                    return false;
                }
            }
            if (current.leftChild == null && current.rightChild == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                   }
                } else if (current.rightChild == null) {
                    if (current == null) {
                        root = current.leftChild;
                    } else if (isLeftChild) {
                        parent.leftChild = current.leftChild;
                    } else {
                        parent.rightChild = current.leftChild;
                   }
                } else if (current.leftChild == null) {
                if (current == null) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else {
                Node successor = getSuccessor (current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        public Node getSuccessor (Node node) {
            Node successorParent = node;
            Node successor = node;
            Node current = node.rightChild;

            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }
            if (successor != node.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = node.rightChild;
            }
            return successor;
        }

        public void displayTree () {
            Node current = root;
            System.out.println("Симметричный");
            inOrder(root);
            System.out.println("Прямой");
            preOrder(root);
            System.out.println("Обратный");
            postOrder(root);
        }

    }


}

