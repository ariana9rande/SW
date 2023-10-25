arr = ['A', 'B', 'C']  # 재료 리스트
check = [0, 0, 0]  # 위치 체크용 리스트


def powerset(idx):  # 재귀 깊이가 파라미터
    if idx == 3:   # 마지막 깊이에 도달했다면?
        print('check:', *check, end=' ')  # 이 당시의 check 배열 현황
        result = []
        for j in range(3):  # 체크 배열을 하나씩 보면서
            if check[j] == 1:  # 살아있다면?
                result.append(arr[j])  # 그 위치를 res에 담음
        print('result:', result)  # res 프린트!
        return

    check[idx] = 0
    powerset(idx + 1)

    check[idx] = 1
    powerset(idx + 1)

    # for i in range(2):
    #     check[idx] = i
    #     powerset(idx+1)

powerset(0)