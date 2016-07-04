package com.example.user.git;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by user on 2016-07-04.
 */

//리스트 하나에 들어가는 아이템(부분화면)을 xml 레이아웃과 자바파일로 하나의 뷰(singerItemView)로 만든다.
public class SingerItemView extends LinearLayout {

    TextView nameTextView;
    TextView ageTextView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this,true);

       nameTextView = (TextView) findViewById(R.id.nameTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);

    }

    public void setName(String name){ //걸그룹 이름 nameTextView에 이름값 설정
        nameTextView.setText(name);
    }
    public void setAge(String age){//걸그룹 나이 ageTextView에 나이값 설정
        ageTextView.setText(age);
    }
}
