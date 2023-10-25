def solution(s):
    x = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for item in x:
        if item in s:
            s = s.replace(item, str(x.index(item)))
    return int(s)


s = "one4seveneight"
print(solution(s))