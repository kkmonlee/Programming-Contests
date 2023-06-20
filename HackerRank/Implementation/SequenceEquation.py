def permutationEquation(p):
    n = len(p)
    result = []

    index_dict = {p[i]: i + 1 for i in range(n)}

    for x in range(1, n + 1):
        index = index_dict[x]
        y = index_dict[index]
        result.append(y)

    return result