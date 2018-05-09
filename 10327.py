from sys import stdin as cin



def merge(a, q, p, r):
    num=0
    n1 = p - q + 1
    n2 = r - p

    l1 = [0] * (n1 + 1)
    l2 = [0] * (n2 + 1)

    l1[n1] = 10 ** 9
    l2[n2] = 10 ** 9

    for x in range(n1): l1[x] = a[q + x]
    for x in range(1, n2 + 1): l2[x - 1] = a[p + x]
    i = 0
    j = 0
    for x in range(q, r + 1):
        if l1[i] <= l2[j]:
            a[x] = l1[i]
            i += 1
        else:

            a[x] = l2[j]
            j += 1

            num+=n1-i

    return num


def mergeSort(a, q, r):
    num=0
    if q < r:
        p = (r + q) // 2

        num+=mergeSort(a, q, p)
        num+=mergeSort(a, p + 1, r)
        num +=merge(a, q, p, r)
    return num



while (len(cin.readline().strip())):
    a = [int(j) for j in cin.readline().split()]
    print('Minimum exchange operations : %s\n' % mergeSort(a, 0, len(a) - 1))
