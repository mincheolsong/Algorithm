import sys
input = sys.stdin.readline

st=list(input().rstrip())
m=int(input())

tmp_st=[]

for _ in range(m):
    cmd=input().split()
    if cmd[0]=='L' and len(st)>0:
        tmp_st.append(st.pop())
    elif cmd[0]=='D' and len(tmp_st)>0:
        st.append(tmp_st.pop())
    elif cmd[0]=='B' and len(st)>0:
        st.pop()
    elif cmd[0]=='P':
        st.append(cmd[1])
    
st.extend(reversed(tmp_st))

print(''.join(st))    


