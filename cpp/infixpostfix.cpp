#include <iostream>
#include <string>
#include <stack>
#include <sstream>
#include <algorithm> 
#include <functional> 
#include <cctype>
#include <locale>


using namespace std;

bool isDigit(char c){
	return c >= '0' && c <= '9';
}

bool isOperator(char c){
	return c == '/' || c == '*' || c == '+' || c == '-' || c == '^';
}

bool greaterOrEqualPrecedence(char a, char b){

	if(a == '^')
		return true;
	
	if(b == '^')
		return false;
		
	if(a == '*' || a == '/')
		return true;
		
	if(b == '*' || b == '/')
		return false;
		
	return true;
}

string convertToPfx(const string& infx) {
    string pfx = "";
    stack<string> s;
    string sym = "";
    
    unsigned int position = 0;
   
   while(position < infx.size()) {
		sym += infx.at(position++);
		
		if(isDigit(sym.back())){
			while(position < infx.size() && isDigit(infx.at(position)))
				sym += infx.at(position++);	
			pfx += sym + " ";
		}else if(sym == "("){
			s.push(sym);
		}else if(sym == ")"){
			while(s.top() != "("){
				pfx += s.top() + " ";
				s.pop();
			}
			s.pop();
		}else if(isOperator(sym.back())){
			while(!s.empty() && isOperator(s.top().back())){
				if(greaterOrEqualPrecedence(s.top().back(), sym.back())){
					pfx += s.top() + " ";
					s.pop();
				}else{
					break;
				}
			}
			s.push(sym);
		}
		sym = "";
    }
	
	while(!s.empty()){
		pfx += s.top() + " ";
		s.pop();
	}
    return pfx;
}