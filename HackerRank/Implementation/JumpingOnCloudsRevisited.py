def jumpingOnClouds(c, k):
    n = len(c)
    energy = 100
    i = 0

    while True:
        i = (i + k) % n
        energy -= 1

        if c[i] == 1:
            energy -= 2

        if i == 0:
            break

    return energy