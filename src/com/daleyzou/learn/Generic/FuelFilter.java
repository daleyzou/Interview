package com.daleyzou.learn.Generic;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:32 2018-9-19
 * @Modified By:
 */
public class FuelFilter extends Filter {

    public static class Factory implements com.daleyzou.learn.Generic.Factory<FuelFilter>{

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
