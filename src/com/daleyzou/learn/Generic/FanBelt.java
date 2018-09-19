package com.daleyzou.learn.Generic;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:37 2018-9-19
 * @Modified By:
 */
public class FanBelt extends Belt {
    public static class Factory implements com.daleyzou.learn.Generic.Factory<FanBelt>{

        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
