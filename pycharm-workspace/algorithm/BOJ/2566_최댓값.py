arr = [list(map(int, input().split())) for i in range(9)]

maxs = []
for row in arr:
    r, c = arr.index(row), row.index(max(row))
    maxs.append(max(row))

m = max(maxs)
x, y = -1, -1

for i in range(len(arr)):
    for j in range(len(row)):
        if arr[i][j] == m:
            x, y = i, j

print(m)
print(x + 1, y + 1)