from adt.stack_queue.stack import Stack
class Postfix():
    """docstring for Postfix."""

    def __init__(self, expresion_infix):
        self.expresion_infix = expresion_infix

    def infix(self):
        cadena =self.expresion_infix
        lista = ""
        bool=False
        for i in cadena:
            if i!= " ":
                if bool and i.isdigit():
                    lista = lista + str(i)
                    continue
                elif len(lista)>0:
                    if not i.isdigit() and lista[len(lista)-1] != " ":
                        lista = lista + " "
                    bool=False
                if i.isdigit() and not bool:
                    bool=True
                    lista = lista + str(i)
                else:
                    lista = lista + str(i)
                    lista = lista + " "
        if lista[len(lista)-1]==" ":
            lista=lista[:len(lista)-1]
        #lista=lista[:len(lista) -1]
        return lista

    def postfix(self):
        infix =self.infix()
        operators = Stack()
        postfix=""
        bool=False
        for i in infix:
            if i != " ":
                if bool and i.isdigit():
                    postfix = postfix + str(i)
                    continue
                elif len(postfix)>0:
                    if not i.isdigit() and postfix[len(postfix)-1] != " ":
                        postfix = postfix + " "
                    bool=False
                if i.isdigit() and not bool:
                    bool=True
                    postfix = postfix + str(i)
                    continue
                else:
                    if i == "^":
                        if operators.peek() =="^":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                            operators.push(i)
                        else:
                            operators.push(i)
                    if i == "*":
                        if operators.peek() =="^" or operators.peek() == "*" or operators.peek()=="/":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                            operators.push(i)
                        else:
                            operators.push(i)
                    if i == "/":
                        if operators.peek() =="^" or operators.peek() == "*" or operators.peek()=="/":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                            operators.push(i)
                        else:
                            operators.push(i)
                    if i == "+":
                        if operators.peek() =="^" or operators.peek() == "*" or operators.peek()=="/" or operators.peek()=="+" or operators.peek()=="-":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                            operators.push(i)
                        else:
                            operators.push(i)
                    if i == "-":
                        if operators.peek() =="^" or operators.peek() == "*" or operators.peek()=="/" or operators.peek()=="+" or operators.peek()=="-":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                            operators.push(i)
                        else:
                            operators.push(i)
                    if i == "(":
                        if operators.peek() =="^" or operators.peek() == "*" or operators.peek()=="/" or operators.peek()=="+" or operators.peek()=="-":
                            for y in range(len(operators)):
                                postfix = postfix + str(operators.pop()) + " "
                    if i == ")":
                        for y in range(len(operators)):
                            postfix = postfix + str(operators.pop()) + " "
        for y in range(len(operators)):
            postfix = postfix + str(operators.pop()) + " "
        if postfix[len(postfix)-1]==" ":
            postfix=postfix[:len(postfix)-1]
        return postfix

    def arithmetic_expression_evaluation(self):
        Operands_stack=Stack()
        postfix =self.postfix()
        #evaluation
        bool=False
        operand1=" "
        operand2=" "
        for i in postfix:
            if bool and i.isdigit():
                if not Operands_stack.is_empty(): operand2+=i
                else:operand1=operand1+i
                continue
            elif len(postfix)>0:
                if not i.isdigit() and i !=" ":
                    if Operands_stack.peek() is None: Operands_stack.push(operand1)
                    Operands_stack.push(operand2)
                    operator = i
                    if operator == "^":
                        operand2 =Operands_stack.pop()
                        operand1 = str(pow(float(Operands_stack.pop()),float(operand2)))
                        Operands_stack.push(operand1)
                    if operator == "*":
                        operand2 =Operands_stack.pop()
                        operand1 = str(float(Operands_stack.pop())*float(operand2))
                        Operands_stack.push(operand1)
                    if operator == "/":
                        operand2 =Operands_stack.pop()
                        operand1 = str(float(Operands_stack.pop())/float(operand2))
                        Operands_stack.push(operand1)
                    if operator == "-":
                        operand2 =Operands_stack.pop()
                        operand1 = str(float(Operands_stack.pop())-float(operand2))
                        Operands_stack.push(operand1)
                    if operator == "+":
                        operand2 =Operands_stack.pop()
                        operand1 = str(float(Operands_stack.pop())+float(operand2))
                        Operands_stack.push(operand1)
                bool=False
            if i.isdigit() and not bool:
                bool=True
                if operand1 ==" ":operand1=i
                else: operand2=i
        return Operands_stack.pop()
