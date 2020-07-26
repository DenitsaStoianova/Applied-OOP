package com;

import services.Computable;

public class Tabulate {

    private Computable callback;

    public Tabulate(Computable callback) {
        setCallback(callback);
    }

    public Computable getCallback() {
        return callback;
    }

    public void setCallback(Computable callback) {
        if(callback == null){
            this.callback = new Functions().getSinFunction();
        } else {
            this.callback = callback;
        }
    }

    public String tabulate(double a, double b, double step){
        return tabulateFunction(a,b,step, this.callback);
    }

    public static String tabulateFunction(double a, double b,double step, Computable function){
        if(step < 0){
            return "Step cannot be negative!";
        }

        if(b <= a){
            return "Interval is not correct";
        }

        String result = String.format("%10s%10s%n", "X", "F(X)");

        double lengthOfInterval = (b - a) / step;
        for(int i = 1; i <= lengthOfInterval; i++){
            double x = a + i * step;

            double y = function.function(x);

            result += String.format("%10.2f%10.2f%n", x, y);

            if(i % 20 == 0){
                result += "\n";
            }
        }
        return result;
    }
}
