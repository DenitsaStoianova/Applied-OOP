package com;

import services.Computable;

public class Functions {

    private class SinFunction implements Computable {

        @Override
        public double function(double x) {
            return Math.sin(x);
        }
    }

    private class ExpFunction implements Computable{

        @Override
        public double function(double x) {
            return Math.exp(x);
        }
    }

    public Computable getSinFunction(){
        return new SinFunction();
    }

    public Computable getExpFunction(){
        return new ExpFunction();
    }

    public Computable getCosFunction(){
        return new Computable() {
            @Override
            public double function(double x) {
                return Math.cos(x);
            }
        };
    }

    public Computable getTanFunction(){

        class TanFunction implements Computable{

            @Override
            public double function(double x) {
                return Math.tan(x);
            }
        }
        return new TanFunction();
    }

}
