func ModuloFibonacciSequence(requestChan chan bool, resultChan chan int) {
	fib := make([]int, 201)
	fib[1] = 1
	fib[2] = 2

	for i := 3; i <= 200; i++ {
		fib[i] = (fib[i-1] + fib[i-2]) % int(1e9)
	}

	// Skip the requested number of results
	for i := 0; i < 200; i++ {
		<-requestChan
	}

	// Generate and send results
	for i := 1; i <= 200; i++ {
		resultChan <- fib[i]
	}
	close(resultChan)
}