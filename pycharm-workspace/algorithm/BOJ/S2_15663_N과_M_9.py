n, m = map(int, input().split())

arr = sorted(list(map(int, input().split())))

check = [0] * n
sel = [None] * m

#순열
def perm(depth):
    if depth == m:
        # print("depth:", depth, end=' ')
        # print("check:", *check, end=' ')
        # print("sel:", *sel, end=' ')
        # print("returned")
        print(*sel)
        return

    last = -1
    for i in range(n):
        if check[i] == 0 and last != arr[i]:
            check[i] = 1
            sel[depth] = arr[i]
            last = arr[i]
            # print("before", end=' ')
            # print("depth:", depth, end=' ')
            # print("check:", *check, end=' ')
            # print("sel:", *sel, end=' ')
            # print("last:", last)
            perm(depth + 1)
            check[i] = 0
            # print("after", end=' ')
            # print("depth:", depth, end=' ')
            # print("check:", *check, end=' ')
            # print("sel:", *sel, end=' ')
            # print("last:", last)


perm(0)