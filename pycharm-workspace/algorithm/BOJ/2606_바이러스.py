V = int(input())
E = int(input())

adj_matrix = [[0] * (V + 1) for _ in range(V + 1)]  # 인접행렬 기본틀 + 0번 포도알은 안씀\
adj_list = [[] for _ in range(V + 1)]

for _ in range(E):  # 간선 갯수만큼 돌면서 연결 정보를 받음
    start, end = map(int, input().split())  # 시작점과 끝점
    adj_matrix[start][end] = 1
    adj_matrix[end][start] = 1  # 양방향 그래프니까!!

    adj_list[start].append(end)
    adj_list[end].append(start)  # 양방향

# print("adj_matrix")
# for row in adj_matrix:
#     print(row)
#

# print("\najd_list")
# for row in adj_list:
#     print(row)
# print()

visited = []
stack = [1]

while stack:
    current = stack.pop()

    if current not in visited:  # 방문하지 않은 곳이라면,
        visited.append(current)  # 방문했다고 체크해줌

    for destination in adj_list[current]:
        if destination not in visited:  # 갈 수 있고 + 방문 안했으면!
            stack.append(destination)  # 다음 갈 곳으로 Stack에 저장
            # print("current:", current, end=' / ')
            # print(destination, "appended")
            # print("stack:", stack)

cnt = 0
for vertex in visited:
    if vertex != 1:
        cnt += 1

print(cnt)
