n, m = map(int, input().split())

arr = sorted(list(map(int, input().split())))

check = [0] * n
sel = [None] * m

#조합
def combi(idx, sidx):
    if sidx == m:
        print(*sel)
        return

    last = -1
    for i in range(idx, n):
        if check[i] == 0 and last != arr[i]:
            check[i] = 1
            sel[sidx] = arr[i]
            last = arr[i]
            # print("before", end=' ')
            # print("depth:", sidx, end=' ')
            # print("i:", i, end=' ')
            # print("check:", *check, end=' ')
            # print("sel:", *sel, end=' ')
            # print("last:", last)
            combi(i + 1, sidx + 1)
            check[i] = 0
            # print("after", end=' ')
            # print("depth:", sidx, end=' ')
            # print("i:", i, end=' ')
            # print("check:", *check, end=' ')
            # print("sel:", *sel, end=' ')
            # print("last:", last)


combi(0, 0)