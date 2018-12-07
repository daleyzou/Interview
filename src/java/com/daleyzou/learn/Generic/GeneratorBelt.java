package com.daleyzou.learn.Generic;

/**
 * @Author: DaleyZou
 * @Description:
 * @Date: Created in 15:38 2018-9-19
 * @Modified By:
 */
public class GeneratorBelt extends Belt {
    public static class Factory implements com.daleyzou.learn.Generic.Factory<GeneratorBelt>{

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
