def viralAdvertising(n):
    shared = 5
    liked = 0
    cumulative = 0

    for _ in range(1, n + 1):
        liked = shared // 2
        cumulative += liked
        shared = liked * 3

    return cumulative