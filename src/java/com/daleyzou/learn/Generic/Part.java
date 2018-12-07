package com.daleyzou.learn.Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: DaleyZou
 * @Description: 在Part类我们注册了我们上面的声明的实体类。
 *  所以以后我们如果要创建相关的实体类的话，只需要在调用Part类的相关方法了。
 *  这么做的一个好处就是如果的业务中出现了CabinAirFilter或者PowerSteeringBelt的话，
 *  我们不需要修改太多的代码，只需要在Part类中将它们注册即可。
 * @Date: Created in 15:31 2018-9-19
 * @Modified By:
 */
public class Part {
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<Factory<? extends Part>>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random random = new Random(47);
    public static Part createRandom(){
        int n = random.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
