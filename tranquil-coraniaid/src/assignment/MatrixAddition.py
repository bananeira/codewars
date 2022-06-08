def matrix_addition(a, b):
    matrix_sum = [[None for y in range(len(a))] for x in range(len(a))]

    for i in range(len(a)):
        for j in range(len(a)):
            matrix_sum[i-1][j-1] = a[i-1][j-1] + b[i-1][j-1]

    return matrix_sum
