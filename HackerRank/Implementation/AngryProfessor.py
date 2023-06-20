def angryProfessor(k, a):
    on_time_count = sum(1 for time in a if time <= 0)
    if on_time_count < k:
        return "YES"
    else:
        return "NO"