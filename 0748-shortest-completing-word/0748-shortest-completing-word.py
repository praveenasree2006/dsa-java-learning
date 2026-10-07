class Solution:
    def shortestCompletingWord(self, li: str, words: List[str]) -> str:
        m={}
        for i in range(len(li)):
            if(li[i]>="a" and li[i]<="z"):
                m[li[i]]=m.get(li[i],0)+1
            elif(li[i]>="A" and li[i]<="Z"):
                o=li[i].lower()
                m[o]=m.get(o,0)+1
        res=""
        mint=100
        for i in range(len(words)):
            boo=True
            n={}
            for j in range(len(words[i])):
                n[words[i][j]]=n.get(words[i][j],0)+1
            for k in m:
                if(m.get(k)>n.get(k,0)):
                    boo=False
                    break
            if(boo and mint>len(words[i])):
                res=words[i]
                mint=len(words[i])
        return res