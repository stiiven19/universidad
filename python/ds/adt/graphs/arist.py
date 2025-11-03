class AristGraph():
    """docstring for TreeNode."""

    def __init__(self, node_orig, node_dest, peso=None):
        self.Peso = peso
        self.node_orig = node_orig
        self.node_dest = node_dest

    def __str__(self):
        return str(self.node_dest.key)
