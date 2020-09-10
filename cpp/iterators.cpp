template <typename T>
Iterator<T>& Iterator<T>::operator--() {
	if(offTheRightEdge == true)
		offTheRightEdge = false;
	else
		current = current->backward;
	
	
	return *this;
}

//TODO
template <typename T>
bool Iterator<T>::operator!=(const Iterator<T>& right) const {
	return offTheRightEdge != right.offTheRightEdge || current != right.current;
}

template <typename T>
bool Iterator<T>::operator==(const Iterator<T>& right) const {
	return offTheRightEdge == right.offTheRightEdge && current == right.current;
}

//TODO   *********************************************************************************************************************************
template <typename T>
void ourReverse(T begin, T end) {
	while(begin != end && begin != --end){
		swap(*begin,*end);
		++begin;
	}
}