package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.bigkoo.alertview.AlertView;
import com.bigkoo.alertview.OnItemClickListener;
import com.example.myapplication.util.T;
import com.example.myapplication.view.DialogFactory;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{

    int selectedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn1:
                Dialog loadingDialog = DialogFactory.createLoadingDialog(this);
                loadingDialog.show();
                break;
            case R.id.btn2:
                DialogFactory.showOneBtnDialog(this,"标题","内容");
                break;
            case R.id.btn3:
                DialogFactory.showTwoBtnDialog(this,"标题","内容",new DialogFactory.OnAlertViewClickListener(){

                    @Override
                    public void confirm() {
                        T.showShortToast(MainActivity.this,"确认");
                    }

                    @Override
                    public void cancel() {
                        T.showShortToast(MainActivity.this,"取消");
                    }
                });
                break;
            case R.id.btn4:
                final String items11111[] = {"男", "女"};
                DialogFactory.showSingleChoiceDialog(this, "标题", items11111, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                T.showShortToast(MainActivity.this,"选中的是:"+items11111[selectedIndex]);
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                T.showShortToast(MainActivity.this,"取消");
                                break;
                            default:
                                selectedIndex = which;
                                break;
                        }

                    }
                });
                break;
            case R.id.btn5:
                final String items2222[] = {"篮球", "足球", "排球"};
                final boolean selected[] = {true, false, true};
                DialogFactory.showMultiChoiceDialog(this, "标题", items2222, selected, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                String result = "选中的有:";
                                for (int i=0; i<selected.length;i++){
                                    if(selected[i]==true){
                                        result = result+items2222[i]+" ";
                                        T.showShortToast(MainActivity.this, result);
                                    }
                                }
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                T.showShortToast(MainActivity.this,"取消");
                                break;
                            default:
                                selected[which]= !selected[which];
                                break;
                        }
                    }
                });
                break;
            case R.id.btn6:
                final String items3333[]={"张三","李四","王五"};
                DialogFactory.showListDialog(this, "标题", items3333, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("123", "onClick: "+ which);
                        T.showShortToast(MainActivity.this, "选中的是:" + items3333[which]);
                    }
                });
                break;
            case R.id.btn7:
                DialogFactory.showEditDialog(this, "标题", new DialogFactory.OnEditDialogClickListener() {
                    @Override
                    public void confirm(String content) {
                        T.showShortToast(MainActivity.this, content);
                    }
                });
                break;
            case R.id.btn8:
                DialogFactory.showOkOrNoDialog(this, "修改成功!", true);
                break;
            case R.id.btn9:
                DialogFactory.showOkOrNoDialog(this, "修改失败!", false);
                break;
            case R.id.btn10:
                final Dialog loadingDialog2 = DialogFactory.createLoadingDialog(this);
                loadingDialog2.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog2.dismiss();
                        DialogFactory.showOkOrNoDialog(MainActivity.this, "审核成功!", true);
//                        finishDelayed(600);
                    }
                }, 2000);
                break;
            case R.id.btn11:
                DialogFactory.showActionSheet(this, new String[]{"高亮按钮1"}, new String[]{"其他按钮1", "其他按钮2", "其他按钮3"}, new OnItemClickListener(){
                    @Override
                    public void onItemClick(Object o, int position) {
                        Toast.makeText(MainActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn12:
                DialogFactory.showActionSheet(this,"标题", "内容", "取消",null,null, new OnItemClickListener(){
                    @Override
                    public void onItemClick(Object o, int position) {
                        Toast.makeText(MainActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                    }
                });
//                new AlertView("标题", "内容", "取消", null, null, this, AlertView.Style.ActionSheet, this).setCancelable(true).show();
                break;
            case R.id.btn13:
                DialogFactory.showActionSheet(this,"上传头像", new String[]{"拍照", "从相册中选择"}, new OnItemClickListener(){
                    @Override
                    public void onItemClick(Object o, int position) {
                        Toast.makeText(MainActivity.this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
    }

    @Override
    public void onItemClick(Object o, int position) {
        Toast.makeText(this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }



}
