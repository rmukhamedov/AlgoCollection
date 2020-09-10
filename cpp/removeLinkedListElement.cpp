template <typename T>
void singlyLinkedList<T>::deleteAllOfOccurrence(const T& value)//9 9 4 2 9 9 5 1 9 2 9 9
{
	if(count == 1){
		if(first->info == value){
			nodeType<T> *o = first;
			first = NULL;
			last = NULL;
			delete o;
			count--;
		}
	}else if(count != 0){
		nodeType<T> *p = first->link;
		nodeType<T> *o = first;
		int a = 0;
		for(int i = 0; i < count; i++){
			while(o->info == value){
				nodeType<T> *d = o;
				o = p;
				if(p != last)
					p = p->link;
				if(a == 0)
					first = o;
				
				delete d;
				count--;
				
			}
			while(p->info == value){
				nodeType<T> *d = p;
				if(p != last){
					o->link = p->link;
					p = p->link;
				}else{
					o->link = NULL;
					last = o;
					p = o;
					delete d;
					count--;
					break;
				}
				delete d;
				count--;
			}
			
			if(p != last){
				o = o->link;
				p = p->link;
			}
			a = 1;
		}
	}
}