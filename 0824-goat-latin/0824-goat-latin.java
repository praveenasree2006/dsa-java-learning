class Solution {
    public String toGoatLatin(String sentence) {
        String str="",s="",ans="";
        sentence=sentence.trim();
        sentence+=" ";
        for(char ch : sentence.toCharArray())
            {
                if(ch!=' ')
                {
                    str+=ch;
                }
                else
                {
                    s+='a';
                    char c = str.charAt(0);
                    if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
                    {
                        str+="ma"+s;
                        ans+=str+" ";
                    }
                    else
                    {
                        String str2 = str.substring(1,str.length());
                        str2+=c;
                        str2+="ma"+s;
                        ans+=str2+" ";
                    }
                    str="";
                }
            }
        ans=ans.trim();
        return ans;
    }
}