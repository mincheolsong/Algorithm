a=[True,True]

n=int(input())

for _ in range(n):
    x=int(input())
    if x>len(a)-1:
        for _ in range(x+1-len(a)):
            a.append(True)
        for i in range(2,int(len(a)**(1/2))+1):
            if a[i]==True:
                j=2
                while i*j <len(a):
                    a[i*j]=False
                    j+=1

    for i in range(2,x//2+1):
        result = x
        if(a[x-i]==True and a[i]==True):
            if x-2*i < result:
                result = x-2*i
                p=i
                q=x-i
    print(p,q)


        
        

   