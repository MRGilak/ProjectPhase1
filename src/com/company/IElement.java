package com.company;

public interface IElement { //The basic Element features are included in this interface
    double getVoltage(double time);
    double getCurrent(double time);
    double getPower(double time);
}
