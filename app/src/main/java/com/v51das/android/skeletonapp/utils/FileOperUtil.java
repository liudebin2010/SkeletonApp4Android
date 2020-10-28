package com.v51das.android.skeletonapp.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileOperUtil {
    public static String load(Context ctx, String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream in = ctx.openFileInput(fileName); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void save(Context ctx, String dp_text, String fileName) {
        try (FileOutputStream out = ctx.openFileOutput(fileName, Context.MODE_PRIVATE); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            writer.write(dp_text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
