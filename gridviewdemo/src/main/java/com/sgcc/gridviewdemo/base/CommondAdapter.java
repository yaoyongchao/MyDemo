package com.sgcc.gridviewdemo.base;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class CommondAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected List<T> mDatas = new ArrayList<T>();
	protected LayoutInflater mInflater;
	protected int layoutId;

	public CommondAdapter(Context context, int layoutId) {
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		// this.mDatas = datas;
		this.layoutId = layoutId;
	}
	
	public CommondAdapter(Context context, List<T> mDatas, int layoutId)	{
		this.mContext = context;
		this.mInflater = LayoutInflater.from(mContext);
		this.mDatas = mDatas;
		this.layoutId = layoutId;
	}
	
	public List<T>  getAdapterData(){
		return mDatas;
	}
	
	@Override
	public int getCount() {

		return mDatas.size();
	}

	@Override
	public T getItem(int position) {

		if(mDatas==null||mDatas.size()<=0)
			return null;
		if(position>mDatas.size())
			return null;
		return mDatas.get(position);
	
	}

	@Override
	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
				layoutId, position);
		convert(holder, getItem(position));
		return holder.getConvertView();
	};

	// 灏佽鍔犳暟鎹殑鏂规硶--1鏉� 澶氭潯
	public void appendData(T t, boolean isClearOld) {
		if (t == null)
			return;
		if (isClearOld)
			mDatas.clear();
		mDatas.add(t);
	}

	// 灏佽鍔犳暟鎹殑鏂规硶- 澶氭潯
	public void appendData(List<T> data, boolean isClearOld) {
		if (data == null)
			return;
		if (isClearOld)
			mDatas.clear();

		mDatas.addAll(data);

	}

	// 灏佽鍔犳暟鎹殑鏂规硶--1鏉� 澶氭潯 鍦ㄩ《閮ㄦ坊鍔�
	public void appendDataTop(T t, boolean isClearOld) {
		if (t == null)
			return;
		if (isClearOld)
			mDatas.clear();
		mDatas.add(0, t);

	}

	// 灏佽鍔犳暟鎹殑鏂规硶-澶氭潯 鍦ㄩ《閮ㄦ坊鍔�
	public void appendDataTop(List<T> data, boolean isClearOld) {
		if (data == null)
			return;
		if (isClearOld)
			mDatas.clear();
		mDatas.addAll(0, data);

	}

	public void update() {
		this.notifyDataSetChanged();
	}

	public void clear() {
		mDatas.clear();
	}

	public abstract void convert(ViewHolder holder, T t);

}
