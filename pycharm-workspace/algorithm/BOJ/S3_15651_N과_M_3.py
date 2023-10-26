n, m = map(int, input().split())

check = [0] * n
sel = [None] * m

# 중복순열
def perm(depth):
    if depth == m:
        for item in sel:
            print(item, end=' ')
        print()
        return

    for i in range(n):
        sel[depth] = i + 1
        perm(depth + 1)


perm(0)