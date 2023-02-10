S, P = map(int, input().split())
dna = list(input())
tmp = list(map(int, input().split()))
dic = {'A': tmp[0], 'C': tmp[1], 'G': tmp[2], 'T': tmp[3]}
base = {'A': 0, 'C': 0, 'G': 0, 'T': 0}

count = 0
for i in range(S-P+1): # 길이 - 부분문자열 길이 +1  4,2 일경우 3번 반복할 것이다. 0,1,2 GATA의 경우 GA,AT,TA 이 3가지 경우가 생긴다.
    flag = True    

    if i == 0: 
        for j in range(P):
            base[dna[j]] += 1 #base에 슬라이드 안의 문자를 하나씩 넣어준다. 해당 문자마다 count가 증가한다.
    else:
        base[dna[i+P-1]] += 1  #뒷부분 하나 추가
        base[dna[i-1]] -= 1 #base 앞부분 삭제

    for i in ('A', 'C', 'G', 'T'):
        if base[i] < dic[i]: # 조건이 하나라도 불만족일경우 깃발이 내려간다.  i=0일때 base 1,0,1,0 dic 1,0,0,1
            flag = False
            break

    if flag:
        count += 1

print(count)

## 이번 파이썬 구현은 어려웠다.  Java먼저 하고 Python을 했는데 dictionary 활용을 잘 한 코드같다. 
## base[i] dictionary의 i에 키 값이 들어가면 value 값을 반환한다.