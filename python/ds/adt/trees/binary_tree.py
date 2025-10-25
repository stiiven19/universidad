from adt.trees.nodes import TreeNode
from random import random


class BinaryTree():
    """docstring for BinaryTree."""

    def __init__(self):
        self.root = None

    def is_empty(self):
        return self.root is None

    def append(self, new_key):
        if self.is_empty():
            self.root = self.__append(self.root, new_key)
        else:
            if type(self.root.key) == type(new_key):
                self.root = self.__append(self.root, new_key)

    def __append(self, subtree, new_key):
        if subtree is None:
            subtree = TreeNode(new_key)
        elif random() <= 0.5:  # left
            subtree.left = self.__append(subtree.left, new_key)
        else:
            subtree.right = self.__append(subtree.right, new_key)
        return subtree

    def search(self, search_key):
        if self.is_empty():
            return self.__search(self.root, search_key)
        else:
            if type(self.root.key) == type(search_key):
                return self.__search(self.root, search_key)
            return None


    def __search(self, subtree, search_key):
        if subtree is not None:
            if subtree.key == search_key:
                return search_key
            else:
                search_left = self.__search(subtree.left, search_key)
                if search_left is not None:
                    return search_left
                else:
                    search_right = self.__search(subtree.right, search_key)
                    if search_right is not None:
                        return search_right
        return None

    def __len__(self):
        return self.__size(self.root)

    def __size(self, subtree):
        if subtree is None:
            return 0
        else:
            return 1 + self.__size(subtree.left) + self.__size(subtree.right)

    def inodes(self):
        if not self.is_empty():
            return self.__inodes(self.root.left) + self.__inodes(self.root.right)
        return 0

    def __inodes(self, subtree):
        if subtree is not None:
            if subtree.left is not None or subtree.right is not None:
                return self.__inodes(subtree.left) + self.__inodes(subtree.right) + 1
        return 0

    def height(self):
        if not self.is_empty():
            return self.__height(self.root,1)
        return -1
    def __height(self, subtree,H):
        if subtree is not None:
            HL=self.__height(subtree.left,H+1)
            HR=self.__height(subtree.right,H+1)
            if HL>=HR:
                H=HL
            else:
                H=HR
            return H
        return H-1
    def leaves(self):
        return self.__leaves(self.root)

    def __leaves(self,subtree):
        if subtree is not None:
            if subtree.left is None and subtree.right is None:
                return 1
            else:
                return self.__leaves(subtree.left)+self.__leaves(subtree.right)
        return 0
