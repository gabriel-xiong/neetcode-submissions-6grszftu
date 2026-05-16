class MinStack:
   
    def __init__(self):
        self.realStack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.realStack.append(val)
        if self.minStack: 
            self.minStack.append(min(self.minStack[-1], val))
        else:
            self.minStack.append(val)

    def pop(self) -> None:
        self.realStack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.realStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]
