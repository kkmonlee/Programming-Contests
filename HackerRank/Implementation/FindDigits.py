def findDigits(n):
    count = 0
    digits = str(n)

    for digit in digits:
        if digit != '0' and n % int(digit) == 0:
            count += 1

    return count