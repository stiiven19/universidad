class DuplicateKeyException(Exception):
    def __init__(self, new_key):
        super().__init__(f"El objeto {new_key} YA EXISTE!")
