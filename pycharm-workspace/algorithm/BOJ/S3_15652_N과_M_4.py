n, m = map(int, input().split())

check = [0] * n
sel = [None] * m

idx = 0
sidx = 0

#중복조합
def combi(idx, sidx):
    if sidx == m:
        for item in sel:
            print(item, end=' ')
        print()
        return

    if idx == n:
        return

    sel[sidx] = idx + 1

    combi(idx, sidx + 1)
    combi(idx + 1, sidx)


combi(0, 0)