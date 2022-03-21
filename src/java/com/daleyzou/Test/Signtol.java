package com.daleyzou.Test;

/**
 * Signtol
 *
 * @author zoudaifa
 * @description 单例
 * @date 2022年03月21日 4:09 下午
 */
public class Signtol {
    volatile  Signtol signton;

    private Signtol(){

    }

    public Signtol getInstance(){
        if(signton == null){
            synchronized (Signtol.class){
                if(signton == null){
                    signton = new Signtol();
                }
            }
        }
        return signton;
    }

}
