#slide Window
import sys
input = sys.stdin.readline
length , passLength = map(int , input().split())
dna = input()
#ACGT
Goal = list(map(int , input().split()))
contain = [0,0,0,0]
#start_index , end_index = 0 , passLength-1 #  알아보기 힘들다.
start_index =0
end_index = passLength-1
cnt = 0


def add(ch): #현재 상태 배열에 추가 
    if ch == 'A':
        contain[0]+=1
    elif ch=='C':
        contain[1]+=1
    elif ch=='G':
        contain[2]+=1
    elif ch=='T':
        contain[3]+=1

def remove(ch): #현재 상태배열 제거
    if ch == 'A':
        contain[0]-=1
    elif ch=='C':
        contain[1]-=1
    elif ch=='G':
        contain[2]-=1
    elif ch=='T':
        contain[3]-=1

#초기 설정하기
for i in range(passLength): # 첫번째 범위
    add(dna[i])
if contain[0]>=Goal[0]:
        if contain[1]>=Goal[1]:
            if contain[2]>=Goal[2]:
                if contain[3]>=Goal[3]:
                    cnt+=1

#탐색 시작
while end_index<length-1:  #첫번째 범위는 이미 했으므로 길이는 하나 줄여준다.
    remove(dna[start_index]) # contain 제거
    start_index+=1
    end_index+=1
    add(dna[end_index])
    if contain[0]>=Goal[0]:
        if contain[1]>=Goal[1]:
            if contain[2]>=Goal[2]:
                if contain[3]>=Goal[3]:
                    cnt+=1  #4가지 조건 모두 만족시 cnt 추가
print(cnt)

#자바 풀이와 비슷한 풀이