def solution(string):
    for i in range((len(string) - 1) // 2 + 1):
        j = string[-(1 + i)]
        if string[i] != j:
            return 0
    return 1


string = input()

print(solution(string))
