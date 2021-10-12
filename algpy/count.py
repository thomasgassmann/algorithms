import matplotlib.pyplot as plt

def c(n):
    calls = 0
    for j in range(1, n + 1):
        if j ** 2 <= n:
            for k in range(j, n + 1):
                calls += 3
    return calls

def a(n):
    calls = 0
    for j in range(1, n + 1):
        for k in range(1, n + 1):
            for m in range(1, n + 1):
                calls += 1
    return calls

def b(n):
    calls = 0
    for j in range(1, n + 1):
        k = min(j, 100)
        for l in range(1, k + 1):
            calls += 1
    return calls

if __name__ == '__main__':
    xaxis = []
    yaxis = []
    yref = []
    for i in range(1, 10000, 1000):
        print(i)
        xaxis.append(i)
        yaxis.append(c(i))

        yref.append(0.005 * i ** 2)

    plt.plot(xaxis, yaxis, label='f')
    plt.plot(xaxis, yref, label='ref')
    plt.legend(loc='upper left')
    plt.show()