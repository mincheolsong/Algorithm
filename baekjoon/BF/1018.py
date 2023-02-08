
N,M=map(int,(input().split()))

board=[]
cnt=[]
for i in range(N):
    board.append(list(input()))

for i in range(N-7):
    for j in range(M-7):
        for k in range(2):
            tmp_board=[]
            c=0
            for rows in range(i,i+8):
                tmp_board.append(board[rows][j:j+8])

            if k==1 and tmp_board[0][0]=='W':
                tmp_board[0][0]='B'
                c+=1
            elif k==1 and tmp_board[0][0]=='B':
                tmp_board[0][0]='W'
                c+=1
            for p in range(7):
                for q in range(7):
                    if(tmp_board[p][q]==tmp_board[p+1][q]):
                        if tmp_board[p][q]=='B':
                            tmp_board[p+1][q]='W'
                        elif tmp_board[p][q]=='W':
                            tmp_board[p+1][q]='B'
                        c+=1
                    if(tmp_board[p][q]==tmp_board[p][q+1]):
                        if tmp_board[p][q]=='B':
                            tmp_board[p][q+1]='W'
                        elif tmp_board[p][q]=='W':
                            tmp_board[p][q+1]='B'
                        c+=1
            if (tmp_board[7][7] != tmp_board[6][6]):
                c+=1
                tmp_board[7][7]=tmp_board[6][6]


            cnt.append(c)
           
            

        
print(min(cnt))


