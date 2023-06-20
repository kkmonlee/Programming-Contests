def beautifulDays(i, j, k):
    count = 0
    for day in range(i, j + 1):
        if abs(day - int(str(day)[::-1])) % k == 0:
            count += 1
    return count
