package com.example.myapplication.util;

import android.content.Context;
import android.widget.Toast;


public class T {

	public static boolean isShow = true;  
	
	public static void showShortToast(Context context, String message){
		if(isShow){
			Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
		}
	}
	
	public static void showLongToast(Context context, String message){
		if(isShow){
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}
	
}
