package com.ageofaquarius.proximacentauri.gaming.entity;

/**
 * Created by Mars on 2016-11-19.
 */

public interface HasExperience {

    public int getExperience();

    public void setExperience(int experience);

    public int getLevel();

    public void setLevel(int level);

    public double getCurrentExperiencePoint();

    public void setCurrentExperiencePoint(double currentExperiencePoint);

    public double[] getExperiences();

    public void setExperiences(double[] experiences);

    public int getMaxLevel();

    public void setMaxLevel(int maxLevel);
}