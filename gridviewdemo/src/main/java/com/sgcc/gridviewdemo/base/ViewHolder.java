package com.sgcc.gridviewdemo.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	private SparseArray<View> mViews;
	private View mConvertView;
	private int mPosition;

	public ViewHolder(Context context, ViewGroup parent, int layoutid,
			int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutid, parent,
				false);
		mConvertView.setTag(this);
	};

	public static ViewHolder get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {
			return new ViewHolder(context, parent, layoutId, position);
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.mPosition = position;
			return holder;
		}
	}

	/**
	 * ͨ��viewId��ȡ�ؼ�
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);

		}
		return (T) view;
	}

	public View getConvertView() {
		return mConvertView;

	}
    public int getPosition(){
    	return mPosition;
    }
	/**
	 * ����TextView��ֵ
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}
    /**
     * ����ImageView��ֵ
     * @param viewId
     * @param resId
     * @return
     */
	public ViewHolder setImageResource(int viewId, int resId) {
		ImageView view = getView(viewId);
		view.setImageResource(resId);
		return this;
	}
	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	
	}
	/**
	 * ����ͼƬ�ļ���
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageURL(int viewId, int resId) {
		ImageView view = getView(viewId);
		//ImageLoader.load(view,url);
		  return this;
	}

	public int getmPosition() {
		return mPosition;
	}


}
