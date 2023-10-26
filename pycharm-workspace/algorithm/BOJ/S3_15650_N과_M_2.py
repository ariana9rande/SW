n, m = map(int, input().split())

check = [0] * n
sel = [None] * m

idx = 0
sidx = 0

# 조합
def combi(idx, sidx):
    if sidx == m:
        for item in sel:
            print(item, end=' ')
        print()
        return

    for i in range(idx, n):
        sel[sidx] = i + 1
        combi(i + 1, sidx + 1)


combi(0, 0)
