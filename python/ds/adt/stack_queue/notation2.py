from adt.stack_queue.stack2 import Stack

class Postfix:

    def __init__(self, expresion_infix):
        try:
            eval(expresion_infix.replace("^", "**"),
                 {"__builtins__": None}, {})
        except:
            raise ValueError("The expression is not valid.")
        self.expresion_infix = expresion_infix.replace(" ", "")
        self.precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
        self.stack = Stack()

    def __is_operand(self, elem):
        try:
            float(elem)
            return True
        except:
            return False

    def __is_greater(self, i):
        try:
            a = self.precedence[i]
            b = self.precedence[self.stack.peek()]
            return True if a <= b else False
        except KeyError:
            return False

    def __infix_list(self):
        tmp_list = []
        pv_ch = ""
        tmp_exp = self.expresion_infix
        op = ['+', '-', '*', '/', '^', '(', ')']
        while len(tmp_exp) > 0:
            if tmp_exp[0] in op:
                tmp_list.append(tmp_exp[0])
                tmp_exp = tmp_exp[1:]
            else:
                pv_ch += tmp_exp[0]
                tmp_exp = tmp_exp[1:]
                if (len(tmp_exp) > 0 and tmp_exp[0] in op) or len(tmp_exp) == 0:
                    tmp_list.append(pv_ch)
                    pv_ch = ""
        return tmp_list

    def infix(self):
        return " ".join(self.__infix_list())

    def __postfix_list(self):
        self.stack = Stack()
        output = []
        for i in self.__infix_list():
            if self.__is_operand(i):
                output.append(i)

            elif i == '(':
                self.stack.push(i)

            elif i == ')':
                while((not self.stack.is_empty()) and self.stack.peek() != '('):
                    a = self.stack.pop()
                    output.append(a)
                if (not self.stack.is_empty() and self.stack.peek() != '('):
                    return -1
                else:
                    self.stack.pop()

            else:
                while(not self.stack.is_empty() and self.__is_greater(i)):
                    output.append(self.stack.pop())
                self.stack.push(i)

        while not self.stack.is_empty():
            output.append(self.stack.pop())

        return output

    def postfix(self):
        return " ".join(self.__postfix_list())

    def arithmetic_expression_evaluation(self):
        self.stack = Stack()
        exp = self.__postfix_list()
        # Iterate over the expression for conversion
        for i in exp:
            if self.__is_operand(i):
                self.stack.push(i)

            else:
                val1 = self.stack.pop()
                val2 = self.stack.pop()
                op = i if i != '^' else '**'
                self.stack.push(str(eval(val2 + op + val1)))

        return float(self.stack.pop())


exp = "12 + (3 - 1) * 85 / (58 - 9.8)"
obj = Postfix(exp)
print(obj.infix())
print(obj.postfix())
print(obj.arithmetic_expression_evaluation())
