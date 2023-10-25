n, k = map(int, input().split())

# n개의 온도값을 입력하는 list 입력
temps = list(map(int, input().split()))

# k일 온도합 초기값 생성
result = sum(temps[:k])

temp = result

for i in range(k, len(temps)):
    # 한칸씩 슬라이딩하면서 temp값 갱신
    temp = temp - temps[i - k] + temps[i]
    # 둘 중 큰값을 result에 저장하면서 반복 비교
    result = max(result, temp)

print(result)

