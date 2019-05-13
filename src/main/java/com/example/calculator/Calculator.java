package com.example.calculator;

public class Calculator {
    final int nums= 10;
    int[] num = new int[nums];
    String[] operation = new String[nums];

    public int cal() {
        for (int i = 0; i < operation.length; i++) {
            if (operation[i].equals("/")) { //나눗셈인경우
                num[i] = div(num[i + 1], num[i]);
                location(i);
            } else if (operation[i].equals("*")) {
                num[i] = mutl(num[i + 1], num[i]);
                location(i);
            }
        }
        for (int i = 0; i < operation.length; i++) {
            if (operation[i].equals("+")) { //덧셈인경우
                num[i] = add(num[i + 1], num[i]);
                location(i);
            } else if (operation[i].equals("*")) { // 뺄셈인경우
                num[i] = sub(num[i + 1], num[i]);
                location(i);
            }
        }
        return  num[0];
    }

    public void setQeustion(String question){ // num과 operation에 문제값 나누어 담기
        int numSet=0;
        int setHeader=0;
        for(int i=0; i<question.length(); i++){
            if(numOrOperationCkeck(question.charAt(i))){ // 수식이냐
                operation[setHeader++]=String.valueOf(question.charAt(i));
            }
            else{ //숫자인가
                numSet = question.charAt(i); // 1의자리 저장
                for(int j=1; j<question.length()-1; j++){ // 숫자가 한자리가 아닌경우를 찾기위함
                    if(numOrOperationCkeck(question.charAt(i+j))) num[i]=question.charAt(i); // 한자리인경우
                    else{ //한자리가 아닌경우
                        numSet *=10;
                        numSet += question.charAt(i);
                        i++; // 다음 i체크를 스킵하기위해
                    }
                }
                num[setHeader++] = numSet;
            }
        }
    }

    public int add(int a,int b){ //덧셈
        return a+b;
    }

    public int sub(int a,int b){ //뺄셈
        return a-b;
    }

    public int mutl(int a,int b){ //곱셈
        return a*b;
    }

    public int div(int a,int b){ //나눗셈
        return a/b;
    }

    public boolean numOrOperationCkeck(char  chk){ // 숫자 , 수식 확인
        if(chk=='+'||chk=='-'||chk=='*'||chk=='/'||chk=='=') return true;
        else return false;
    }

    public void location(int i){
        for(int j=i; j<operation.length; j++){
            num[j+1]=num[j+2];
            operation[j]=operation[j+1];
        }
    }
}
