template <typename T>
class CustomStack {
	private:
		unsigned int currentSize;
		unsigned int capacity;
		T *array;
		
	public:
		CustomStack(unsigned int size);
		~CustomStack();
		unsigned int size();
		void push(const T& value);
		T pop();
};

template <typename T>
CustomStack<T>::CustomStack(unsigned int size) {
	array = new T[size];
	
	currentSize = 0;
	capacity = size;
}

template <typename T>
CustomStack<T>::~CustomStack() {
	delete[] array;
	array = NULL;
	
	currentSize = 0;
	capacity = 0;
}

template <typename T>
unsigned int CustomStack<T>::size() {
	return currentSize;
}

template <typename T>
void CustomStack<T>::push(const T& value) {
	currentSize == capacity ? throw 1 : array[currentSize++] = value;
}

template <typename T>
T CustomStack<T>::pop() {
	return currentSize == 0 ? throw 1 : array[--currentSize];
}

//CUSTOM QUEUE

template <typename T>
class CustomQueue {
	private:
		unsigned int currentSize;
		unsigned int capacity;
		unsigned int frontData;
		unsigned int backData;
		T *array;
		
	public:
		CustomQueue(unsigned int size);
		~CustomQueue();
		unsigned int size();
		void push_back(const T& value);
		T pop_front();
};

template <typename T>
CustomQueue<T>::CustomQueue(unsigned int size) {
	array = new T[size];
	
	currentSize = 0;
	backData = 0;
	frontData = 0;
	capacity = size;
}

template <typename T>
CustomQueue<T>::~CustomQueue() {
	delete[] array;
	array = NULL;
	
	currentSize = 0;
	capacity = 0;
	backData = 0;
	frontData = 0;
}

template <typename T>
unsigned int CustomQueue<T>::size() {
	return currentSize;
}

template <typename T>
void CustomQueue<T>::push_back(const T& value) {
	if (currentSize == capacity)
		throw 1;
		
	if (backData == capacity - 1) {
		array[backData] = value;
		backData = 0;
		currentSize++;
	} else {
		array[backData++] = value;
		currentSize++;
	}
}

template <typename T>
T CustomQueue<T>::pop_front() {
	if (currentSize == 0)
		throw 1;
	
	if (frontData == capacity - 1) {
		frontData = 0;
		currentSize--;
		return array[capacity-1];
	} else {
		currentSize--;
		return array[frontData++];
	}
}
