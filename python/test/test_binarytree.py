from adt.trees.binary_tree import BinaryTree
from adt.trees.traversal import *
from adt.trees.binary_search_tree import BinarySearchTree
from adt.trees.exceptions import DuplicateKeyException
from colegio import Estudiante
if __name__ == '__main__':
    #https://recursospython.com/guias-y-manuales/clases-metodos-magicos-y-propiedades/
    """__lt__() para a < b.
__gt__() para a > b.
__le__() para a <= b.
__ge__() para a >= b.
__ne__() para a != b.
__eq__() para a == b."""
    """tree = BinaryTree()
    tree.append(5)
    tree.append(7)
    tree.append(3)
    tree.append(2)
    tree.append(1)
    tree.append(4)
    tree.append(6)
    tree.append("s")
    tree.append(8)
    tree.append(9)
    tree.append(10)
    print("search " + str(tree.search("s")))
    print("inodes " + str(tree.inodes()))
    print("height " + str(tree.height()))
    print("leaves " + str(tree.leaves()))
    print(preorder(tree))


    print("preorder:\n"+preorder_str(5))
    print("")
    print("inorder:\n"+inorder_str(5))
    print("")
    print("postorder: \n"+postorder_str(5))"""
    #leaves contar las hojas
    """def leaves(self)
    def inodes(self)cuenta nodos internos
    def height(self)
    def preorder_str(tree)generar 5
    5
    7
    3
    2
    def inorder _str
    def postorder _str"""

    tree = BinarySearchTree()
    try:
        """tree.append(10)
        tree.append(5)
        tree.append(15)
        tree.append(12)
        tree.append(5)"""
        tree.append(10)
        tree.append(100)
        tree.append(5)
        tree.append(4)
        tree.append(1)
        tree.append(7)
        tree.append(6)
        tree.append(8)
        """tree.append(4)
        tree.append(1)
        tree.append(7)
        tree.append(6)
        tree.append(8)"""
        tree.append(16)
        tree.append(15)
        tree.append(25)
        tree.append(22)
        tree.append(18)
        tree.append(17)
        tree.append(19)
        tree.append(21)
        tree.append(23)
        tree.append(27)
        #tree.append(5)
        tree.append(-5)
        tree.append(-100)
        tree.append("s")
        """tree.append(Estudiante(123, "Juan",4.5))
        tree.append(Estudiante(456, "Pedro",4.5))
        tree.append(Estudiante(789, "Maria",4.5))
        tree.append(Estudiante(456, "Pedro",5.0))"""
    except DuplicateKeyException as e:
        print(e.args[0])
    print("inodes " + str(tree.inodes()))
    print("height " + str(tree.height()))
    print("leaves " + str(tree.leaves()))
    preorder(tree)
    print("")
    #print("search " + str(tree.search(5)))
    #print("inodes " + str(tree.inodes()))
    #print("height " + str(tree.height()))
    #print("leaves " + str(tree.leaves()))
    print(tree.delete(5))
    print(" ")
    preorder(tree)
    print(tree.delete(10))
    print(" ")
    preorder(tree)
    print(tree.delete(8))
    print(" ")
    preorder(tree)
    print(tree.delete(7))
    print(" ")
    preorder(tree)
    print(tree.delete(6))
    print(" ")
    preorder(tree)
    print(tree.delete(23))
    print(tree.delete(4))
    print(" ")
    preorder(tree)
    print(tree.delete(1))
    print(" ")
    preorder(tree)
    print(tree.delete(8))
    print(" ")
    print(tree.delete(16))
    print(" ")
    preorder(tree)
    print(tree.delete(15))
    print(" ")
    preorder(tree)
    print(tree.delete(25))
    print(" ")
    preorder(tree)
    print(tree.delete(23))
    print(" ")
    preorder(tree)
    print(tree.delete(22))
    print(" ")
    preorder(tree)
    print(tree.delete(21))
    print(" ")
    preorder(tree)
    print(tree.delete(19))
    print(" ")
    preorder(tree)
    print(tree.delete(18))
    print(" ")
    preorder(tree)
    print(tree.delete(17))
    print(" ")
    preorder(tree)
    print(tree.delete(27))
    print(" ")
    preorder(tree)
    print("search_min "+str(tree.search_min()))
    #preorder(tree)
    #print("search " + str(tree.search(Estudiante(456, "Pedro",4.5))))
    #new_key
