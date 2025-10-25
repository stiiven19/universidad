from adt.trees.nodes import TreeNode
from adt.trees.binary_tree import BinaryTree
from adt.trees.exceptions import DuplicateKeyException


class BinarySearchTree(BinaryTree):

    def append(self, new_key):
        if self.is_empty():
            self.root = self.__append(self.root, new_key)
        else:
            if type(self.root.key) == type(new_key):
                self.root = self.__append(self.root, new_key)

    def __append(self, subtree, new_key):
        if subtree is None:
            subtree = TreeNode(new_key)
        elif new_key < subtree.key:
            subtree.left = self.__append(subtree.left, new_key)
        elif new_key > subtree.key:
            subtree.right = self.__append(subtree.right, new_key)
        else:
            raise DuplicateKeyException(new_key)
        return subtree

    def search(self, key_search):
        if self.is_empty():
            return self.__search(self.root, key_search)
        else:
            if type(self.root.key) == type(key_search):
                return self.__search(self.root, key_search)
            return None


    def __search(self, subtree, key_search):
        if subtree is not None:
            if key_search == subtree.key:
                return subtree.key
            elif key_search < subtree.key:
                return self.__search(subtree.left, key_search)
            elif key_search > subtree.key:
                return self.__search(subtree.right, key_search)
        return None

    def delete(self, key_delete):
        if not self.is_empty():
            if type(self.root.key) == type(key_delete):
                self.__delete(self.root, key_delete)

    def __delete(self, subtree, key_delete):
        if subtree is None:
            return None
        if key_delete < subtree.key:
            print("<")
            subtree_current = self.__delete(subtree.left, key_delete)
            if subtree_current is None:
                return None
            else:
                if subtree_current.key == key_delete:
                    subtree_current = None
                subtree.left = subtree_current
                return subtree
        elif key_delete > subtree.key:
            print(">")
            subtree_current = self.__delete(subtree.right, key_delete)
            if subtree_current is None:
                return None
            else:
                if subtree_current.key == key_delete:
                    subtree_current = None
                subtree.right = subtree_current
                return subtree
        elif key_delete == subtree.key:
            if subtree.left is not None:
                if self.root.key == key_delete:
                    subtree_current = subtree.left
                    prev_sub = subtree
                    while True:
                        if subtree_current.right is None:
                            break
                        prev_sub = subtree_current
                        subtree_current = subtree_current.right
                    if subtree_current.left is not None:
                        if prev_sub == self.root:
                            subtree_current.right = prev_sub.right
                            self.root = subtree_current
                            prev_sub.right = None
                            prev_sub.left = None
                            return self.root
                        prev_sub.right = subtree_current.left
                    else:
                        if prev_sub == self.root:
                            subtree_current.right = prev_sub.right
                            self.root = subtree_current
                            prev_sub.right = None
                            prev_sub.left = None
                            return self.root
                        prev_sub.right = None
                    subtree_current.left = self.root.left
                    subtree_current.right = self.root.right
                    self.root = subtree_current
                    return self.root
                print("= left")
                subtree_current = subtree.left
                while True:
                    if subtree_current.right is None:
                        break
                    subtree_current = subtree_current.right
                subtree_current.right = subtree.right
                return subtree.left
            elif subtree.right is not None:
                print("=right")
                if key_delete == self.root.key:
                    self.root = subtree.right
                    return self.root
                return subtree.right
            else:
                if self.root == subtree:
                    self.root = None
                return subtree
        return None

    def search_min(self):
        return self.__search_min(self.root)

    def __search_min(self, subtree):
        if subtree is None:
            return None
        if subtree.left is not None:
            return self.__search_min(subtree.left)
        elif subtree.right is not None and subtree.key > subtree.right.key:
            return self.__search_min(subtree.right)
        return subtree.key
