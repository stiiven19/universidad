def preorder(tree):
    try:
        if tree.root is not None:
            __preorder(tree.root)
        else:
            return "Ingresar datos para mostrar"
    except AttributeError as e:
        return "Error. debe enviar un objeto: BinaryTree"



def __preorder(subtree):
    if subtree is not None:
        # print(subtree.key)
        __see_node(subtree)
        __preorder(subtree.left)
        __preorder(subtree.right)


def __see_node(subtree, with_children=True):
    print(f"[{subtree.key}]")
    if with_children:
        cad=""
        cad2=""
        if subtree.left is not None:
            cad+="O"
            cad2+=str(subtree.left.key)
        else:
            cad+="X"
            cad2+="X"
        cad+=":"
        cad2+=":"
        if subtree.right is not None:
            cad+="O"
            cad2+=str(subtree.right.key)
        else:
            cad+="X"
            cad2+="X"
        print(cad)
        print(cad2)
        #print("O"if subtree.left is not None else"X" + ":" +
        #      "O"if subtree.right is not None else"X")
def preorder_str(tree):
    try:
        if tree.root is not None:
            return __preorder_str(tree.root)
        else:
            return "Ingresar datos para mostrar"
    except AttributeError as e:
        return "Error. debe enviar un objeto: BinaryTree"




def __preorder_str(subtree):
    if subtree is not None:
        cadena = str(subtree.key)+"\n"
        cadena +=str(__preorder_str(subtree.left))
        cadena +=str(__preorder_str(subtree.right))
        return cadena
    return ""
def inorder_str(tree):
    try:
        if tree.root is not None:
            return __inorder_str(tree.root)
        else:
            return "Ingresar datos para mostrar"
    except AttributeError as e:
        return "Error. debe enviar un objeto: BinaryTree"


def __inorder_str(subtree):
    cadena=""
    if subtree is not None:
        cadena+=str(__inorder_str(subtree.left))
        cadena+=str(subtree.key)+"\n"
        cadena+=str(__inorder_str(subtree.right))
    return str(cadena)

def postorder_str(tree):
    try:
        if tree.root is not None:
            return __postorder_str(tree.root)
        else:
            return "Ingresar datos para mostrar"
    except AttributeError as e:
        return "Error. debe enviar un objeto: BinaryTree"


def __postorder_str(subtree):
    cadena = ""
    if subtree is not None:
        cadena+=str(__postorder_str(subtree.left))
        cadena+=str(__postorder_str(subtree.right))
        cadena+=str(subtree.key)+"\n"
    return cadena
