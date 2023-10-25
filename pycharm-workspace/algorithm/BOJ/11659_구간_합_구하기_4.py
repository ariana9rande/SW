n, m = map(int, input().split())
arr = list(map(int, input().split()))

ij = []
for i in range(m):
    ij.append(list(map(int, input().split())))

# print(n, m)
# print(arr)
# print(ij)

# sums = [sum(arr[:i + 1]) for i in range(len(arr) - 1)]
# sums.append(sum(arr))

sums = []
temp = 0
for i in range(len(arr)):
    temp += arr[i]
    sums.append(temp)

# print(sums)

for item in ij:
    if item[0] - 1 != 0:
        print(sums[item[1] - 1] - sums[item[0] - 2])
    else:
        print(sums[item[1] - 1])