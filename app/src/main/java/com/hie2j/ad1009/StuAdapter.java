package com.hie2j.ad1009;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class StuAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> studentArrayList;
    private IOnDelListener listener;

    public StuAdapter(Context context,ArrayList<Student> studentArrayList,IOnDelListener listener){
        this.context = context;
        this.studentArrayList = studentArrayList;
        this.listener = listener;
    }
    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item,parent,false);
            //使用Holder保存子组件 避免每次使用时重复find
            StuViewHolder holder = new StuViewHolder();
            holder.headImg = convertView.findViewById(R.id.stu_img);
            holder.ageView = convertView.findViewById(R.id.stu_age);
            holder.nameView = convertView.findViewById(R.id.stu_name);
            holder.delImg = convertView.findViewById(R.id.stu_del);

            convertView.setTag(holder);
        }

        Student stu = studentArrayList.get(position);
        StuViewHolder holder = (StuViewHolder) convertView.getTag();

        holder.headImg.setImageResource(stu.getImgId());
        holder.nameView.setText(stu.getName());
        holder.ageView.setText(String.valueOf(stu.getAge()));
        holder.delImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除该对象
                listener.del(position);
//                studentArrayList.remove(position);
//                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
