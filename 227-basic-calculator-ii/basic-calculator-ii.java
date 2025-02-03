class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num =0;
        int sum=0;
        char operator = '+';
        for(int i =0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                 num = num*10+(ch-'0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if(operator=='+')
                {
                    stack.push(num);
                }
                else if(operator=='/')
                {
                    stack.push(stack.pop()/num);
                }
                else if(operator=='*')
                {
                    stack.push(stack.pop()*num);
                }
                else if(operator=='-')
                {
                    stack.push(-num);
                }
                operator = ch;
                num=0;
            }
            
        }

        while(!stack.isEmpty())
        {
            sum+=stack.pop();
        }

        return sum;
    }
}