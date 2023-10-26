n, m = map(int, input().split())

arr = sorted(list(map(int, input().split())))

check = [0] * n
sel = [None] * m

#순열
def perm(depth):
    if depth == m:
        for item in sel:
            print(item, end=' ')
        print()
        return

    for i in range(n):
        if check[i] == 0:
            check[i] = 1
            sel[depth] = arr[i]
            perm(depth + 1)
            check[i] = 0


perm(0)