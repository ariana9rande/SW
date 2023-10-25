n = int(input())
target = int(input())

arr = [[0] * n for _ in range(n)]

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

i = 0
r = n // 2
c = n // 2
limit = 2
direction = 0
target_r = -1
target_c = -1

while i < n * n:
    for cnt in range(1, limit + 1):
        if i >= n * n:
            break
        arr[r][c] = i + 1
        if arr[r][c] == target:
            target_r = r
            target_c = c
        r += dr[direction % 4]
        c += dc[direction % 4]
        if cnt == limit / 2:
            direction += 1
        i += 1
    if i >= n * n:
        break
    direction += 1
    limit += 2

for row in arr:
    for num in row:
        print(num, end=' ')
    print()
print(target_r + 1, target_c + 1)