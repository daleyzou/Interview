package com.daleyzou.learn.Generic;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:34 2018-9-19
 * @Modified By:
 */
public class AirFilter extends Filter {
    public static class Factory implements com.daleyzou.learn.Generic.Factory<AirFilter>{

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
