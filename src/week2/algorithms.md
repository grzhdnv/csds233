1.    If the Big-O complexity of an algorithm is O(n2), then what is the expected 
      effect on the running time of the algorithm if the size of the input triples?

    (3n)^2 = 9n^2

2.    For each of the following code segments, determine which Big-O is the best
      approximation to express the worst-case performance of the code segment.
      a.    //assume ar is an integer array
      
    int sum = 0;
    n = ar.length;
    for(int i= 0; i<n; ++i)
        sum += ar[i];
    int mean = sum/n;

    O(n)

b.    //assuming a, b, and c are all 2-dimensional arrays

    for(int i= 0; i<a.length; ++i)
        for(int j=0; j<a[i].length; ++j)
            c[i][j] = a[i][j] + b[i][j];

    O(n^2) if square matrix or O(n*m)?

c.

    while (n>= 1)
    n = n/2;

    O(log n)

log(n)

3.    Write some java code that has O(nlogn) complexity, where n is the size of the input.
    
    for (... i++)
        for (... i*2)