class Solution:
    def evaluate_opr(self, prev_opr, num, nums):
        if prev_opr == '/':
            nums.append(int(nums.pop() / num))
        elif prev_opr == '*':
            nums.append(nums.pop() * num)
        elif prev_opr == '+':
            nums.append(num)
        else:
            nums.append(num * -1)
    
    
    def calculate(self, s: str) -> int:
        num = 0
        nums = []
        prev_opr = '+'
        
        
        for ch in s:
            if ch == ' ':
                continue
            
            
            if (ch.isdigit()):
                num = num * 10 + int(ch)
            else:
                self.evaluate_opr(prev_opr, num, nums)
                prev_opr = ch
                num = 0
        
        
        self.evaluate_opr(prev_opr, num, nums)
        return sum(nums)
        