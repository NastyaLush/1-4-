package com.company.Exception;

import com.company.Exception.DethException;
import com.company.Exception.UncheckedException;
import com.company.Exception.IsPositive;

public abstract class ActiveException {
 public void canChange (String s) throws UncheckedException {
     if(s.equals("нет состояния")==false){
         throw new UncheckedException("Изменение невозможно");
     }
 }
 public void isTrue(boolean s) throws UncheckedException {
     if(s==true){
         throw new UncheckedException("Изменение невозможно");
     }
 }
    public void isFalse(boolean s) throws UncheckedException {
        if(s==false){
            throw new UncheckedException("Изменение невозможно");
        }
    }
    public void death(float a) throws DethException {
     if(a>=1 ){
         throw new DethException("Объекта не существует");
     }
     if(Math.random()%13==0){
         throw new DethException("Объект внезапно умер");
     }
    }
    public void power(int a) throws IsPositive {
        if(a<0) {
            throw new IsPositive("Сила не может быть отрицательной");
        }
    }
}
