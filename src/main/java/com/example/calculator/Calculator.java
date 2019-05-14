package com.example.calculator;

public class Calculator {

    final int nums= 10;
    int[] num = new int[nums];
    char[] operation = new char[nums];
    int length=0;

    public int cal() { // 계산메소드
        do {
            for (int i = 0; i < length; i++) {

                if (operation[i] == '/') { //나눗셈인경우
                    num[i] = div(num[i], num[i + 1]);
                    location(i);
                    break;

                } else if (operation[i] == '*') { //곱셈의경우
                    num[i] = mutl(num[i], num[i + 1]);
                    location(i);
                    break;
                }

            }
            for (int i = 0; i < length; i++) {

                if (operation[i] == '+') { //덧셈인경우
                    num[i] = add(num[i], num[i + 1]);
                    location(i);
                    break;
                } else if (operation[i] == '-') { // 뺄셈인경우
                    num[i] = sub(num[i], num[i + 1]);
                    location(i);
                    break;
                }

            }
            length--;

        }while (length!=0);
        return  num[0];
    }

    public void setQeustion(String question){ // num과 operation에 문제값 나누어 담기
        int numSet,k;
        int setOperHeader=0;
        int setNumHeader=0;

        for(int i=0; i<question.length(); i++){

            if(numOrOperationCkeck(question.charAt(i))){ // 연산자인가?
                operation[setOperHeader++]=question.charAt(i);
            }
            else{ //숫자인가
                k=i;
                for(int j=i; j<question.length(); j++){ // 숫자가 한자리가 아닌경우를 찾기위함
                    numSet = Integer.valueOf(String.valueOf(question.charAt(j))); // 1의자리 저장
                    if(numOrOperationCkeck(question.charAt(j+1))) { // 다음 데이터가 기호인가?
                        num[setNumHeader]+=Integer.valueOf(String.valueOf(question.charAt(j))); // 한자리인경우
                        break;
                    }
                    else{ //한자리가 아닌경우
                        numSet *=10;
                        num[setNumHeader] += numSet;
                        k++; // 다음 i체크를 스킵하기위해
                    }
                }
                i=k; // k인덱스로 i를 위치시킴
                setNumHeader++; // num배열의 헤더증가
            }

        }
        length=setNumHeader; //for 문 종료후  length에 배열크기를저장

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

    public void location(int i){ // 계산시 배열의 위치를 한칸씩 앞당김
        for(int j=i; j<num.length-i-2; j++){
            num[j+1]=num[j+2];
            operation[j]=operation[j+1];

        }
    }

}
