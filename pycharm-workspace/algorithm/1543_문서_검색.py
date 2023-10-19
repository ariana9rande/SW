def solution(string, target):
    count = 0

    while target in string:
        if target in string:
            count += 1
        string = string[str.find(string, target) + len(target):]

    return count


string = input()
target = input()

print(solution(string, target))
