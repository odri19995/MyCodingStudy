N = int(input())
count =1
start_index =1
end_index =1
count =1
s = 1
while(end_index !=N):
    if (s==N):
        count +=1
        end_index +=1
        s += end_index
    elif (s >N):
        s = s - start_index
        start_index +=1
    else:
        end_index +=1
        s += end_index
print(count)


# N,M = map(int,input().split()) 정수 2개 받는 법
# N = map(int, input()) N을 map 객체로 받는다. 