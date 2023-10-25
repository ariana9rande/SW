def solution(s):
    temp = ''
    answer = ''
    for item in s:
        if list(s).count(item) == 1:
            temp += item

    for t in sorted(temp):
        answer += t
    return answer


s = "abcabcadc"
print(solution(s))
