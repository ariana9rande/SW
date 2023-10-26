n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))

check = [0] * n
sel = [None] * m


#중복조합
def combi(idx, sidx):
    if sidx == m:
        print(*sel)
        return

    last = -1
    for i in range(idx, n):
        if last != arr[i]:
            sel[sidx] = arr[i]
            last = arr[i]
            combi(i, sidx + 1)


combi(0, 0)