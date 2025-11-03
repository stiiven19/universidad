class StackNode():
    """docstring for StackNode."""

    def __init__(self, data):
        self.data = data
        self.next = None
class PriorityNode():
    """docstring for StackNode."""

    def __init__(self, data,Priority):
        self.data = data
        self.next = None
        self.Priority=Priority
