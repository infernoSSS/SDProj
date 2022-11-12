package com.myteam.game;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class DevTextureTuner {
    public static void main(String[] args) {
        String inputDir = "to.compile\\";
        String outputDir = "assets\\";
        String packFileName = "atlas";
        TexturePacker.process(inputDir, outputDir, packFileName);
    }
}
