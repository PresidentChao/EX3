package com.example.lenovo.ex3;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.AbsListView.MultiChoiceModeListener;
import com.example.lenovo.ex3.R;

import com.example.lenovo.ex3.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActionModeAdapter extends AppCompatActivity {
    private ListView mListView1;
    private MyListAdapter mAdapter;
    private List<String> num;
    private int item_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode_adapter);

        init();
    }

    public void init(){
        mListView1=(ListView)this.findViewById(R.id.lvam);
        num = new ArrayList<>();
        num.add("    One");
        num.add("    Two");
        num.add("    Three");
        num.add("    Four");
        num.add("    Five");
        mAdapter = new MyListAdapter(ActionModeAdapter.this,num);
        mListView1.setAdapter(mAdapter);

        /**
         * ListFragment也有一个getListView()方法来获取ListFragment管理着的ListView。为什么不使用呢？
         * 这是因为，在onCreateView(...)方法完成调用并返回视图之前，getListView()方法返回的永远是null值。
         */
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            // 为浮动上下文菜单登记视图，之后，长按视图则会触发上下文菜单的创建
            registerForContextMenu(mListView1);
        } else {
            // 上下文操作模式下设置ListView的多选模式
            mListView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
            /**
             * 为listView设置一个实现AbsListView.MultiChoiceModeListener接口的监听器。该接口包含以下回调方法，视图在选中或撤销时会触发它：
             * public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked)
             *
             * MultiChoiceModeListener实现了另一个接口，即ActionMode.CallBack。用户屏幕进入上下文操作时，会创建一个ActionMode类实例。
             * 随后在其生命周期内，ActionMode.CallBack接口的回调方法会在不同时点被调用。以下为ActionMode.CallBack接口必须实现的四个方法：
             */
            mListView1.setMultiChoiceModeListener(new MultiChoiceModeListener() {
                private View mMultiSelectActionBarView;
                private TextView mSelectedCount;

                /**
                 * 在onCreateActionMode(ActionMode mode, Menu menu)方法之后，以及当前上下文操作栏需要刷新显示新数据时调用。
                 */
                @Override
                public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
                    return false;
                }

                /**
                 * 在用户退出上下文操作模式或所选菜单项操作已被响应，从而导致ActionMode对象将要销毁时调用。默认的实现会导致已选视图被反选。
                 * 这里，也可完成在上下文操作模式下，响应菜单操作而引发的相迎fragment更新。
                 */
                @Override
                public void onDestroyActionMode(ActionMode arg0) {
                }

                /**
                 * 在ActionMode对象创建后调用。也是实例化上下文菜单资源，并显示在上下文操作栏上的任务完成的地方。
                 */
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    /**
                     * 我们从操作模式，而非activity中获取MenuInflater的。操作模式负责对上下文操作栏进行配置。例如，
                     * 可调用ActionMode.setTitle(...)方法为上下文操作栏设置标题，而activity的MenuInflater则做不到这一点。
                     */
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.action_menu, menu);
                    if (mMultiSelectActionBarView == null) {
                        mMultiSelectActionBarView = LayoutInflater.from(ActionModeAdapter.this).inflate(R.layout.select_actionbar, null);
                        mSelectedCount = (TextView) mMultiSelectActionBarView.findViewById(R.id.selected_conv_count);
                    }
                    mode.setCustomView(mMultiSelectActionBarView);


                    return true;//这里必须返回true，否则会导致操作模式创建失败。
                }

                /*
                 * 在用户选中某个菜单项操作时调用。是响应上下文菜单项操作的地方。
                 */
                @Override
                public boolean onActionItemClicked(ActionMode mode,
                                                   MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_f:
                            /*CrimeAdapter adapter = (CrimeAdapter) getListAdapter();
                            CrimeLab crimeLab = CrimeLab.get(getActivity());
                            for (int i = mAdapter.getCount(); i >= 0; i--) {
                                if(getListView().isItemChecked(i)){
                                    crimeLab.deleteCrime(adapter.getItem(i));
                                }
                            }*/
                            mode.finish();
                            num.remove(item_id);
                            mAdapter.notifyDataSetChanged();
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                    mAdapter.notifyDataSetChanged();
                    updateSeletedCount();
                    mode.invalidate();
                }
                public void updateSeletedCount() {
                    mSelectedCount.setText(Integer.toString(mListView1.getCheckedItemCount()) + " selected");
                }

            });
        }

    }

    @Override

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        //获取对应的item的positon

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        item_id = info.position;

        //设置菜单布局

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.action_menu,menu);

    }


    @Override

    public boolean onContextItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.menu_f:

                num.remove(item_id);

                mAdapter.notifyDataSetChanged();

                break;

        }

        return true;

    }



    public class MyListAdapter extends BaseAdapter {



        private List<String>mData;

        private Context mContext;



        public MyListAdapter(ActionModeAdapter mContext, List<String>mData) {

            this.mContext = mContext;

            this.mData = mData;

        }



        @Override

        public int getCount() {

            return mData.size();

        }



        @Override

        public Object getItem(int position) {

            return 0;

        }



        @Override

        public long getItemId(int position) {

            return 0;

        }



        @Override

        public View getView(int position, View convertView, ViewGroup parent) {

            View view ;

            MyViewHorlder myViewHorlder;

            if (convertView==null) {

                view = LayoutInflater.from(mContext).inflate(R.layout.menu,null);

                myViewHorlder = new MyViewHorlder();

                myViewHorlder.textView = (TextView)view.findViewById(R.id.textView2);


                view.setTag(myViewHorlder);

            }else {

                view = convertView;

                myViewHorlder = (MyViewHorlder) view.getTag();

            }



            myViewHorlder.textView.setText(mData.get(position));

            return view;

        }

        class MyViewHorlder{

            TextView textView;

        }

    }


   /* class MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return num.size();
        }

        @Override
        public Object getItem(int position) {
            return num.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(ActionModeAdapter.this,R.layout.menu,null);
            TextView mTextView = (TextView)view.findViewById(R.id.textView2);
            mTextView.setText(num.get(position));
            return view;
        }

    }*/



}
