package com.example.user.git;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;              // 그냥 틀일뿐
    singerAdapter adapter;          //어탭터에서 실질적인 데이터를 관리, 처리한다

    String[] names = {"소녀시대", "걸스데이","씨스타","포미닛"};
    String[] ages = {"20","21","22","23"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        adapter = new singerAdapter();
        adapter.addItem(new SingerItem(names[0],ages[0]));
        adapter.addItem(new SingerItem(names[1],ages[1]));
        adapter.addItem(new SingerItem(names[2],ages[2]));
        adapter.addItem(new SingerItem(names[3],ages[3]));
        listView.setAdapter(adapter);
    }

    class singerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();  //SingerItem에서 받은 데이터 보관용 배열

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        //리스트뷰가 어댑터쪽에 각각의 아이템을 위한 뷰를 요청하는 것
        //convertview : 아이템 재사용 가능하면 재사용하게끔하는 뷰
        public View getView(int position, View convertview, ViewGroup parent) {
             SingerItemView view = null;
            if(convertview == null){        //컨버트뷰가 널이면
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
               view = new SingerItemView(getApplicationContext()); // 새로운 뷰 정의
            }
            else {          //널이 아니면
                view = (SingerItemView) convertview;        //기존의 컨버트뷰에있는 아이템 재사용
            }

            final Button button = (Button)view.findViewById(R.id.Button1);
            button.setOnClickListener(new View.OnClickListener(){
                int favorit_flag = 0;
                @Override
                public void onClick(View v) {
                    if (favorit_flag == 0) {
                        button.setText("★");
                        Toast.makeText(MainActivity.this, "즐겨찾기 추가", Toast.LENGTH_SHORT).show();
                        favorit_flag =1;
                    }
                    else{
                        button.setText("☆");
                        Toast.makeText(MainActivity.this, "즐겨찾기 해제", Toast.LENGTH_SHORT).show();
                        favorit_flag =0;
                    }
                }
            });

            //이름, 나이 설정 names, ages 배열의 값으로
            SingerItem currentItem = items.get(position);
            view.setName(currentItem.getName());
            view.setAge(currentItem.getAge());

            return view;
        }
    }
}
