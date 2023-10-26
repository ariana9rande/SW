n, m = map(int, input().split())
arr = sorted(list(map(int, input().split())))

check = [0] * n
sel = [None] * m


#중복순열
def perm(depth):
    if depth == m:
        print(*sel)
        return

    last = -1
    for i in range(n):
        if last != arr[i]:
            sel[depth] = arr[i]
            last = arr[i]
            perm(depth + 1)


perm(0)