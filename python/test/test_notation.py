# coding=UTF-8
from adt.stack_queue.notation import Postfix
if __name__ == '__main__':
    expresion = "   (   12  -      8 )  +(2^3)^  3 + 7      "
    post = Postfix(expresion)
    print(post.infix())
    print(post.postfix())
    print(post.arithmetic_expression_evaluation())
